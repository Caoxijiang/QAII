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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.qaii.domain.EmpInfo;
import com.qaii.service.EmpInfoService;
import com.qaii.service.impl.EmpInfoServiceImpl;
import com.qaii.util.CountDatetoNowDays;

import net.sf.json.JSONObject;

@Controller
public class testCheckController {
	@Resource
	private EmpInfoService empinfoservice;
	@RequestMapping("tstchk.do")
	public String tstest() {
		return "page/testchk";
	}
	
	@RequestMapping(value="setdata.do",method=RequestMethod.POST)
	@ResponseBody
	public String outputStamp(@RequestParam(value="date",required=false)String date
			) throws ParseException {
		System.out.println(geteachMonthMsg(date));
		return CountDatetoNowDays.SDatetoStamp(date);
	}
	
	@RequestMapping(value="setdata2.do",method=RequestMethod.POST)
	@ResponseBody
	public String outputDate(@RequestParam(value="date",required=false)String date
			){
		return CountDatetoNowDays.StamptoDate(date);
	}
	
	//取得每个月的新入职、离职、净增长、院总人数
	public Map<String, Integer> geteachMonthMsg(String date) throws ParseException{
		Map<String, Integer> result=new HashMap<>();
		Date dat=new Date(date);
		Map<String, String> map=CountDatetoNowDays.getfistDay(dat);
		//取得当月新入职的人数
		result.put("Entry", empinfoservice.countEntry(map.get("last"), map.get("this")));
		//获取当月离职的人数
		result.put("Departure", empinfoservice.countDepart(map.get("last"), map.get("this")));
		//取得当月净增长数据
		result.put("Growth", empinfoservice.countEntry(map.get("last"), map.get("this"))-empinfoservice.countDepart(map.get("last"), map.get("this")));
		//取得当月院总人数
		result.put("Total", empinfoservice.countnumofcollege(map.get("last"), map.get("this")));
		return result;
	}
				
	//取得所有合同期到期日期小于30天的人员名单	
	public List<EmpInfo> getContractEndtimePerson(@RequestParam("date") String date) {
		date=CountDatetoNowDays.SDatetoStamp(date,30);
		List<EmpInfo> list=empinfoservice.getcontractmsg(date);
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
		List<EmpInfo> list=empinfoservice.gettrymsg(date);
		System.out.println("valueis:");
		for(EmpInfo emp:list) {
			System.out.println(emp.toString());
		}
		return list;
	}
	
	
	
}
