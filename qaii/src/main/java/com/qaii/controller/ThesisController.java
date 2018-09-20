package com.qaii.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qaii.domain.Thesis;
import com.qaii.service.ThesisService;
import com.qaii.util.JsonResult;
import com.qaii.util.Layui;

@Controller
public class ThesisController {

	@Resource
	private ThesisService thesisService;

	//获取所有论文信息
	@RequestMapping(value="getAllThesisMsg.do",method=RequestMethod.POST)
	@ResponseBody
	public Layui getAllThesisMsg() {
		List<Thesis> result=thesisService.getAllThesisMsg();
//		for(Softwarecopyright software:result) {
//			CountDatetoNowDays.TranstoDate(emp);
//		}
		int count =result.size();
		if(result!=null) {
			return Layui.data(count, result);
		}else {
			return Layui.data(count, result);
		}
	}
	//删除论文信息
	@RequestMapping("dellThesisMsg.do")
	@ResponseBody
	public JsonResult dellThesisMsg(@RequestParam("requestDate[]") Integer[] eid){
		int row=thesisService.deleteMsg(eid);
    	if(row!=0) {
    		return  new JsonResult(row);
    	}else {
    		return  new JsonResult();
    		
    	}
	}
}
