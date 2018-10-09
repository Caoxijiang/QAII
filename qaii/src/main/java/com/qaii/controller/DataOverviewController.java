package com.qaii.controller;

import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qaii.service.GovFundService;
import com.qaii.service.GovPlatformService;
import com.qaii.service.GovRewardService;
import com.qaii.service.GovSubjectService;
import com.qaii.service.PatentService;
import com.qaii.service.SoftwarecopyrightService;
import com.qaii.service.ThesisService;
import com.qaii.service.TradeMarkService;
import com.qaii.service.WorkService;
import com.qaii.util.CountDatetoNowDays;

//数据可视化界面的接口
@Controller
public class DataOverviewController {
	@Resource
	private GovFundService govfundservice;
	@Resource
	private GovPlatformService govplatformservice;
	@Resource
	private GovSubjectService govsubjectservice;
	@Resource
	private GovRewardService govrewardservice;
	@Resource
	private PatentService patentService;
	@Resource
	private SoftwarecopyrightService softService;
	@Resource
	private TradeMarkService trademarkService;
	@Resource
	private ThesisService thesisService;
	@Resource
	private WorkService workService;
	
	/**
	 * @author wangxin 
	 * @description 科技处数据可视化接口
	 * @time 2018/09/21
	 */
	// 政府资助数据接口
	public Map<String, List> GovernmentFunding(){
		Map<String, List> result =new HashMap<>();
		result.put("fund", govfundservice.getAllFundMsg());
		result.put("platform", govplatformservice.getAllPlatformMsg());
		result.put("subject", govsubjectservice.getAllSubjectMsg());
		result.put("reward", govrewardservice.getAllRewardMsg());
		return result;
	}
	
	// 科研成果信息
	@RequestMapping("TestPrint.do")
	Map<String, List> scientific() throws ParseException{
		Map<String, List> result=new HashMap<>();
		result.put("Agency", listAgencyPatent());
		result.put("Authorization", listAuthorizationPatent());
		result.put("Applycopyright", listApplycopyright());
		result.put("Authorizationcopyright", listAuthorizationcopyright());
		result.put("AgencyTradeMark", listAgencyTradeMark());
		result.put("AuthorizationTradeMark", listAuthorizationTradeMark());
		result.put("EachMonththesis", listEachMonththesis());
		result.put("EachMonthwork", listEachMonthwork());
		return result;		
	}
	
	// 十二个月的受理专利信息
	List<Integer> listAgencyPatent() throws ParseException{
		//获取当前时间
		Date date =new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		List<String> list=new ArrayList<>();
		Map<String, String> map=new HashMap<>();
		List<Integer> result =new ArrayList<>();
		list=CountDatetoNowDays.getpremonth(sdf.format(date), 12);
		for (String str:list) {
			map=CountDatetoNowDays.getBothEnds(str);
			result.add(patentService.countAgencyPatent(map.get("first"), map.get("end")));
		}
		return result;
	} 
	
	// 十二个月的授权专利信息
//	@RequestMapping("TestPrint.do")
	List<Integer> listAuthorizationPatent() throws ParseException{
		//获取当前时间
		Date date =new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		List<String> list=new ArrayList<>();
		Map<String, String> map=new HashMap<>();
		List<Integer> result =new ArrayList<>();
		list=CountDatetoNowDays.getpremonth(sdf.format(date), 12);
		for (String str:list) {
			map=CountDatetoNowDays.getBothEnds(str);
			result.add(patentService.countAuthorizationPatent(map.get("first"), map.get("end")));
		}
		return result;
	} 
	
	// 十二个月的申请软著信息
//	@RequestMapping("TestPrint.do")
	List<Integer> listApplycopyright() throws ParseException{
		//获取当前时间
		Date date =new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		List<String> list=new ArrayList<>();
		Map<String, String> map=new HashMap<>();
		List<Integer> result =new ArrayList<>();
		list=CountDatetoNowDays.getpremonth(sdf.format(date), 12);
		for (String str:list) {
			map=CountDatetoNowDays.getBothEnds(str);
			result.add(softService.countApplycopyright(map.get("first"), map.get("end")));
		}
		return result;
	}
	
	// 十二个月的授权软著信息
//	@RequestMapping("TestPrint.do")
	List<Integer> listAuthorizationcopyright() throws ParseException{
		//获取当前时间
		Date date =new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		List<String> list=new ArrayList<>();
		Map<String, String> map=new HashMap<>();
		List<Integer> result =new ArrayList<>();
		list=CountDatetoNowDays.getpremonth(sdf.format(date), 12);
		for (String str:list) {
			map=CountDatetoNowDays.getBothEnds(str);
			result.add(softService.countAuthorizationcopyright(map.get("first"), map.get("end")));
		}
		return result;
	}
	
	// 十二个月的受理商标信息
//	@RequestMapping("TestPrint.do")
	List<Integer> listAgencyTradeMark() throws ParseException{
		//获取当前时间
		Date date =new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		List<String> list=new ArrayList<>();
		Map<String, String> map=new HashMap<>();
		List<Integer> result =new ArrayList<>();
		list=CountDatetoNowDays.getpremonth(sdf.format(date), 12);
		for (String str:list) {
			map=CountDatetoNowDays.getBothEnds(str);
			result.add(trademarkService.countAgencyTradeMark(map.get("first"), map.get("end")));
		}
		return result;
	} 
	
	// 十二个月的授权商标信息
//	@RequestMapping("TestPrint.do")
	List<Integer> listAuthorizationTradeMark() throws ParseException{
		//获取当前时间
		Date date =new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		List<String> list=new ArrayList<>();
		Map<String, String> map=new HashMap<>();
		List<Integer> result =new ArrayList<>();
		list=CountDatetoNowDays.getpremonth(sdf.format(date), 12);
		for (String str:list) {
			map=CountDatetoNowDays.getBothEnds(str);
			result.add(trademarkService.countAuthorizationTradeMark(map.get("first"), map.get("end")));
		}
		return result;
	}
	
	// 十二个月的论文总数信息
//	@RequestMapping("TestPrint.do")
	List<Integer> listEachMonththesis() throws ParseException{
		//获取当前时间
		Date date =new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		List<String> list=new ArrayList<>();
		Map<String, String> map=new HashMap<>();
		List<Integer> result =new ArrayList<>();
		list=CountDatetoNowDays.getpremonth(sdf.format(date), 12);
		for (String str:list) {
			map=CountDatetoNowDays.getBothEnds(str);
			result.add(thesisService.countEachMonththesis(map.get("first"), map.get("end")));
		}
		return result;
	}
	
	// 十二个月的著作总数信息
//	@RequestMapping("TestPrint.do")
	List<Integer> listEachMonthwork() throws ParseException{
		//获取当前时间
		Date date =new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		List<String> list=new ArrayList<>();
		Map<String, String> map=new HashMap<>();
		List<Integer> result =new ArrayList<>();
		list=CountDatetoNowDays.getpremonth(sdf.format(date), 12);
		for (String str:list) {
			map=CountDatetoNowDays.getBothEnds(str);
			result.add(workService.countEachMonthwork(map.get("first"), map.get("end")));
		}
		return result;
	}
	
}
