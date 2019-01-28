

package com.qaii.controller;
import com.qaii.domain.IndustryExchangeTalks;
import com.qaii.domain.IndustryExchangeTalksFiles;
import com.qaii.service.IndustryExchangeTalksFilesService;
import com.qaii.service.IndustryExchangeTalksService;
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


/**
 * Created by kunpeng on 2019/1/18 13:35
**/


//交流座谈控制层
@Controller
public class ExchangeTalksController {

    @InitBinder
    protected void init(HttpServletRequest request, ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @Resource
    private IndustryExchangeTalksService industryExchangeTalksService;
    @Resource
    private IndustryExchangeTalksFilesService industryExchangeTalksFilesService;

    //文件位置//数据库中记录的路径
    private final static String BASE_PATH = "img/industry/ExchangeTalks/";
    //文件路径 本机路径
    private final static String FILE_PATH = ConstantUtil.FILE_BASE_PATH + BASE_PATH;

    //插入记录
    @RequestMapping(value = "insertExchangeTalks.do", produces = "text/json;charset=UTF-8")
    String insertSigningAgreement(HttpServletRequest request, @RequestParam("file") MultipartFile[] files, IndustryExchangeTalks record, IndustryExchangeTalksFiles filesRecord) throws Exception {
        LoadData(request, record);
        record.setCreateTime(new Date());
        record.setModifyTime(new Date());
        int result = industryExchangeTalksService.insertSelective(record);
        List list = FileLoadUtils.moveFileAndReturnName(files, FILE_PATH);
        for (int i = 0; i < files.length; i++) {
            String fileName = files[i].getOriginalFilename();
            if (fileName==null || fileName.equals("")){
                filesRecord = (IndustryExchangeTalksFiles) FileLoadToNull.getNullClass("IndustryExchangeTalksFiles");
                filesRecord.setExchangetalksId(record.getId());
                industryExchangeTalksFilesService.insertSelective(filesRecord);
            }else{
                filesRecord.setExchangetalksId(record.getId());
                filesRecord.setFileName(files[i].getOriginalFilename());
                filesRecord.setFilePath(BASE_PATH+list.get(i));
                filesRecord.setFileCreatetime(new Date());
                filesRecord.setFileModifytime(new Date());
                industryExchangeTalksFilesService.insertSelective(filesRecord);

            }
        }
        if (result !=0){
            return ConstantUtil.INDUSTRY_INSERT_SUCCESS;
        }else{
            return ConstantUtil.INDUSTRY_INSERT_FAILD;
        }
    }

    public void LoadData(HttpServletRequest request, IndustryExchangeTalks record) throws Exception {
        record.setParticipant(request.getParameter("participant"));
        record.setTargetAudience(request.getParameter("targetAudience"));
        record.setThemeTalks(request.getParameter("themeTalks"));
        record.setTalksAddress(request.getParameter("talksAddress"));
        record.setTalksTime(request.getParameter("talksTime"));
        record.setRemark(request.getParameter("remark"));

    }

    //查询所有记录
    @RequestMapping(value = "listExchangeTalks.do")
    @ResponseBody
    Layui listExchangeTalks() throws ParseException {
        List result = industryExchangeTalksService.listRecords();
        return Layui.data(result.size(), result);
    }

    //查看详情
    @RequestMapping(value = "getExchangeTalks.do")
    @ResponseBody
    IndustryExchangeTalks getExchangeTalks(@RequestParam("id") Integer id) throws ParseException {
        return industryExchangeTalksService.getRecords(id);
    }

//文件重新上传
    @RequestMapping("reloadExchangeTalks.do")
    String reloadSigningAgreementFile(HttpServletRequest request,
                                      @RequestParam("file") MultipartFile[] files,
                                      IndustryExchangeTalksFiles record) throws IOException {
        record.setExchangetalksId(Integer.parseInt(request.getParameter("id")));
        record.setId(Integer.parseInt(request.getParameter("fid")));
        DeleteFileUtil.delete(ConstantUtil.FILE_UPLOAD_PATH + request.getParameter("fpath"));
        List<String> list = FileLoadUtils.moveFileAndReturnName(files, FILE_PATH);
        record.setFilePath(BASE_PATH + list.get(0));
        record.setFileName(files[0].getOriginalFilename());
        record.setFileModifytime(new Date());
        int result=industryExchangeTalksFilesService.updateByPrimaryKey(record);
        if (result !=0){
            return ConstantUtil.INDUSTRY_EDIT_SUCCESS;
        }else{
            return ConstantUtil.INDUSTRY_EDIT_FAILD;
        }

    }

    //修改信息
    @RequestMapping(value = "updateExchangeTalks.do")
    String updateExchangeTalks(HttpServletRequest request, IndustryExchangeTalks record) throws Exception {
        record.setId(Integer.parseInt(request.getParameter("id")));
        LoadData(request, record);
        record.setModifyTime(new Date());
        int result=industryExchangeTalksService.updateByPrimaryKeySelective(record);
        if (result !=0){
            return ConstantUtil.INDUSTRY_EDIT_SUCCESS;
        }else{
            return ConstantUtil.INDUSTRY_EDIT_FAILD;
        }
    }

    //导入Excel到数据库
    @RequestMapping(value = "insertExchangeTalksWithExcel.do")
    @ResponseBody
    JsonResult insertExchangeTalksWithExcel(@RequestParam("file") MultipartFile file) throws Exception {
        int result = InsertOfExcel.insertExcel("ExchangeTalksController", "IndustryExchangeTalks", file);
        if (result == 1) {
            return new JsonResult(ConstantUtil.SUCCESS_MESSAGE);
        } else {
            return  new JsonResult();
        }
    }

    //导入Excel数据
    void insertExcelData(IndustryExchangeTalks record, List<String> list) throws Exception {
        WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
        industryExchangeTalksService = (IndustryExchangeTalksService) wac.getBean("industryExchangeTalksService");
        industryExchangeTalksFilesService = (IndustryExchangeTalksFilesService) wac.getBean("industryExchangeTalksFilesService");
        loadDataWithList(record, list);
        industryExchangeTalksService.insertSelective(record);

        IndustryExchangeTalksFiles  filesRecord = (IndustryExchangeTalksFiles) FileLoadToNull.getNullClass("IndustryExchangeTalksFiles");
        filesRecord.setExchangetalksId(record.getId());
        industryExchangeTalksFilesService.insertSelective(filesRecord);
    }

    void loadDataWithList(IndustryExchangeTalks record, List<String> list) throws Exception {
        record.setParticipant(list.get(0));
        record.setTargetAudience(list.get(1));
        record.setThemeTalks(list.get(2));
        record.setTalksAddress(list.get(3));
        record.setTalksTime(list.get(4));
        record.setRemark(list.get(5));
    }

    //删除接口
    @RequestMapping(value = "deleteExchangeTalks.do")
    @ResponseBody
    JsonResult deleteExchangeTalks(@RequestParam("requestDate[]") Integer[] id) {
        int result=industryExchangeTalksService.deleteByPrimaryKey(id);
        if (result !=0){
            IndustryExchangeTalksFiles in=industryExchangeTalksFilesService.selectFilePathByexchangetalksId(id);
            DeleteFileUtil.delete(ConstantUtil.FILE_UPLOAD_PATH + in.getFilePath());
            industryExchangeTalksFilesService.deleteByPrimaryKey(id);
            return new JsonResult("success!");
        }else{
            return new JsonResult();
        }
    }
}


