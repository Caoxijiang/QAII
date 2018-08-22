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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.qaii.domain.EmpInfo;
import com.qaii.service.EmpInfoService;
import com.qaii.util.CountDatetoNowDays;

import net.sf.json.JSONObject;

@Controller
public class testCheckController {
	@Resource
	private EmpInfoService empremindservice;
	@RequestMapping("tstchk.do")
	public String tstest() {
		return "page/testchk";
	}
	
	//取得所有合同期到期日期小于30天的人员名单
	
	public List<EmpInfo> getContractEndtimePerson(@RequestParam("date") String date) {
		date=CountDatetoNowDays.SDatetoStamp(date,30);
		List<EmpInfo> list=empremindservice.getcontractmsg(date);
		System.out.println("valueis:");
		for(EmpInfo emp:list) {
			System.out.println(emp.toString());
		}
		return list;
	}
	
	//取得所有试用期到期小于30天的人员名单
	@RequestMapping(value="setmsg.do",method=RequestMethod.POST)
	public List<EmpInfo> getTryEndTimePerson(@RequestParam("date") String date){
		date=CountDatetoNowDays.SDatetoStamp(date,30);
		List<EmpInfo> list=empremindservice.gettrymsg(date);
		System.out.println("valueis:");
		for(EmpInfo emp:list) {
			System.out.println(emp.toString());
		}
		return list;
	}
	
	@RequestMapping(value="setdate.do",method=RequestMethod.POST)
	public String testOutput() throws ParseException {
		Map<String,String> map=new HashMap<>();
		map=CountDatetoNowDays.getfistDay(new Date("2018/01/08"));
		System.out.println(map.get("this")+"last is:"+map.get("last"));
		return null;
	}
	
}
