package com.qaii.controller;

import com.qaii.domain.IncubatorPerson;
import com.qaii.service.IncubatorPersonService;
import com.qaii.util.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IncubatorPersonController {

    @Resource
    private IncubatorPersonService service;

    JsonResult insertRecord(IncubatorPerson Record, HttpServletRequest request){
        return new JsonResult(service.insertRecord(Record));
    }

    JsonResult deleteRecords(@RequestParam("id")Integer[] id){
        return new JsonResult(service.deleteRecords(id));
    }

    JsonResult updateRecord(IncubatorPerson Record, HttpServletRequest request){
        return new JsonResult(service.updateRecord(Record));
    }
}
