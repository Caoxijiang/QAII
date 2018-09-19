package com.qaii.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.print.DocFlavor.STRING;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.qaii.domain.DeptInfo;
import com.qaii.domain.EmpInfo;
import com.qaii.domain.Govfund;
import com.qaii.domain.Govplatform;
import com.qaii.domain.Govreward;
import com.qaii.domain.Govsubject;
import com.qaii.domain.Softwarecopyright;
import com.qaii.domain.Thesis;
import com.qaii.domain.Trademark;
import com.qaii.domain.Work;
import com.qaii.service.DeptInfoService;
import com.qaii.service.EmpInfoService;
import com.qaii.service.GovFundService;
import com.qaii.service.GovPlatformService;
import com.qaii.service.GovRewardService;
import com.qaii.service.GovSubjectService;
import com.qaii.service.PatentService;
import com.qaii.service.SoftwarecopyrightService;
import com.qaii.service.ThesisService;
import com.qaii.service.TradeMarkService;
import com.qaii.service.WorkService;
import com.qaii.service.impl.EmpInfoServiceImpl;
import com.qaii.util.CountDatetoNowDays;
import com.qaii.util.CustomException;
import com.qaii.util.JsonResult;
import com.qaii.util.Layui;

import net.sf.json.JSONObject;

@Controller
public class testCheckController {

	@Resource
	private EmpInfoService empinfo;
	@Resource
	private DeptInfoService deptinfo;
	
	@Resource
	private PatentService patents;
	@Resource
	private SoftwarecopyrightService software;
	@Resource
	private TradeMarkService trademark;
	@Resource
	private ThesisService thesis;
	@Resource
	private WorkService work;
	@Resource
	private GovFundService govfund;
	@Resource
	private GovPlatformService govplatform;
	@Resource
	private GovSubjectService govsubject;
	@Resource
	private GovRewardService govreward;
	
	@RequestMapping("tstchk.do")
	public String tstest() {
		
		return "page/testchk";
	}
	//将时间转为时间戳方法
	@RequestMapping(value="setdata.do",method=RequestMethod.POST)
	@ResponseBody
	public String outputStamp(@RequestParam(value="date",required=false)String date
			) throws CustomException, ParseException, FileNotFoundException, IOException {

		return CountDatetoNowDays.SDatetoStamp(date);
	}
	//将时间转为时间戳方法
	@RequestMapping(value="setdata2.do",method=RequestMethod.POST)
	@ResponseBody
	public String outputDate(@RequestParam(value="date",required=false)String date
			){
		return CountDatetoNowDays.StamptoDate(date);
	}
	
	@RequestMapping("tsterr.do")
	public void errorpage() throws CustomException {
		throw new CustomException("测试异常成功！");
	}
	
	//测试接口
	@RequestMapping("testinterface.do")
	public void testinterface() {
//		System.out.println("result is"+govfund.getAllFundMsg());
//		System.out.println("result is"+govplatform.getAllPlatformMsg());
//		System.out.println("result is"+govsubject.getAllSubjectMsg());
//		System.out.println("result is"+govreward.getAllRewardMsg());
	} 
	
	//科技成果预览信息
	public Map ScienceAchivementPreview() {
		Map<String, Integer> result=new HashMap<>();
		result.put("Patent", patents.getPatentCount());
		result.put("Software", software.getCountNum());
		result.put("trademark", trademark.getCountNum());
		result.put("thesis", thesis.getCountNum());
		result.put("work", work.getCountNum());
		System.out.println(result);
		return result;
	} 
	
