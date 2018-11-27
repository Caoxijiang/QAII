package com.qaii.controller;

import com.qaii.domain.AwardIncubate;
import com.qaii.domain.AwardIncubateFile;
import com.qaii.service.AwardIncubateFileService;
import com.qaii.service.AwardIncubateService;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Company: 青岛智能产业技术研究院
 * @author: wangxin
 * @Descrpiton:
 * @Time 2018-11-21 15:21
 */
@Controller
public class AwardIncubateController {

    //加入此注解，可使前台日期类型的数据向后台传递时不报错
    @InitBinder
    protected void init(HttpServletRequest request, ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @Resource
    private AwardIncubateService service;
    @Resource
    private AwardIncubateFileService fileService;

    private final static String TEST_PATH = "/Users/wangxin/File/";

    //文件位置
    private final static String BASE_PATH = "industry/AwardIncubate/";
    //文件类型
    public final static String FILE_CERTIFY = "certify";
    //文件路径 本机路径为/Users/wangxin/File
    private final static String FILE_PATH = ConstantUtil.FILE_BASE_PATH + BASE_PATH;
//    private final static String FILE_PATH = TEST_PATH + BASE_PATH;
    //数据库中记录的路径
    private final static String DATABASE_PATH = ConstantUtil.DATABASE_BASE_PATH + BASE_PATH;

    //插入记录
    @RequestMapping(value = "insertAwardIncubate.do" ,produces = "text/json;charset=UTF-8" )
    String insertAwardIncubate(HttpServletRequest request,
                              @RequestParam("file") MultipartFile[] files,
                              AwardIncubate record,
                              AwardIncubateFile fileRecord) throws Exception {
        LoadData(request, record);
        record.setGmtCreate(new Date());
        record.setGmtModified(new Date());
        int result = service.insertRecordReturnID(record);
        if (!files[0].isEmpty()){
            List list = FileLoadUtils.moveFileAndReturnName(files, FILE_PATH);
            for (int i=0;i<files.length;i++) {
                fileRecord.setHonorId(record.getId());
                fileRecord.setFileName(files[i].getOriginalFilename());
                fileRecord.setFilePath(DATABASE_PATH + list.get(i));
                fileRecord.setGmtCreate(new Date());
                fileRecord.setGmtModified(new Date());
                fileService.insertRecord(fileRecord);
            }
        }else {
            fileRecord = (AwardIncubateFile) FileDomainFactory.getNullClass("AwardIncubateFile");
            fileRecord.setHonorId(record.getId());
            fileService.insertRecord(fileRecord);
        }
        if (result!=0)
            return ConstantUtil.INDUSTRY_INSERT_SUCCESS;
        else
            return ConstantUtil.INDUSTRY_INSERT_FAILD;
    }

    void LoadData(HttpServletRequest request, AwardIncubate record) {
        record.setAwardTime(DateUtils.parseStringToDate(request.getParameter("awardTime")));
        record.setAwardLevel(request.getParameter("awardLevel"));
        record.setAwardUnit(request.getParameter("awardUnit"));
        record.setAwardName(request.getParameter("awardName"));
        record.setActivityName(request.getParameter("activityName"));
        record.setOrgnizer(request.getParameter("orgnizer"));
        record.setRemark(request.getParameter("remark"));
    }

    //显示所有记录
    @RequestMapping(value = "listAwardIncubates.do")
    @ResponseBody
    Layui listAwardIncubates() throws ParseException {
        List result = service.listRecords();
        return Layui.data(result.size(), result);
    }

    //查看详情
    @RequestMapping(value = "getAwardIncubate.do")
    @ResponseBody
    JsonResult getAwardIncubate(@RequestParam("id")Integer id) throws ParseException {
        return new JsonResult(service.getRecord(id));
    }

    //更新信息
    @RequestMapping(value = "updateAwardIncubate.do")
    String updateAwardIncubate(HttpServletRequest request,
                              AwardIncubate record,
                              AwardIncubateFile fileRecord,
                              @RequestParam("file")MultipartFile[] files) throws Exception {
        record.setId(Integer.parseInt(request.getParameter("id")));
        LoadData(request, record);
        record.setGmtModified(new Date());
        if (files.length > 0){
            //删除旧文件，保存新文件
            FileLoadUtils.deleteFileOfPath(request.getParameter("fpath"));
            List list = FileLoadUtils.moveFileAndReturnName(files, FILE_PATH);
            fileRecord.setId(Integer.parseInt(request.getParameter("fid")));
            fileRecord.setFileName(files[0].getOriginalFilename());
            fileRecord.setFilePath(DATABASE_PATH + list.get(0));
            fileRecord.setGmtModified(new Date());
            fileService.updateByPrimaryKey(fileRecord);
        }
        int result = service.updateByPrimaryKey(record);
        if (result!=0)
            return ConstantUtil.INDUSTRY_EDIT_SUCCESS;
        else
            return ConstantUtil.INDUSTRY_EDIT_FAILD;
    }

    //删除信息
    @RequestMapping(value = "deleteAwardIncubate.do")
    @ResponseBody
    JsonResult deleteAwardIncubate(@RequestParam("requestDate[]")Integer[] id){
        int result = service.deleteByPrimaryKeys(id);
        if (result != 0){
            fileService.deleteByPrimaryKeys(id);
            return new JsonResult("success!");
        } else
            return new JsonResult();
    }

    //通过Excel导入数据库
    @RequestMapping(value = "insertAwardIncubateWithExcel.do")
    @ResponseBody
    JsonResult insertAwardIncubateWithExcel(@RequestParam("file")MultipartFile file) throws Exception{
        int result = InsertOfExcel.insertExcel("AwardIncubateController", "AwardIncubate", file);
        if (result == 1) {
            return new JsonResult(ConstantUtil.SUCCESS_MESSAGE);
        }else {
            return new JsonResult();
        }
    }

    //导入Excel数据
    void insertExcelData(AwardIncubate record, List<String> list) throws Exception {
        WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
        service = (AwardIncubateService)wac.getBean("AwardIncubateService");
        fileService = (AwardIncubateFileService)wac.getBean("AwardIncubateFileService");
        loadDataWithList(record, list);
        record.setId(null);
        service.insertRecordReturnID(record);
        AwardIncubateFile fileRecord = (AwardIncubateFile) FileDomainFactory.getNullClass("AwardIncubateFile");
        fileRecord.setHonorId(record.getId());
        fileService.insertRecord(fileRecord);
    }

    void loadDataWithList(AwardIncubate record, List<String> list) throws Exception {
        record.setAwardTime(CountDatetoNowDays.StringConvertToDate(list.get(0)));
        record.setAwardLevel(list.get(1));
        record.setAwardUnit(list.get(2));
        record.setAwardName(list.get(3));
        record.setActivityName(list.get(4));
        record.setOrgnizer(list.get(5));
        record.setRemark(list.get(6));
        record.setGmtCreate(new Date());
        record.setGmtModified(new Date());
    }
}
