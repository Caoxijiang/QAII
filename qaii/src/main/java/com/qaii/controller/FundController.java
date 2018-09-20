package com.qaii.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qaii.domain.Govfund;
import com.qaii.service.GovFundService;
import com.qaii.util.JsonResult;
import com.qaii.util.Layui;

@Controller
public class FundController {

	@Resource
	private GovFundService govfundService;
	//获取所有基金信息
	@RequestMapping(value="getAllFundMsg.do",method=RequestMethod.POST)
	@ResponseBody
	public Layui getAllFundMsg() {
		List<Govfund> result=govfundService.getAllFundMsg();
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
	//删除基金信息
	@RequestMapping("dellFundMsg.do")
	@ResponseBody
	public JsonResult dellFundMsg(@RequestParam("requestDate[]") Integer[] eid){
		int row=govfundService.deleteMsg(eid);
    	if(row!=0) {
    		return  new JsonResult(row);
    	}else {
    		return  new JsonResult();
    		
    	}
	}
}
