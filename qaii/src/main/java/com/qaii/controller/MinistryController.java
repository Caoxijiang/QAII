package com.qaii.controller;

import com.qaii.domain.Ministry;
import com.qaii.domain.MinistryFile;
import com.qaii.service.MinistryFileService;
import com.qaii.service.MinistryService;
import com.qaii.util.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class MinistryController {

    @Resource
    private MinistryService service;
    @Resource
    private MinistryFileService fileService;

    //文件路径 本机路径为/Users/wangxin/File
    public final static String FILE_PATH= "C:/File/img/MeetingThesis/";
    //数据库中记录的路径
    public final static String DATABASE_PATH="/img/MeetingThesis/";
    //文件类型
    public final static String FILE_CERTIFY="certify";

    String insertMinistry(HttpServletRequest request,
                          MultipartFile[] files,
                          Ministry record,
                          MinistryFile fileRecord){
        LoadData(request, record);
        int result=service.insertRecordReturnID(record);
        for (int i=0;i<files.length;i++){

        }
        return null;
    }

    void LoadData(HttpServletRequest request, Ministry record) {
        record.setMinistryName(request.getParameter("ministryName"));
        record.setMinistryProperty(request.getParameter("ministryProperty"));
        record.setContactPerson(request.getParameter("contactPerson"));
        record.setContactMethod(request.getParameter("contactMethod"));
        record.setMinistryLocation(request.getParameter("ministryLocation"));
        record.setMinistryTime(DateUtils.parseStringToDate(request.getParameter("ministryTime")));
        record.setMinistryProject(request.getParameter("ministryProject"));
        record.setOwnselfUnit(request.getParameter("ownselfUnit"));
        record.setOwnselfContactPerson(request.getParameter("ownselfContactPerson"));
        record.setOwnselfContactMethod(request.getParameter("ownselfContactMethod"));
        record.setRemark(request.getParameter("remark"));
        record.setGmtCreate(new Date());
        record.setGmtModified(new Date());
    }
}
