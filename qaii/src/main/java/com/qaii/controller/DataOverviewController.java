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
	Map<String, List> scientific(){
		Map<String, List> result=new HashMap<>();
		
		return result;		
	}
	
	// 十二个月的受理专利信息
	@RequestMapping("TestPrint.do")
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
		System.out.println(result);
		return result;
	} 
	
	// 十二个月的授权专利信息
}
