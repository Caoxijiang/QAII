package com.qaii.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qaii.domain.Govplatform;
import com.qaii.service.GovPlatformService;
import com.qaii.util.JsonResult;
import com.qaii.util.Layui;

@Controller
public class PlatformController {
	
	@Resource
	private GovPlatformService govplatformService;
	//获取所有资助平台信息
	@RequestMapping(value="getAllPlatformMsg.do",method=RequestMethod.POST)
	@ResponseBody
	public Layui getAllPlatformMsg() {
		List<Govplatform> result=govplatformService.getAllPlatformMsg();
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
	//删除资助平台信息
	@RequestMapping("dellPlatformMsg.do")
	@ResponseBody
	public JsonResult dellPlatformMsg(@RequestParam("requestDate[]") Integer[] eid){
		int row=govplatformService.deleteMsg(eid);
    	if(row!=0) {
    		return  new JsonResult(row);
    	}else {
    		return  new JsonResult();
    		
    	}
	}

}
