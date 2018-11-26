package com.qaii.controller;

import com.qaii.domain.Cooperation;
import com.qaii.domain.CooperationFile;
import com.qaii.service.CooperationFileService;
import com.qaii.service.CooperationService;
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
 * @Descrpiton: 合作企业控制器类
 * @Time 2018-11-23 10:00
 */
@Controller
public class CooperationController {

    //加入此注解，可使前台日期类型的数据向后台传递时不报错
    @InitBinder
    protected void init(HttpServletRequest request, ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @Resource
    private CooperationService service;
    @Resource
    private CooperationFileService fileService;

    private final static String TEST_PATH = "/Users/wangxin/File/";

    //文件位置
    private final static String BASE_PATH = "industry/Cooperation/";
    //文件类型
    public final static String FILE_CERTIFY = "certify";
    //文件路径 本机路径为/Users/wangxin/File
    //private final static String FILE_PATH = ConstantUtil.FILE_BASE_PATH + BASE_PATH;
    private final static String FILE_PATH = TEST_PATH + BASE_PATH;
    //数据库中记录的路径
    private final static String DATABASE_PATH = ConstantUtil.DATABASE_BASE_PATH + BASE_PATH;

    //插入记录
    @RequestMapping(value = "insertCooperation.do", produces = "text/json;charset=UTF-8")
    String insertCooperation(HttpServletRequest request,
                             @RequestParam("file") MultipartFile[] files,
                             Cooperation record,
                             CooperationFile fileRecord) throws Exception {
        LoadData(request, record);
        record.setGmtCreate(new Date());
        record.setGmtModified(new Date());
        int result = service.insertRecordReturnID(record);
        if (files.length > 0) {
            List list = FileLoadUtils.moveFileAndReturnName(files, FILE_PATH);
            for (int i = 0; i < files.length; i++) {
                fileRecord.setIncubatorId(record.getId());
                fileRecord.setFileName(files[i].getOriginalFilename());
                fileRecord.setFilePath(DATABASE_PATH + list.get(i));
                fileRecord.setGmtCreate(new Date());
                fileRecord.setGmtModified(new Date());
                fileService.insertRecord(fileRecord);
            }
        } else {
            fileRecord = (CooperationFile) FileDomainFactory.getNullClass("CooperationFile");
            fileRecord.setIncubatorId(record.getId());
            fileService.insertRecord(fileRecord);
        }
        if (result != 0)
            return ConstantUtil.INDUSTRY_INSERT_SUCCESS;
        else
            return ConstantUtil.INDUSTRY_INSERT_FAILD;
    }

    void LoadData(HttpServletRequest request, Cooperation record) throws Exception {
        record.setUnitName(request.getParameter("unitName"));
        record.setCooperationName(request.getParameter("cooperationName"));
        record.setProtocolName(request.getParameter("protocolName"));
        record.setSignTime(CountDatetoNowDays.StringConvertToDate(request.getParameter("signTime")));
        record.setCooperationContent(request.getParameter("cooperationContent"));
        record.setRemark(request.getParameter("remark"));
    }

    //显示所有记录
    @RequestMapping(value = "listCooperations.do")
    @ResponseBody
    Layui listCooperations() throws ParseException {
        List result = service.listRecords();
        return Layui.data(result.size(), result);
    }

    //查看详情
    @RequestMapping(value = "getCooperation.do")
    @ResponseBody
    JsonResult getCooperation(@RequestParam("id") Integer id) throws ParseException {
        return new JsonResult(service.getRecord(id));
    }

    //更新信息
    @RequestMapping(value = "updateCooperation.do")
    String updateCooperation(HttpServletRequest request,
                             Cooperation record,
                             CooperationFile fileRecord,
                             @RequestParam("file") MultipartFile[] files) throws Exception {
        record.setId(Integer.parseInt(request.getParameter("id")));
        LoadData(request, record);
        record.setGmtModified(new Date());
        if (!files[0].isEmpty()) {
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
        if (result != 0)
            return ConstantUtil.INDUSTRY_EDIT_SUCCESS;
        else
            return ConstantUtil.INDUSTRY_EDIT_FAILD;
    }

    //删除信息
    @RequestMapping(value = "deleteCooperation.do")
    @ResponseBody
    JsonResult deleteCooperation(@RequestParam("requestDate[]") Integer[] id) {
        int result = service.deleteByPrimaryKeys(id);
        if (result != 0) {
            fileService.deleteByPrimaryKeys(id);
            return new JsonResult("success!");
        } else
            return new JsonResult();
    }

    //通过Excel导入数据库
    @RequestMapping(value = "insertCooperationWithExcel.do")
    @ResponseBody
    JsonResult insertCooperationWithExcel(@RequestParam("file") MultipartFile file) throws Exception {
        int result = InsertOfExcel.insertExcel("CooperationController", "Cooperation", file);
        if (result == 1) {
            return new JsonResult(ConstantUtil.SUCCESS_MESSAGE);
        } else {
            return new JsonResult();
        }
    }

    //导入Excel数据
    void insertExcelData(Cooperation record, List<String> list) throws Exception {
        WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
        service = (CooperationService) wac.getBean("CooperationService");
        fileService = (CooperationFileService) wac.getBean("CooperationFileService");
        loadDataWithList(record, list);
        record.setId(null);
        service.insertRecordReturnID(record);
        CooperationFile fileRecord = (CooperationFile) FileDomainFactory.getNullClass("CooperationFile");
        fileRecord.setIncubatorId(record.getId());
        fileService.insertRecord(fileRecord);
    }

    void loadDataWithList(Cooperation record, List<String> list) throws Exception {
        record.setUnitName(list.get(0));
        record.setCooperationName(list.get(1));
        record.setProtocolName(list.get(2));
        record.setSignTime(CountDatetoNowDays.StringConvertToDate(list.get(3)));
        record.setCooperationContent(list.get(4));
        record.setRemark(list.get(5));
        record.setGmtCreate(new Date());
        record.setGmtModified(new Date());
    }

}
