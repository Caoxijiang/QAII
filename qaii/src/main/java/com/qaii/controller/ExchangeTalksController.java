package com.qaii.controller;

import com.qaii.domain.ExchangeTalks;
import com.qaii.domain.ExchangeTalksFiles;
import com.qaii.service.ExchangeTalksService;
import com.qaii.util.CountDatetoNowDays;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kunpeng on 2019/1/18 13:35
 */
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
    private ExchangeTalksService exchangeTalksService;

    private final static String BASE_PATH="C:/File/industry/ExchangeTalks";
    //交流座谈添加
    @RequestMapping(value = "addExchangeTalks.do", produces = "text/json;charset=UTF-8")
    public String addExchangeTalks(HttpServletRequest request, @RequestParam("file") MultipartFile[] files, ExchangeTalks exchangeTalks, ExchangeTalksFiles exchangeTalksFiles) throws Exception {
        exchangeTalks.setParticipant(request.getParameter("participant"));
        exchangeTalks.setTargetAudience(request.getParameter("targetAudience"));
        exchangeTalks.setThemeTalks(request.getParameter("themeTalks"));
        exchangeTalks.setTalksAddress(request.getParameter("talksAddress"));
        exchangeTalks.setTalksTime(CountDatetoNowDays.StringConvertToDate(request.getParameter("talksTime")));
        exchangeTalks.setCreateTime(new Date());
        //插入基本数据
        int result = exchangeTalksService.insert(exchangeTalks);
        //插入上传文件

        return null;
    }

}