	//获取所有软著信息
	@RequestMapping(value="getAllSoftwareMsg.do",method=RequestMethod.POST)
	@ResponseBody
	public Layui getAllSoftwareMsg() {
		List<Softwarecopyright> result=software.getAllSoftwareMsg();
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
	//软著信息删除功能
	@RequestMapping("dellsoftMsg.do")
	@ResponseBody
	public JsonResult dellSoftMsg(@RequestParam("requestDate[]") Integer[] eid){
		int row=software.dellsoftMsg(eid);
    	if(row!=0) {
    		return  new JsonResult(row);
    	}else {
    		return  new JsonResult();
    		
    	}
	}
	
	
	//获取所有商标信息
	@RequestMapping(value="getAllTradeMarkMsg.do",method=RequestMethod.POST)
	@ResponseBody
	public Layui getAllTradeMarkMsg() {
		List<Trademark> result=trademark.getAllTradeMarkMsg();
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
	//删除商标信息
	@RequestMapping("dellTradeMarkMsg.do")
	@ResponseBody
	public JsonResult dellTradeMarkMsg(@RequestParam("requestDate[]") Integer[] eid){
		int row=trademark.deleteMsg(eid);
    	if(row!=0) {
    		return  new JsonResult(row);
    	}else {
    		return  new JsonResult();
    		
    	}
	}
	
	//获取所有论文信息
	@RequestMapping(value="getAllThesisMsg.do",method=RequestMethod.POST)
	@ResponseBody
	public Layui getAllThesisMsg() {
		List<Thesis> result=thesis.getAllThesisMsg();
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
		int row=thesis.deleteMsg(eid);
    	if(row!=0) {
    		return  new JsonResult(row);
    	}else {
    		return  new JsonResult();
    		
    	}
	}
	
	//获取所有著作信息
	@RequestMapping(value="getAllWorkMsg.do",method=RequestMethod.POST)
	@ResponseBody
	public Layui getAllWorkMsg() {
		List<Work> result=work.getAllWorkMsg();
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
	//删除著作信息
	@RequestMapping("dellWorkMsg.do")
	@ResponseBody
	public JsonResult dellWorkMsg(@RequestParam("requestDate[]") Integer[] eid){
		int row=work.deleteMsg(eid);
    	if(row!=0) {
    		return  new JsonResult(row);
    	}else {
    		return  new JsonResult();
    		
    	}
	}
	
	//获取所有基金信息
	@RequestMapping(value="getAllFundMsg.do",method=RequestMethod.POST)
	@ResponseBody
	public Layui getAllFundMsg() {
		List<Govfund> result=govfund.getAllFundMsg();
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
	//删除基金信息
	@RequestMapping("dellFundMsg.do")
	@ResponseBody
	public JsonResult dellFundMsg(@RequestParam("requestDate[]") Integer[] eid){
		int row=govfund.deleteMsg(eid);
    	if(row!=0) {
    		return  new JsonResult(row);
    	}else {
    		return  new JsonResult();
    		
    	}
	}
	
	//获取所有资助平台信息
	@RequestMapping(value="getAllPlatformMsg.do",method=RequestMethod.POST)
	@ResponseBody
	public Layui getAllPlatformMsg() {
		List<Govplatform> result=govplatform.getAllPlatformMsg();
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
	//删除资助平台信息
	@RequestMapping("dellPlatformMsg.do")
	@ResponseBody
	public JsonResult dellPlatformMsg(@RequestParam("requestDate[]") Integer[] eid){
		int row=govplatform.deleteMsg(eid);
    	if(row!=0) {
    		return  new JsonResult(row);
    	}else {
    		return  new JsonResult();
    		
    	}
	}
	
	//获取所有政府项目信息
	@RequestMapping(value="getAllSubjectMsg.do",method=RequestMethod.POST)
	@ResponseBody
	public Layui getAllSubjectMsg() {
		List<Govsubject> result=govsubject.getAllSubjectMsg();
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
	//删除政府项目信息
	@RequestMapping("dellSubjectMsg.do")
	@ResponseBody
	public JsonResult dellSubjectMsg(@RequestParam("requestDate[]") Integer[] eid){
		int row=govsubject.deleteMsg(eid);
    	if(row!=0) {
    		return  new JsonResult(row);
    	}else {
    		return  new JsonResult();
    		
    	}
	}
	
	//获取所有政府奖励信息
	@RequestMapping(value="getAllRewardMsg.do",method=RequestMethod.POST)
	@ResponseBody
	public Layui getAllRewardMsg() {
		List<Govreward> result=govreward.getAllRewardMsg();
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
	//删除政府奖励信息
	@RequestMapping("dellRewardMsg.do")
	@ResponseBody
	public JsonResult dellRewardMsg(@RequestParam("requestDate[]") Integer[] eid){
		int row=govreward.deleteMsg(eid);
    	if(row!=0) {
    		return  new JsonResult(row);
    	}else {
    		return  new JsonResult();
    		
    	}
	}
}
