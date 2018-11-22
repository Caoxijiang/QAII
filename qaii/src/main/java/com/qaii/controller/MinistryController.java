package com.qaii.controller;

import com.qaii.domain.Ministry;
import com.qaii.domain.MinistryFile;
import com.qaii.service.MinistryFileService;
import com.qaii.service.MinistryService;
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
 * @Company: 青岛智能产业技术研究院
 *
 * @author: wangxin
 *
 * @Descrpiton: 服务企业控制器
 *
 * @Time 2018/11/15
 */

@Controller
public class MinistryController {

    //加入此注解，可使前台日期类型的数据向后台传递时不报错
    @InitBinder
    protected void init(HttpServletRequest request, ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }


    @Resource
    private MinistryService service;
    @Resource
    private MinistryFileService fileService;


    private final static String TEST_PATH = "/Users/wangxin/File/";

    //文件位置
    private final static String BASE_PATH = "industry/Ministry/";
    //文件类型
    public final static String FILE_CERTIFY = "certify";
    //文件路径 本机路径为/Users/wangxin/File
    //private final static String FILE_PATH = ConstantUtil.FILE_BASE_PATH + BASE_PATH;
    private final static String FILE_PATH = TEST_PATH + BASE_PATH;
    //数据库中记录的路径
    private final static String DATABASE_PATH = ConstantUtil.DATABASE_BASE_PATH + BASE_PATH;


    //插入记录
    @RequestMapping(value = "insertMinistry.do" ,produces = "text/json;charset=UTF-8" )
    String insertMinistry(HttpServletRequest request,
                          @RequestParam("file") MultipartFile[] files,
                          Ministry record,
                          MinistryFile fileRecord) throws IOException, ParseException {
        //装载属性
        LoadData(request, record);
        //装载文件类属性
        LoadFileData(fileRecord);
        record.setGmtCreate(new Date());
        record.setGmtModified(new Date());
        int result=service.insertRecordReturnID(record);
        fileRecord.setIncubatorId(record.getId());
        //存储文件
        List list = FileLoadUtils.moveFileAndReturnName(files, FILE_PATH);
        //向数据库添加记录
        for (int i=0;i<files.length;i++) {
            fileRecord.setFileName(files[i].getOriginalFilename());
            fileRecord.setFilePath(DATABASE_PATH + list.get(i));
            fileService.insertRecord(fileRecord);
        }
        //如果无文件，添加一条空记录
        if(files.length==0)
            fileService.insertRecord(fileRecord);
        if (result!=0)
            return ConstantUtil.INDUSTRY_INSERT_SUCCESS;
        else
            return ConstantUtil.INDUSTRY_INSERT_FAILD;
    }

    void LoadFileData(MinistryFile fileRecord) {
        fileRecord.setFileStyle(FILE_CERTIFY);
        fileRecord.setGmtCreate(new Date());
        fileRecord.setGmtModified(new Date());
    }

    void LoadData(HttpServletRequest request, Ministry record) throws ParseException {
        record.setMinistryName(request.getParameter("ministryName"));
        record.setMinistryProperty(request.getParameter("ministryProperty"));
        record.setContactPerson(request.getParameter("contactPerson"));
        record.setContactMethod(request.getParameter("contactMethod"));
        record.setMinistryLocation(request.getParameter("ministryLocation"));
        record.setMinistryTime(CountDatetoNowDays.StringConvertToDate(request.getParameter("ministryTime")));
        record.setMinistryProject(request.getParameter("ministryProject"));
        record.setOwnselfUnit(request.getParameter("ownselfUnit"));
        record.setOwnselfContactPerson(request.getParameter("ownselfContactPerson"));
        record.setOwnselfContactMethod(request.getParameter("ownselfContactMethod"));
        record.setRemark(request.getParameter("remark"));
    }

    //显示所有信息
    @RequestMapping(value = "listMinistries.do")
    @ResponseBody
    public Layui listMinistries() throws ParseException {
        return Layui.data(1,service.listRecords());
    }

    //查看详情
    @RequestMapping(value = "getMinistry.do")
    @ResponseBody
   public JsonResult getMinistry(@RequestParam("id")Integer id) throws ParseException {
        return new JsonResult(service.getRecord(id));
    }

    //更新信息
    @RequestMapping(value = "updateMinistry.do")
    String updateMinistry(HttpServletRequest request, Ministry record) throws ParseException {
        record.setId(Integer.parseInt(request.getParameter("id")));
        LoadData(request, record);
        record.setGmtModified(new Date());
        int result = service.updateByPrimaryKey(record);
        if (result!=0)
            return ConstantUtil.INDUSTRY_EDIT_SUCCESS;
        else
            return ConstantUtil.INDUSTRY_EDIT_FAILD;
    }

    //删除信息
    @RequestMapping(value = "deleteMinistry.do")
    @ResponseBody
    JsonResult deleteMinistry(@RequestParam("requestDate[]")Integer[] id){
        int result = service.deleteByPrimaryKeys(id);
        if (result != 0)
            return new JsonResult("success!");
        else
            return new JsonResult();
    }

    //通过Excel导入到数据库中
    @RequestMapping(value = "insertMinistryWithExcel.do")
    @ResponseBody
    public JsonResult insertMinistryWithExcel(@RequestParam("file")MultipartFile file) throws Exception{
        int result = InsertOfExcel.insertExcel("MinistryController", "Ministry", file);
        if (result == 1) {
            return new JsonResult(ConstantUtil.SUCCESS_MESSAGE);
        }else {
            return new JsonResult();
        }
    }

    //导入Excel数据
    void insertExcelData(Ministry record, List<String> list) throws Exception {
        WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
        service = (MinistryService)wac.getBean("ministryService");
        fileService = (MinistryFileService)wac.getBean("ministryFileService");
        loadDataWithList(record, list);
        record.setId(null);
        service.insertRecordReturnID(record);
        MinistryFile fileRecord = (MinistryFile) FileDomainFactory.getNullClass("MinistryFile");
        fileRecord.setIncubatorId(record.getId());
        fileService.insertRecord(fileRecord);
    }

    void loadDataWithList(Ministry record, List<String> list) throws ParseException {
        //排空
        if (!list.get(0).isEmpty())
            record.setMinistryName(list.get(0));
        if (!list.get(1).isEmpty())
            record.setMinistryProperty(list.get(1));
        if (!list.get(2).isEmpty())
            record.setContactPerson(list.get(2));
        if (!list.get(3).isEmpty())
            record.setContactMethod(list.get(3));
        if (!list.get(4).isEmpty())
            record.setMinistryLocation(list.get(4));
        if (!list.get(5).isEmpty())
            record.setMinistryTime(CountDatetoNowDays.StringConvertToDate(list.get(5)));
        if (!list.get(6).isEmpty())
            record.setMinistryProject(list.get(6));
        if (!list.get(7).isEmpty())
            record.setOwnselfUnit(list.get(7));
        if (!list.get(8).isEmpty())
            record.setOwnselfContactPerson(list.get(8));
        if (!list.get(9).isEmpty())
            record.setOwnselfContactMethod(list.get(9));
        if (!list.get(10).isEmpty())
            record.setRemark(list.get(10));
        record.setGmtCreate(new Date());
        record.setGmtModified(new Date());
    }

}
