package com.qaii.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.qaii.service.GovFundService;
import com.qaii.service.GovPlatformService;
import com.qaii.service.GovRewardService;
import com.qaii.service.GovSubjectService;

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
	
	/**
	 * @author wangxin 
	 * @category 科技处数据可视化接口
	 * @time 2018/09/21
	 */
	//政府资助数据接口
	public Map<String, List> GovernmentFunding(){
		Map<String, List> result =new HashMap<>();
		result.put("fund", govfundservice.getAllFundMsg());
		result.put("platform", govplatformservice.getAllPlatformMsg());
		result.put("subject", govsubjectservice.getAllSubjectMsg());
		result.put("reward", govrewardservice.getAllRewardMsg());
		return result;
	}
}
