package com.qaii.controller;

import com.qaii.domain.AwardCollege;
import com.qaii.domain.AwardCollegeFile;
import com.qaii.service.AwardCollegeFileService;
import com.qaii.service.AwardCollegeService;
import com.qaii.util.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class AwardCollegeController {

    @Resource
    private AwardCollegeService service;

    @Resource
    private AwardCollegeFileService fileService;

    //文件路径 本机路径为/Users/wangxin/File
    public final static String FILE_PATH= "C:/File/img/MeetingThesis/";
    //数据库中记录的路径
    public final static String DATABASE_PATH="/img/MeetingThesis/";

    String insertAwardCollege(HttpServletRequest request,
                              MultipartFile[] file,
                              AwardCollege record,
                              AwardCollegeFile fileRecord){
        LoadData(request, record);
        int result=service.insertRecordReturnID(record);
        fileRecord.setId(record.getId());
        fileRecord.setFileName(request.getParameter("filename"));
        return null;
    }

    void LoadData(HttpServletRequest request, AwardCollege record) {
        record.setAwardTime(DateUtils.parseStringToDate(request.getParameter("awardTime")));
        record.setAwardLevel(request.getParameter("awardLevel"));
        record.setAwardUnit(request.getParameter("awardUnit"));
        record.setAwardName(request.getParameter("awardName"));
        record.setActivityName(request.getParameter("activityName"));
        record.setOrgnizer(request.getParameter("orgnizer"));
        record.setRemark(request.getParameter("remark"));
        record.setGmtCreate(new Date());
        record.setGmtModified(new Date());
    }
}
