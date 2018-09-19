package com.qaii.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qaii.domain.Softwarecopyright;
import com.qaii.service.SoftwarecopyrightService;
import com.qaii.util.JsonResult;
import com.qaii.util.Layui;

@Controller
public class SoftwareController {
	
	@Resource
	private SoftwarecopyrightService softwareService;

	//获取所有软著信息
		@RequestMapping(value="getAllSoftwareMsg.do",method=RequestMethod.POST)
		@ResponseBody
		public Layui getAllSoftwareMsg() {
			List<Softwarecopyright> result=softwareService.getAllSoftwareMsg();
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
		
		//软著信息删除功能
		@RequestMapping("dellsoftMsg.do")
		@ResponseBody
		public JsonResult dellSoftMsg(@RequestParam("requestDate[]") Integer[] eid){
			int row=softwareService.dellsoftMsg(eid);
	    	if(row!=0) {
	    		return  new JsonResult(row);
	    	}else {
	    		return  new JsonResult();
	    		
	    	}
		}
}
