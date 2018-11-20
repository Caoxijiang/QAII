package com.qaii.controller;

import com.qaii.domain.IncubatorRecord;
import com.qaii.service.IncubatorRecordService;
import com.qaii.util.DateUtils;
import com.qaii.util.JsonResult;
import com.qaii.util.Layui;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Null;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class IncubatorRecordController {
    @Resource
    private IncubatorRecordService incubatorRecordService;
    //公司变更记录获取
    @ResponseBody
    @RequestMapping(value="selectRecordInfoByinId.do", method=RequestMethod.POST,produces="application/json;charset=UTF-8")
    public Layui selectRecordInfoByinId(@RequestParam(value = "pid")Integer pid){
        if (pid!=null){
            List<IncubatorRecord> list=incubatorRecordService.selectByPrimaryKey(pid);
            int count =list.size();
            if (list!=null){
                System.out.println("www:"+list.toString());
                return Layui.data(count, list);
            }{
                return Layui.data(count, list);
            }
        }else {
            return Layui.data(null,null);
        }

    }

    //更新变更时间
    @ResponseBody
    @RequestMapping(value="updataTime.do", method=RequestMethod.POST,produces="application/json;charset=UTF-8")
    public JsonResult updataTime(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        IncubatorRecord incubatorRecord=new IncubatorRecord();
        try {
            incubatorRecord.setId(Integer.parseInt(req.getParameter("id")));
            String time=req.getParameter("time");
            Date times= DateUtils.parseStringToDate(time);
            incubatorRecord.setChangedTime(times);
        }catch (Exception e){
            return new JsonResult("传入数据为空"+e);
        }
        int row =incubatorRecordService.updataTime(incubatorRecord);
        if(row!=0){
            return new JsonResult(row);
        }else{
            return new JsonResult();
        }

    }

}
