package com.qaii.controller;
import com.qaii.domain.SigningAgreement;
import com.qaii.domain.SigningAgreementFiles;
import com.qaii.service.SigningAgreementFilesService;
import com.qaii.service.SigningAgreementService;
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
 * Created by kunpeng on 2019/1/21 9:45
 */
@Controller
public class SigningAgreementController {
    @InitBinder
    protected void init(HttpServletRequest request, ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @Resource
    private SigningAgreementService signingAgreementService;
    @Resource
    private SigningAgreementFilesService signingAgreementFilesService;
    //文件位置//数据库中记录的路径
    private final static String BASE_PATH = "Enc/industry/SigningAgreement/";
    //文件路径 本机路径
    private final static String FILE_PATH = ConstantUtil.FILE_UPLOAD_PATH + BASE_PATH;

    //插入记录
    @RequestMapping(value = "insertSigningAgreement.do", produces = "text/json;charset=UTF-8")
    String insertSigningAgreement(HttpServletRequest request, @RequestParam("file") MultipartFile[] files, SigningAgreement record, SigningAgreementFiles filesRecord) throws Exception {
        LoadData(request, record);
        record.setCreateTime(new Date());
        record.setModifyTime(new Date());
        int result = signingAgreementService.insertSelective(record);
        List list = FileLoadUtils.moveFileAndReturnName(files, FILE_PATH);
        for (int i = 0; i < files.length; i++) {
            String fileName = files[i].getOriginalFilename();
            if (fileName == null || fileName.equals("")) {
                filesRecord = (SigningAgreementFiles) FileLoadToNull.getNullClass("SigningAgreementFiles");
                filesRecord.setSigningagreementId(record.getId());
                signingAgreementFilesService.insertSelective(filesRecord);
            } else {
                filesRecord.setSigningagreementId(record.getId())  ;
                filesRecord.setFileName(files[i].getOriginalFilename());
                filesRecord.setFilePath(BASE_PATH + list.get(i));
                filesRecord.setFileCreatetime(new Date());
                filesRecord.setFileModifytime(new Date());
                signingAgreementFilesService.insertSelective(filesRecord);
            }
        }
        if (result != 0) {
            return ConstantUtil.INDUSTRY_INSERT_SUCCESS;
        } else {
            return ConstantUtil.INDUSTRY_INSERT_FAILD;
        }
    }


    //显示所有记录
    @RequestMapping(value = "listSigningAgreement.do")
    @ResponseBody
    Layui listCooperations() throws ParseException {
        List result = signingAgreementService.listRecords();
        return Layui.data(result.size(), result);
    }


    public void LoadData(HttpServletRequest request, SigningAgreement record) throws Exception {
        record.setDirectionCooperation(request.getParameter("directionCooperation"));
        record.setSigningTime(request.getParameter("signingTime"));
        record.setColleageIncubator(request.getParameter("colleageIncubator"));
        record.setCooperationUnit(request.getParameter("cooperationUnit"));
        record.setRemake(request.getParameter("remake"));
    }

    //查看详情
    @RequestMapping(value = "getSigningAgreement.do")
    @ResponseBody
    SigningAgreement getCooperation(@RequestParam("id") Integer id) throws ParseException {
        SigningAgreement signingAgreement = signingAgreementService.getRecord(id);
        return signingAgreementService.getRecord(id);
    }

    //文件重新上传
    @RequestMapping("reloadSigningAgreementFile.do")
    String reloadSigningAgreementFile(HttpServletRequest request,
                                      @RequestParam("file") MultipartFile[] files,
                                      SigningAgreementFiles record) throws IOException {
        record.setSigningagreementId(Integer.parseInt(request.getParameter("id")));
        record.setId(Integer.parseInt(request.getParameter("fid")));
        String id = request.getParameter("fid");
        String path = request.getParameter("fpath");
        DeleteFileUtil.delete(ConstantUtil.FILE_UPLOAD_PATH + request.getParameter("fpath"));
        List<String> list = FileLoadUtils.moveFileAndReturnName(files, FILE_PATH);
        record.setFilePath(BASE_PATH + list.get(0));
        record.setFileName(files[0].getOriginalFilename());
        record.setFileModifytime(new Date());
        int result = signingAgreementFilesService.updateByPrimaryKey(record);
        if (result != 0) {
            return ConstantUtil.INDUSTRY_EDIT_SUCCESS;
        } else {
            return ConstantUtil.INDUSTRY_EDIT_FAILD;
        }

    }


    //修改信息
    @RequestMapping(value = "updateSigningAgreement.do")
    String updateSigningAgreement(HttpServletRequest request, SigningAgreement record) throws Exception {
        record.setId(Integer.parseInt(request.getParameter("id")));
        LoadData(request, record);
        record.setModifyTime(new Date());
        int result = signingAgreementService.updateByPrimaryKeySelective(record);
        if (result != 0) {
            return ConstantUtil.INDUSTRY_EDIT_SUCCESS;
        } else {
            return ConstantUtil.INDUSTRY_EDIT_FAILD;
        }

    }

    //通过Excel导入数据库
    @RequestMapping(value = "insertSigningAgreementWithExcel.do")
    @ResponseBody
    JsonResult insertSigningAgreementWithExcel(@RequestParam("file") MultipartFile file) throws Exception {
        int result = InsertOfExcel.insertExcel("SigningAgreementController", "SigningAgreement", file);
        if (result == 1) {
            return new JsonResult(ConstantUtil.SUCCESS_MESSAGE);
        } else {
            return  new JsonResult();
        }

    }

    //导入Excel数据
    void insertExcelData(SigningAgreement record, List<String> list) throws Exception {
        WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
        signingAgreementService = (SigningAgreementService) wac.getBean("SigningAgreementService");
        signingAgreementFilesService = (SigningAgreementFilesService) wac.getBean("SigningAgreementFilesService");
        loadDataWithList(record, list);
        signingAgreementService.insertSelective(record);
        SigningAgreementFiles  filesRecord = (SigningAgreementFiles) FileLoadToNull.getNullClass("SigningAgreementFiles");
        filesRecord.setSigningagreementId(record.getId());
        signingAgreementFilesService.insertSelective(filesRecord);

    }

    void loadDataWithList(SigningAgreement record, List<String> list) throws Exception {
        record.setDirectionCooperation(list.get(0));
        record.setSigningTime(list.get(1));
        record.setColleageIncubator(list.get(2));
        record.setCooperationUnit(list.get(3));
        record.setRemake(list.get(4));
        record.setCreateTime(new Date());
        record.setModifyTime(new Date());
    }

    //删除信息
    @RequestMapping(value = "deleteSigningAgreement.do")
    @ResponseBody
    JsonResult deleteCooperation(@RequestParam("requestDate[]") Integer[] id) {
    int result=signingAgreementService.deleteByPrimaryKey(id);
    if (result !=0){
        SigningAgreementFiles sin=signingAgreementFilesService.selectFilePathBysigningagreementId(id);
        DeleteFileUtil.delete(ConstantUtil.FILE_UPLOAD_PATH + sin.getFilePath());
        signingAgreementFilesService.deleteByPrimaryKey(id);
        return new JsonResult("success!");
    }else{
        return new JsonResult();
    }

    }

}