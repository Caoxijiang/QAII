package com.qaii.controller;

import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qaii.domain.Govfund;
import com.qaii.domain.Govplatform;
import com.qaii.domain.Govreward;
import com.qaii.domain.Govsubject;
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
	 * 
	 * @description 科技处数据可视化接口
	 * @time 2018/09/21
	 */

	
	// 政府资助数据接口
	@RequestMapping("GovernmentFunding.do")
	@ResponseBody
	public Map<String, List> GovernmentFunding(){
		int num = 6;
		Map<String, List> result =new HashMap<>();
		List<Govfund> fundList=govfundservice.listByNum(num);
		List<Govplatform> platList=govplatformservice.listByNum(num);
		List<Govsubject> subList=govsubjectservice.listByNum(num);
		List<Govreward> rewardList=govrewardservice.listByNum(num);
		Collections.reverse(fundList);			//反向排序数组 
		Collections.reverse(platList);
		Collections.reverse(subList);
		Collections.reverse(rewardList);
		result.put("fund",  fundList);
		result.put("platform", platList);
		result.put("subject", subList);
		result.put("reward", rewardList);
		return result;
	}
	
	// 科研成果信息区域
	@RequestMapping("scientific.do")
	@ResponseBody
	Map<String, List> scientific() throws ParseException{
		//获取当前时间
		Date date =new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		List<String> list=new ArrayList<>();
		list=CountDatetoNowDays.getpremonth(sdf.format(date), 12);
		Map<String, List> result=new HashMap<>();
		result.put("AgencyPatent", listAgencyPatent(list));
		result.put("AuthorizationPatent", listAuthorizationPatent(list));
		result.put("Applycopyright", listApplycopyright(list));
		result.put("Authorizationcopyright", listAuthorizationcopyright(list));
		result.put("AgencyTradeMark", listAgencyTradeMark(list));
		result.put("AuthorizationTradeMark", listAuthorizationTradeMark(list));
		result.put("EachMonththesis", listEachMonththesis(list));
		result.put("EachMonthwork", listEachMonthwork(list));
		result.put("EachMonth", list);
		return result;		
	}
	
	// 十二个月的受理专利信息
	List<Integer> listAgencyPatent(List<String> list) throws ParseException{
		//获取当前时间
		Map<String, String> map=new HashMap<>();
		List<Integer> result =new ArrayList<>();
		for (String str:list) {
			map=CountDatetoNowDays.getBothEnds(str);
			result.add(patentService.countAgencyPatent(map.get("first"), map.get("end")));
		}
		return result;
	} 
	
	// 十二个月的授权专利信息
//	@RequestMapping("TestPrint.do")
	List<Integer> listAuthorizationPatent(List<String> list) throws ParseException{
		Map<String, String> map=new HashMap<>();
		List<Integer> result =new ArrayList<>();
		for (String str:list) {
			map=CountDatetoNowDays.getBothEnds(str);
			result.add(patentService.countAuthorizationPatent(map.get("first"), map.get("end")));
		}
		return result;
	} 
	
	// 十二个月的申请软著信息
//	@RequestMapping("TestPrint.do")
	List<Integer> listApplycopyright(List<String> list) throws ParseException{
		Map<String, String> map=new HashMap<>();
		List<Integer> result =new ArrayList<>();
		for (String str:list) {
			map=CountDatetoNowDays.getBothEnds(str);
			result.add(softService.countApplycopyright(map.get("first"), map.get("end")));
		}
		return result;
	}
	
	// 十二个月的授权软著信息
//	@RequestMapping("TestPrint.do")
	List<Integer> listAuthorizationcopyright(List<String> list) throws ParseException{
		Map<String, String> map=new HashMap<>();
		List<Integer> result =new ArrayList<>();
		for (String str:list) {
			map=CountDatetoNowDays.getBothEnds(str);
			result.add(softService.countAuthorizationcopyright(map.get("first"), map.get("end")));
		}
		return result;
	}
	
	// 十二个月的受理商标信息
//	@RequestMapping("TestPrint.do")
	List<Integer> listAgencyTradeMark(List<String> list) throws ParseException{
		Map<String, String> map=new HashMap<>();
		List<Integer> result =new ArrayList<>();
		for (String str:list) {
			map=CountDatetoNowDays.getBothEnds(str);
			result.add(trademarkService.countAgencyTradeMark(map.get("first"), map.get("end")));
		}
		return result;
	} 
	
	// 十二个月的授权商标信息
