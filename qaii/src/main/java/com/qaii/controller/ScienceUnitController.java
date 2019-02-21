package com.qaii.controller;

import com.qaii.domain.ScienceUnit;
import com.qaii.service.ScienceUnitService;
import com.qaii.util.JsonResult;
import com.qaii.util.Layui;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Company: 青岛智能产业技术研究院
 * @author: wangxin
 * @Descrpiton: 科技处单位信息
 * @Time 2019-02-19 9:57
 */

@Controller
public class ScienceUnitController {

    @Resource
    private ScienceUnitService service;

    @RequestMapping("listScienceUnit.do")
    @ResponseBody
    Layui listRecords(){
        List<ScienceUnit> result = service.listRecords();
        return Layui.data(result.size(), result);
    }

    @RequestMapping("insertScienceUnit.do")
    @ResponseBody
    JsonResult insertRecord(ScienceUnit Record, HttpServletRequest request){
        Record.setDeptName(request.getParameter("deptName"));
        return new JsonResult(service.insertRecord(Record));
    }

    @RequestMapping("updateScienceUnit.do")
    @ResponseBody
    JsonResult updateRecord(ScienceUnit Record, HttpServletRequest request){
        Record.setDeptName(request.getParameter("deptName"));
        Record.setId(Integer.parseInt(request.getParameter("id")));
        return new JsonResult(service.updateRecord(Record));
    }

    @RequestMapping("deleteScienceUnit.do")
    @ResponseBody
    JsonResult deleteRecords(@RequestParam("requestDate") Integer[] Id){
        return new JsonResult(service.deleteRecords(Id));
    }
}
