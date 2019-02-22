package com.qaii.controller;

import com.qaii.domain.IncubatorPerson;
import com.qaii.service.IncubatorPersonService;
import com.qaii.util.JsonResult;
import com.qaii.util.Layui;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IncubatorPersonController {

    @Resource
    private IncubatorPersonService service;

    @RequestMapping("insertIncubatorPerson.do")
    @ResponseBody
    JsonResult insertRecord(IncubatorPerson Record, HttpServletRequest request){
        Record.setJobPosition(request.getParameter("jobPosition"));
        Record.setPersonalName(request.getParameter("personalName"));
        Record.setRemark(request.getParameter("hid"));
        return new JsonResult(service.insertRecord(Record));
    }

    @RequestMapping("deleteIncubatorPerson.do")
    @ResponseBody
    JsonResult deleteRecords(@RequestParam("id")Integer[] id){
        return new JsonResult(service.deleteRecords(id));
    }

    @RequestMapping("updateIncubatorPerson.do")
    @ResponseBody
    JsonResult updateRecord(IncubatorPerson Record, HttpServletRequest request){
        Record.setJobPosition(request.getParameter("jobPosition"));
        Record.setPersonalName(request.getParameter("personalName"));
        Record.setId(Integer.parseInt(request.getParameter("id")));
        return new JsonResult(service.updateRecord(Record));
    }

    @RequestMapping("listIncubatorPerson.do")
    @ResponseBody
    Layui listRecords(Integer id){
        List<IncubatorPerson> result = service.listRecords(id);
        return Layui.data(result.size(), result);
    }
}
