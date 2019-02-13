package com.qaii.controller;

import com.qaii.domain.IndustryAttendMeeting;
import com.qaii.domain.IndustryAttendMeetingFiles;
import com.qaii.service.IndustryAttendMeetingFilesService;
import com.qaii.service.IndustryAttendMeetingService;
import com.qaii.util.*;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class AttendMeetingController {
    @InitBinder
    protected void init(HttpServletRequest request, ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @Resource
    private IndustryAttendMeetingService industryAttendMeetingService;
    @Resource
    private IndustryAttendMeetingFilesService industryAttendMeetingFilesService;

    //文件位置//数据库中记录的路径
    private final static String BASE_PATH = "img/industry/AttendMeeting/";
    //文件路径 本机路径
    private final static String FILE_PATH = ConstantUtil.FILE_BASE_PATH + BASE_PATH;

    //查询所有记录
    @RequestMapping(value = "listAttendMeeting.do")
    @ResponseBody
    Layui listExchangeTalks() throws ParseException {
        List result = industryAttendMeetingService.listRecords();
        return Layui.data(result.size(), result);
    }


    //添加数据
    @RequestMapping(value = "insertAttendMeeting.do", produces = "text/json;charset=UTF-8")
    String insertAttendMeeting(HttpServletRequest request, @RequestParam("file") MultipartFile[] files, IndustryAttendMeeting record, IndustryAttendMeetingFiles filesRecord) throws Exception {
        LoadData(request, record);
        record.setCreateTime(new Date());
        record.setModifyTime(new Date());
        int result=industryAttendMeetingService.insertSelective(record);
        List list = FileLoadUtils.moveFileAndReturnName(files, FILE_PATH);
        for (int i = 0; i < files.length; i++) {
            String fileName = files[i].getOriginalFilename();
            if (fileName == null || fileName.equals("")){
                filesRecord = (IndustryAttendMeetingFiles) FileLoadToNull.getNullClass("IndustryAttendMeetingFiles");
                filesRecord.setAttendmeetingId(record.getId());
                industryAttendMeetingFilesService.insertSelective(filesRecord);
            }else{
                filesRecord.setAttendmeetingId(record.getId());
                filesRecord.setFileName(files[i].getOriginalFilename());
                filesRecord.setFilePath(BASE_PATH+list.get(i));
                filesRecord.setFileCreatetime(new Date());
                filesRecord.setFileModifytime(new Date());
                industryAttendMeetingFilesService.insertSelective(filesRecord);
            }
        }
        if (result !=0){
            return ConstantUtil.INDUSTRY_INSERT_SUCCESS;
        }else{
            return ConstantUtil.INDUSTRY_INSERT_FAILD;
        }
    }

    public void LoadData(HttpServletRequest request, IndustryAttendMeeting record) throws Exception {
        record.setConferenceType(request.getParameter("conferenceType"));
        record.setParticipant(request.getParameter("participant"));
        record.setConferenceName(request.getParameter("conferenceName"));
        record.setReportTopics(request.getParameter("reportTopics"));
        record.setMeetingAddress(request.getParameter("meetingAddress"));
        record.setMeetingTime(request.getParameter("meetingTime"));
        record.setRemark(request.getParameter("remark"));

    }

    //查看详情
    @RequestMapping(value = "getAttendMeeting.do")
    @ResponseBody
    JsonResult getAttendMeeting(@RequestParam("id") Integer id) throws ParseException {
        return new JsonResult(industryAttendMeetingService.getRecords(id));
    }


    //删除接口
    @RequestMapping(value = "deleteAttendMeeting.do")
    @ResponseBody
    JsonResult deleteAttendMeeting(@RequestParam("requestDate[]") Integer[] id) {
        int result=industryAttendMeetingService.deleteByPrimaryKey(id);
        if (result !=0){
            List<IndustryAttendMeetingFiles> list=industryAttendMeetingFilesService.selectFilePathByattendmeetingId(id);
            for (IndustryAttendMeetingFiles in:list) {
                DeleteFileUtil.delete(ConstantUtil.FILE_BASE_PATH + in.getFilePath());
            }
            industryAttendMeetingFilesService.deleteByPrimaryKey(id);
            return new JsonResult("success!");
        }else{
            return new JsonResult();
        }
    }

    //文件重新上传
    @RequestMapping("reloadAttendMeeting.do")
    String reloadAttendMeetingFile(HttpServletRequest request,
                                      @RequestParam("file") MultipartFile[] files,
                                   IndustryAttendMeetingFiles record) throws IOException {
        record.setAttendmeetingId(Integer.parseInt(request.getParameter("id")));
        record.setId(Integer.parseInt(request.getParameter("fid")));
        DeleteFileUtil.delete(ConstantUtil.FILE_BASE_PATH + request.getParameter("fpath"));
        List<String> list = FileLoadUtils.moveFileAndReturnName(files, FILE_PATH);
        record.setFileName(files[0].getOriginalFilename());
        record.setFilePath(BASE_PATH + list.get(0));
        record.setFileModifytime(new Date());
        int result=industryAttendMeetingFilesService.updateByPrimaryKey(record);
        if (result !=0){
            return ConstantUtil.INDUSTRY_EDIT_SUCCESS;
        }else{
            return ConstantUtil.INDUSTRY_EDIT_FAILD;
        }
    }

//导入数据库
@RequestMapping(value = "insertAttendMeetingWithExcel.do")
@ResponseBody
JsonResult insertExchangeTalksWithExcel(@RequestParam("file") MultipartFile file) throws Exception {
    int result = InsertOfExcel.insertExcel("AttendMeetingController", "IndustryAttendMeeting", file);
        if (result==1){
            return new JsonResult(ConstantUtil.SUCCESS_MESSAGE);
        }else{
            return new JsonResult();
        }
}

    //导入Excel数据
    void insertExcelData(IndustryAttendMeeting record, List<String> list) throws Exception {
        WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
        industryAttendMeetingFilesService = (IndustryAttendMeetingFilesService) wac.getBean("industryAttendMeetingFilesService");
        industryAttendMeetingService = (IndustryAttendMeetingService) wac.getBean("industryAttendMeetingService");
        loadDataWithList(record, list);
        industryAttendMeetingService.insertSelective(record);

        IndustryAttendMeetingFiles  filesRecord = (IndustryAttendMeetingFiles) FileLoadToNull.getNullClass("IndustryAttendMeetingFiles");
        filesRecord.setAttendmeetingId(record.getId());
        industryAttendMeetingFilesService.insertSelective(filesRecord);
    }

    void loadDataWithList(IndustryAttendMeeting record, List<String> list) throws Exception {
        record.setConferenceType(list.get(0));
        record.setParticipant(list.get(1));
        record.setConferenceName(list.get(2));
        record.setReportTopics(list.get(3));
        record.setMeetingAddress(list.get(4));
        record.setMeetingTime(list.get(5));
        record.setRemark(list.get(6));
    }

    //修改数据
    @RequestMapping(value = "updateAttendMeeting.do")
    String updateAttendMeeting(HttpServletRequest request, IndustryAttendMeeting record) throws Exception {
        record.setId(Integer.parseInt(request.getParameter("id")));
        LoadData(request, record);
        record.setModifyTime(new Date());
        int result=industryAttendMeetingService.updateByPrimaryKeySelective(record);
        if (result !=0){
            return ConstantUtil.INDUSTRY_EDIT_SUCCESS;
        }else{
            return ConstantUtil.INDUSTRY_EDIT_FAILD;
        }
    }
}
