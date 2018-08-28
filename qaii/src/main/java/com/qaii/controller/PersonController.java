package com.qaii.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qaii.domain.EmpInfo;
import com.qaii.service.EmpInfoService;
import com.qaii.util.CountDatetoNowDays;

@Controller
public class PersonController {
	@Resource
	private EmpInfoService empinfoservice;
	
	@RequestMapping("personal.do")
	public String personal() {
		return "page/personnel/indexPersonnel";
	}
	
	@RequestMapping("intoPerSys.do")
	public String intoPerSys() {
		return "page/personnel/personnel";
	}
	
	@RequestMapping("intoPerSysadd.do")
	public String intoPerSysadd() {
		return "page/personnel/addPersonnel";
	}
	
	
	//取得每个月的新入职、离职、净增长、院总人数
	public Map<String, Integer> geteachMonthMsg(String date) throws ParseException{
		Map<String, Integer> result=new HashMap<>();
		Date dat=new Date(date);
		Map<String, String> map=CountDatetoNowDays.SgetfistDay(dat);
		//取得当月新入职的人数
		result.put("Entry", empinfoservice.countEntry(CountDatetoNowDays.SDatetoStamp(map.get("last")), CountDatetoNowDays.SDatetoStamp(map.get("this"))));
		//获取当月离职的人数
		result.put("Departure", empinfoservice.countDepart(CountDatetoNowDays.SDatetoStamp(map.get("last")), CountDatetoNowDays.SDatetoStamp(map.get("this"))));
		//取得当月净增长数据
		result.put("Growth", empinfoservice.countEntry(CountDatetoNowDays.SDatetoStamp(map.get("last")), CountDatetoNowDays.SDatetoStamp(map.get("this")))
				-empinfoservice.countDepart(CountDatetoNowDays.SDatetoStamp(map.get("last")), CountDatetoNowDays.SDatetoStamp(map.get("this"))));
		//取得当月院总人数
		result.put("Total", empinfoservice.countnumofcollege(CountDatetoNowDays.SDatetoStamp(map.get("last")), CountDatetoNowDays.SDatetoStamp(map.get("this"))));
		return result;
	}
	
	//取得人才队伍柱状图参数
	public Map<String, Integer> gettalentsTeam(String date){
		Map<String, String> map=new HashMap<>();
		Map<String, Integer> result=new HashMap<>();
		map=CountDatetoNowDays.FirstandEndDayofYear(date);
		result.put("Incnum", empinfoservice.countnumofIncubationComp(CountDatetoNowDays.SDatetoStamp(map.get("last")), CountDatetoNowDays.SDatetoStamp(map.get("this"))));
		result.put("collegenum", empinfoservice.countnumofcollegeComp(CountDatetoNowDays.SDatetoStamp(map.get("last")), CountDatetoNowDays.SDatetoStamp(map.get("this"))));
		result.put("total", empinfoservice.countnumofIncubationComp(CountDatetoNowDays.SDatetoStamp(map.get("last")), CountDatetoNowDays.SDatetoStamp(map.get("this")))
				+empinfoservice.countnumofcollegeComp(CountDatetoNowDays.SDatetoStamp(map.get("last")), CountDatetoNowDays.SDatetoStamp(map.get("this"))));
		return result;
		
	}
	
	//取得人才队伍饼状图数据方法
	public int gettalentsdept(String dept){
		return empinfoservice.countnumfoTalents(dept);
	}
	
	//取得高端人才数据方法
	public int gethighttalents(String title) {
		return empinfoservice.countHigherTalents(title);
		
	}
	
	//取得所有合同期到期日期小于30天的人员名单	
	@RequestMapping(value="getContractMsg.do",method=RequestMethod.POST)
	@ResponseBody
	public List<EmpInfo> getContractEndtimePerson(@RequestParam("date") String date) {
		date=CountDatetoNowDays.DateaddDays(date,30);
		List<EmpInfo> list=empinfoservice.getcontractmsg(CountDatetoNowDays.SDatetoStamp(date));
		for(EmpInfo emp:list) {
			emp.setEmpContractendtime(CountDatetoNowDays.StamptoDate(emp.getEmpContractendtime()));
		}
		return list;
	}
		
	//取得所有试用期到期小于30天的人员名单
	@RequestMapping(value="getTryMsg.do",method=RequestMethod.POST)
	@ResponseBody
	public List<EmpInfo> getTryEndTimePerson(@RequestParam("date") String date){
		date=CountDatetoNowDays.DateaddDays(date,30);
		List<EmpInfo> list=empinfoservice.gettrymsg(CountDatetoNowDays.SDatetoStamp(date));
		for(EmpInfo emp:list) {
			emp.setEmpTryoutendtime(CountDatetoNowDays.StamptoDate(emp.getEmpTryoutendtime()));
		}
		return list;
	}
	
	//获取当前包括当前月的前12个月的日期
	@RequestMapping(value="get12Month.do",method=RequestMethod.POST)
	@ResponseBody
	public List<String> get12Month(@RequestParam("date")String date) throws ParseException{
		List<String> list=new ArrayList<>();
		list=CountDatetoNowDays.getpremonth(date, 12);
//			for(int i=list.size();i>0;i--) {
//				result.add(geteachMonthMsg(list.get(i)));
//			}
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
	
	//获取人事管理主页曲线图的数据（本月人数增减情况）
	@RequestMapping(value="geteachMonthMsg.do",method=RequestMethod.POST)
	@ResponseBody
	public List<Map> getPergraphs(@RequestParam("date[]") List<String> date) throws ParseException{
		List <Map> result=new ArrayList<>();
//		list= get12Month(date);
		for(String str:date) {
			result.add(geteachMonthMsg(str));
		}
		return result;
		
	}
	//获取人事管理主页柱形图的数据（人才队伍）
	@RequestMapping(value="gettalentsTeam.do",method=RequestMethod.POST)
	@ResponseBody
	public List<Map> getPercolumns(@RequestParam("date[]") List<String> date){
		List <Map> result=new ArrayList<>();
//		list= get8Years(date);
		for(String str:date) {
			result.add(gettalentsTeam(str));
		}
		return result;
		
	}
	
	//获取高端人才数据
	@RequestMapping(value="getTitleMsg.do",method=RequestMethod.POST)
	@ResponseBody
	public List<Integer> getHighertalentsMsg(@RequestParam("data[]")String[] title){
		List<Integer> result=new ArrayList<>();
		for(int i=0;i<title.length;i++) {
			result.add(gethighttalents(title[i]));
		}
		return result;
	}

	//取得人才队伍饼状图
	@RequestMapping(value="gettalentsdept.do",method=RequestMethod.POST)
	@ResponseBody
	public List<Integer> gettalentsdeptMsg(@RequestParam("data[]")String[] title){
		List<Integer> result=new ArrayList<>();
		for(int i=0;i<title.length;i++) {
			result.add(gettalentsdept(title[i]));
		}
		return result;
	}
}