//	@RequestMapping("TestPrint.do")
	List<Integer> listAuthorizationTradeMark(List<String> list) throws ParseException{
		Map<String, String> map=new HashMap<>();
		List<Integer> result =new ArrayList<>();
		for (String str:list) {
			map=CountDatetoNowDays.getBothEnds(str);
			result.add(trademarkService.countAuthorizationTradeMark(map.get("first"), map.get("end")));
		}
		return result;
	}
	
	// 十二个月的论文总数信息
//	@RequestMapping("TestPrint.do")
	List<Integer> listEachMonththesis(List<String> list) throws ParseException{
		Map<String, String> map=new HashMap<>();
		List<Integer> result =new ArrayList<>();
		for (String str:list) {
			map=CountDatetoNowDays.getBothEnds(str);
			result.add(thesisService.countEachMonththesis(map.get("first"), map.get("end")));
		}
		return result;
	}
	
	// 十二个月的著作总数信息
//	@RequestMapping("TestPrint.do")
	List<Integer> listEachMonthwork(List<String> list) throws ParseException{
		Map<String, String> map=new HashMap<>();
		List<Integer> result =new ArrayList<>();
		for (String str:list) {
			map=CountDatetoNowDays.getBothEnds(str);
			result.add(workService.countEachMonthwork(map.get("first"), map.get("end")));
		}
		return result;
	}
	
	
	/**
	 *  @author wangxin
	 *  @description 数据可视化科研成果总览区域数据接口
	 *  @date 2018/10/11
	 * */
	
	
	@RequestMapping("scientificPreview.do")
	@ResponseBody
	Map<String, Integer> scientificPreview() throws ParseException{
		//获取当前时间
		Date date =new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		List<String> list=new ArrayList<>();
		list=CountDatetoNowDays.getpremonth(sdf.format(date), 12);
		Map<String, Integer> result=new HashMap<>();
		result.put("AgencyPatent", patentService.getPatentCount());
		result.put("AuthorizationPatent", patentService.countAuthorizationPatentNum());
		result.put("Applycopyright", softService.getCountNum());
		result.put("Authorizationcopyright", softService.countAuthorizationcopyrightNum());
		result.put("AgencyTradeMark", trademarkService.getCountNum());
		result.put("AuthorizationTradeMark", trademarkService.countAuthorizationTradeMarkNum());
		result.put("CountThesis", thesisService.getCountNum());
		result.put("Countwork", workService.getCountNum());
		return result;		
	}
	
	/**
	 *  @author wangxin
	 *  @description 数据可视化数据总量部分
	 *  @date 2018/10/11
	 * */
	
	@RequestMapping("DataTotal.do")
	@ResponseBody
	Map<String, List<Integer>> DataTotal(){
		Map<String, List<Integer>> result = new HashMap<>();
		List<Integer> applyList=new ArrayList<>();
		List<Integer> rejectList=new ArrayList<>();
		List<Integer> agencyList=new ArrayList<>();
		List<Integer> authorizationList=new ArrayList<>();
		applyList.add(patentService.countApplyNumber("外观设计专利"));
		applyList.add(patentService.countApplyNumber("实用新型专利"));
		applyList.add(patentService.countApplyNumber("发明专利"));
		rejectList.add(patentService.countRejectNumber("外观设计专利"));
		rejectList.add(patentService.countRejectNumber("实用新型专利"));
		rejectList.add(patentService.countRejectNumber("发明专利"));
		agencyList.add(patentService.countAgencyPatentByKey("外观设计专利"));
		agencyList.add(patentService.countAgencyPatentByKey("实用新型专利"));
		agencyList.add(patentService.countAgencyPatentByKey("发明专利"));
		authorizationList.add(patentService.countAuthorizationPatentByKey("外观设计专利"));
		authorizationList.add(patentService.countAuthorizationPatentByKey("实用新型专利"));
		authorizationList.add(patentService.countAuthorizationPatentByKey("发明专利"));
		result.put("apply", applyList);
		result.put("reject", rejectList);
		result.put("agency", agencyList);
		result.put("authorization", authorizationList);
		return result;
		
	}
	
}
