package com.qaii.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.qaii.domain.EmpInfo;
import com.qaii.service.EmpInfoService;
import com.qaii.service.impl.EmpInfoServiceImpl;
import com.qaii.util.CountDatetoNowDays;

import net.sf.json.JSONObject;

@Controller
public class testCheckController {

	@RequestMapping("tstchk.do")
	public String tstest() {
		
		return "page/testchk";
	}
	//将时间转为时间戳方法
	@RequestMapping(value="setdata.do",method=RequestMethod.POST)
	@ResponseBody
	public String outputStamp(@RequestParam(value="date",required=false)String date
			) throws ParseException {
		return CountDatetoNowDays.SDatetoStamp(date);
	}
	//将时间转为时间戳方法
	@RequestMapping(value="setdata2.do",method=RequestMethod.POST)
	@ResponseBody
	public String outputDate(@RequestParam(value="date",required=false)String date
			){
		return CountDatetoNowDays.StamptoDate(date);
	}
	
	
	
}
