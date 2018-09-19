package com.qaii.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qaii.domain.Trademark;
import com.qaii.service.TradeMarkService;
import com.qaii.util.JsonResult;
import com.qaii.util.Layui;

@Controller
public class TradeMarkController {
	@Resource
	private TradeMarkService trademarkService;
	
	//获取所有商标信息
	@RequestMapping(value="getAllTradeMarkMsg.do",method=RequestMethod.POST)
	@ResponseBody
	public Layui getAllTradeMarkMsg() {
		List<Trademark> result=trademarkService.getAllTradeMarkMsg();
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
	//删除商标信息
	@RequestMapping("dellTradeMarkMsg.do")
	@ResponseBody
	public JsonResult dellTradeMarkMsg(@RequestParam("requestDate[]") Integer[] eid){
		int row=trademarkService.deleteMsg(eid);
    	if(row!=0) {
    		return  new JsonResult(row);
    	}else {
    		return  new JsonResult();
    		
    	}
	}

}
