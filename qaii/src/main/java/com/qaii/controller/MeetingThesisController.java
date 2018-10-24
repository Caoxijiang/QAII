package com.qaii.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import com.qaii.domain.MeetingThesis;
import com.qaii.service.MeetingThesisService;
import com.qaii.util.JsonResult;
import com.qaii.util.Layui;

@Controller
public class MeetingThesisController {

	@Resource
	private MeetingThesisService Service;
	
	//查看所有信息
	Layui listMeetingThesis(){
		List<MeetingThesis> result = Service.listAllMessage();
		int count=result.size();
		if(count > 0) {
			return Layui.data(count, result);
		}else {
			return Layui.data(count, null);
		}
	}
	
	//删除信息
	JsonResult deleteMessages(@RequestParam("requestDate[]") Integer[] id) {
		int result = Service.deleteMessages(id);
		if (result > 0) {
			return new JsonResult(result);
		}else {
			return new JsonResult();
		}
	}
	
	//查看详情
	JsonResult getMessage(HttpServletRequest req) {
		MeetingThesis result = Service.getMessage(Long.parseLong(req.getParameter("id")));
		if(!result.equals(null)) {
			return new JsonResult(result);
		}else {
			return new JsonResult();
		}
	}
}
