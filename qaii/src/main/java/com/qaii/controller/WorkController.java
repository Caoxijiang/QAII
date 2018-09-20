package com.qaii.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qaii.domain.Work;
import com.qaii.service.WorkService;
import com.qaii.util.JsonResult;
import com.qaii.util.Layui;

@Controller
public class WorkController {
	
	@Resource
	private WorkService workService;
	//获取所有著作信息
	@RequestMapping(value="getAllWorkMsg.do",method=RequestMethod.POST)
	@ResponseBody
	public Layui getAllWorkMsg() {
		List<Work> result=workService.getAllWorkMsg();
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
	//删除著作信息
	@RequestMapping("dellWorkMsg.do")
	@ResponseBody
	public JsonResult dellWorkMsg(@RequestParam("requestDate[]") Integer[] eid){
		int row=workService.deleteMsg(eid);
    	if(row!=0) {
    		return  new JsonResult(row);
    	}else {
    		return  new JsonResult();
    		
    	}
	}

}
