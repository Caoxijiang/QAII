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
		System.out.println("the valueis+++++++=+"+CountDatetoNowDays.SgetfistDay(new Date(date)));
		
		return CountDatetoNowDays.SDatetoStamp(date);
	}
	
	@RequestMapping(value="setdata2.do",method=RequestMethod.POST)
	@ResponseBody
	public String outputDate(@RequestParam(value="date",required=false)String date
			){
		return CountDatetoNowDays.StamptoDate(date);
	}
	
	//取得每个月的新入职、离职、净增长、院总人数
	@RequestMapping(value="geteachMonthMsg",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Integer> geteachMonthMsg(@RequestParam("date")String date) throws ParseException{
		Map<String, Integer> result=new HashMap<>();
		Date dat=new Date(date);
		Map<String, String> map=CountDatetoNowDays.SgetfistDay(dat);
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
	@RequestMapping(value="getContractMsg.do",method=RequestMethod.POST)
	@ResponseBody
	public List<EmpInfo> getContractEndtimePerson(@RequestParam("date") String date) {
		date=CountDatetoNowDays.DateaddDays(date,30);
		List<EmpInfo> list=empinfoservice.getcontractmsg(date);
		return list;
	}
	
	//取得所有试用期到期小于30天的人员名单
	@RequestMapping(value="getTryMsg.do",method=RequestMethod.POST)
	@ResponseBody
	public List<EmpInfo> getTryEndTimePerson(@RequestParam("date") String date){
		date=CountDatetoNowDays.DateaddDays(date,30);
		List<EmpInfo> list=empinfoservice.gettrymsg(date);
		return list;
	}
	
	//取得人才队伍柱状图参数
	@RequestMapping(value="gettalentsTeam",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Integer> gettalentsTeam(@RequestParam("date")String date){
		Map<String, String> map=new HashMap<>();
		Map<String, Integer> result=new HashMap<>();
		map=CountDatetoNowDays.FirstandEndDayofYear(date);
		result.put("Incnum", empinfoservice.countnumofIncubationComp(map.get("last"), map.get("this")));
		result.put("collegenum", empinfoservice.countnumofcollegeComp(map.get("last"), map.get("this")));
		result.put("total", empinfoservice.countnumofIncubationComp(map.get("last"), map.get("this"))+empinfoservice.countnumofcollegeComp(map.get("last"), map.get("this")));
		return result;
		
	}
	
	//取得人才队伍饼状图数据方法
	public int gettalentsTeam2(String dept){
		return empinfoservice.countnumfoTalents(dept);
	}
	
	//取得高端人才数据方法
	@RequestMapping(value="getTitleMsg.do",method=RequestMethod.POST)
	@ResponseBody
	public int gethighttalents(@RequestParam("data")String title) {
		return empinfoservice.countHigherTalents(title);
		
	}
	
	//获取当前包括当前月的前12个月的日期
	@RequestMapping(value="get12Month.do",method=RequestMethod.POST)
	@ResponseBody
	public List<String> get12Month(
			@RequestParam("date")String date) throws ParseException{
		List<String> list=new ArrayList<>();
		list=CountDatetoNowDays.getpremonth(date, 12);
//		for(int i=list.size();i>0;i--) {
//			result.add(geteachMonthMsg(list.get(i)));
//		}
		return list;
		
	}
	
	//获取包括当前年的前8年的日期
	@RequestMapping(value="get8Years.do",method=RequestMethod.POST)
	@ResponseBody
	public List<String> get8Years(
			@RequestParam("date")String date) {
		List<String> list=new ArrayList<>();
		list=CountDatetoNowDays.getpreYears(date, 8);
		return list;
	}
	
}
