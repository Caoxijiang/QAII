package com.qaii.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qaii.domain.Govreward;
import com.qaii.service.GovRewardService;
import com.qaii.util.JsonResult;
import com.qaii.util.Layui;

@Controller
public class RewardController {
	
	@Resource
	private GovRewardService govrewardService;
	//获取所有政府奖励信息
	@RequestMapping(value="getAllRewardMsg.do",method=RequestMethod.POST)
	@ResponseBody
	public Layui getAllRewardMsg() {
		List<Govreward> result=govrewardService.getAllRewardMsg();
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
	//删除政府奖励信息
	@RequestMapping("dellRewardMsg.do")
	@ResponseBody
	public JsonResult dellRewardMsg(@RequestParam("requestDate[]") Integer[] eid){
		int row=govrewardService.deleteMsg(eid);
    	if(row!=0) {
    		return  new JsonResult(row);
    	}else {
    		return  new JsonResult();
    		
    	}
	}

}
