package com.qaii.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qaii.domain.Govsubject;
import com.qaii.service.GovSubjectService;
import com.qaii.util.JsonResult;
import com.qaii.util.Layui;

@Controller
public class SubjectController {
	
	@Resource
	private GovSubjectService govsubjectService;
	//获取所有政府项目信息
	@RequestMapping(value="getAllSubjectMsg.do",method=RequestMethod.POST)
	@ResponseBody
	public Layui getAllSubjectMsg() {
		List<Govsubject> result=govsubjectService.getAllSubjectMsg();
//			for(Softwarecopyright software:result) {
//				CountDatetoNowDays.TranstoDate(emp);
//			}
		int count =result.size();
		if(result!=null) {
			return Layui.data(count, result);
		}else {
			return Layui.data(count, result);
		}
	}
	//删除政府项目信息
	@RequestMapping("dellSubjectMsg.do")
	@ResponseBody
	public JsonResult dellSubjectMsg(@RequestParam("requestDate[]") Integer[] eid){
		int row=govsubjectService.deleteMsg(eid);
    	if(row!=0) {
    		return  new JsonResult(row);
    	}else {
    		return  new JsonResult();
    		
    	}
	}

}
