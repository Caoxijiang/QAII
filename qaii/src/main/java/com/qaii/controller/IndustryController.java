package com.qaii.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Null;

import com.qaii.domain.IncubatorRecord;
import com.qaii.service.IncubatorRecordService;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.qaii.domain.Incubator;
import com.qaii.domain.IncubatorFile;
import com.qaii.domain.StockEquity;
import com.qaii.service.IncubatorFileService;
import com.qaii.service.IncubatorService;
import com.qaii.service.StockEquityService;
import com.qaii.util.BeanChangeUtil;
import com.qaii.util.CountDatetoNowDays;
import com.qaii.util.DateUtils;
import com.qaii.util.FileLoadUtils;
import com.qaii.util.JsonResult;
import com.qaii.util.Layui;
@Controller
public class IndustryController {
	private static String PATH="C:/File/img/industry/";
	@Resource
	private IncubatorService incubatorService;
	@Resource
	private IncubatorFileService incubatorFileService;
	@Resource
	private StockEquityService stockEquityService;
	@Resource
	private IncubatorRecordService incubatorRecordService;


	Incubator incubator2=new Incubator();
	
	
	@RequestMapping("industry.do")
	public String science(){
		return "page/industry/industry";
	}
	//产业化处数据可视化界面
	@RequestMapping("/indexIndustry.do")
	public String indexIndustry(){
		return "page/industry/indexIndustry";
	}
	//孵化企业界面
	@RequestMapping("hatchmumber.do")
	public ModelAndView hatchmumber(HttpServletRequest req) throws UnsupportedEncodingException{
		req.setCharacterEncoding("UTF-8");
		List<String> result=new ArrayList<String>();
		String args=req.getParameter("id");
		result.add(args);
		return new ModelAndView ("page/industry/hatch/hatchmumber","Info",result);
	}
	//孵化企业变更时间修改界面（修改界面之内）
	@RequestMapping("/hatchchangetime.do")
	public ModelAndView hatchchangetime(HttpServletRequest req) throws UnsupportedEncodingException {
		req.setCharacterEncoding("UTF-8");
		List<String> result=new ArrayList<String>();
		String args=req.getParameter("id");
		result.add(args);
		return new ModelAndView( "page/industry/hatch/hatchchangetime","Info",result);
	}
	//孵化企业变更修改界面
	@RequestMapping("/hatchshare.do")
	public ModelAndView hatchshare(HttpServletRequest req) throws UnsupportedEncodingException {
		req.setCharacterEncoding("UTF-8");
		List<String> result=new ArrayList<String>();
		String args=req.getParameter("id");
		result.add(args);
		return new ModelAndView ("page/industry/hatch/hatchshare","Info",result);
	}
	//孵化企业添加界面
	@RequestMapping("/hatchAdd.do")
	public String hatchAdd(){
		return "page/industry/hatch/hatchAdd";
	}
	//孵化企业成员添加界面
	@RequestMapping("/hatch.do")
	public String hatch(){
		return "page/industry/hatch/hatch";	
	}
	//孵化企业查看详情界面
	//@ResponseBody
	@RequestMapping(value="hatchCheck.do")
	public ModelAndView hatchCheck(HttpServletRequest req) throws UnsupportedEncodingException{
		req.setCharacterEncoding("UTF-8");
		List<String> result=new ArrayList<String>();
		String args=req.getParameter("id");
		result.add(args);
		return new ModelAndView("page/industry/hatch/hatchCheck","Info",result);
	}
	//孵化企业修改界面
	@RequestMapping("hatchEdit.do")
	public ModelAndView hatchEdit(HttpServletRequest req) throws UnsupportedEncodingException{
		req.setCharacterEncoding("UTF-8");
		List<String> result=new ArrayList<String>();
		String args=req.getParameter("id");
		result.add(args);
		return new ModelAndView("page/industry/hatch/hatchEdit","Info",result);
	}
	//创新能力界面
	@RequestMapping("/innovate.do")
	public String innovate(){
		return "page/industry/innovate/innovate";
	}
	//院获奖情况界面
	@RequestMapping("/institute.do")
	public String institute(){
		return "page/industry/honor/institute/institute";
	}
	//院获奖情况界面 添加
	@RequestMapping("/instituteAdd.do")
	public String instituteAdd(){
		return "page/industry/honor/institute/instituteAdd";
	}
	//院获奖情况界面 查看详情
	@RequestMapping("/instituteCheck.do")
	public String instituteCheck(){
		return "page/industry/honor/institute/instituteCheck";
	}
	//院获奖情况界面  修改
	@RequestMapping("/instituteEdit.do")
	public String instituteEdit(){
		return "page/industry/honor/institute/instituteEdit";
	}
	//孵化企业获奖情况界面
	@RequestMapping("/incubate.do")
	public String incubate(){
		return "page/industry/honor/incubate/incubate";
	}
	//孵化企业获奖情况界面 添加
	@RequestMapping("/incubateAdd.do")
	public String incubateAdd(){
		return "page/industry/honor/incubate/incubateAdd";
	}
	//孵化企业获奖情况界面查看详情
	@RequestMapping("/incubateCheck.do")
	public String incubateCheck(){
		return "page/industry/honor/incubate/incubateCheck";
	}
	//孵化企业获奖情况界面修改
	@RequestMapping("/incubateEdit.do")
	public String incubateEdit(){
		return "page/industry/honor/incubate/incubateEdit";
	}
	//个人获奖界面
	@RequestMapping("/person.do")
	public String person(){
		return "page/industry/honor/person/person";
	}
	//个人获奖界面 修改
	@RequestMapping("/personEdit.do")
	public String personEdit(){
		return "page/industry/honor/person/personEdit";
	}
	//个人获奖界面 查看详情
	@RequestMapping("/personCheck.do")
	public String personCheck(){
		return "page/industry/honor/person/personCheck";
	}
	//个人获奖界面 添加
	@RequestMapping("/personAdd.do")
	public String personAdd(){
		return "page/industry/honor/person/personAdd";
	}
	//服务企业管理界面
	@RequestMapping("/serviceFirm.do")
	public String serviceFirm(){
		return "page/industry/serviceFirm/serviceFirm";
	}
	//服务企业管理添加界面
	@RequestMapping("/serviceFirmAdd.do")
	public String serviceFirmAdd(){
		return "page/industry/serviceFirm/serviceFirmAdd";
	}
	//服务企业管理查看详情界面
	@RequestMapping("/serviceFirmCheck.do")
	public String serviceFirmCheck(){
		return "page/industry/serviceFirm/serviceFirmCheck";
	}
	//服务企业管理修改界面
	@RequestMapping("/serviceFirmEdit.do")
	public String serviceFirmEdit(){
		return "page/industry/serviceFirm/serviceFirmEdit";
	}

	// 孵化企业管理添加接口
	@SuppressWarnings("unchecked")
	@RequestMapping("/insertIndustryInfo.do")
	public String insertIndustryInfo(@RequestParam("file") MultipartFile[] files, HttpServletRequest req)
			throws UnsupportedEncodingException, ParseException {
		req.setCharacterEncoding("utf-8");
		Incubator incubator = new Incubator();
		IncubatorFile iFile = new IncubatorFile();
		IncubatorFile iFile1 = new IncubatorFile();
		List<IncubatorFile> iFlists = new ArrayList<>();
		Map<String, Object> result = new HashMap<>();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();
		try {
			// 文件上传结果
			result = FileLoadUtils.fileload(files, PATH);
			list = (List<Map<String, Object>>) result.get("0");
			list2 = (List<Map<String, Object>>) result.get("1");
			System.out.println("__________："+list+">>>>>>>>>>>："+list2);
		} catch (IOException e1) {
			return "page/industry/inform/addFaildind";
		}
		try {
			IncubatorInfo(req, incubator);
			list = (List<Map<String, Object>>) result.get("0");
			if (list != null) {
				// String file1=list.get(0).get("oleName").toString();
				iFile.setFileName(list.get(0).get("oldName").toString());
				iFile.setFilePath(list.get(0).get("URL").toString());
				iFile.setFileStyle("License");
				iFlists.add(iFile);
			}else {
				iFlists.add(iFile);
			}

			if (list2 != null) {
				iFile1.setFileName(list2.get(0).get("oldName").toString());
				iFile1.setFilePath(list2.get(0).get("URL").toString());
				iFile1.setFileStyle("Electronic");
			}
			String isThousandSailEnterprise = req.getParameter("isThousandSailEnterprise");
			incubator.setIsThousandSailEnterprise(new Byte(isThousandSailEnterprise));
			incubator.setIsBillionEnterprise(new Byte(req.getParameter("isBillionEnterprise")));

			byte isHighTechnologyEnterprise = new Byte(req.getParameter("isHighTechnologyEnterprise"));

			if (isHighTechnologyEnterprise == 0) {
				incubator.setIsHighTechnologyEnterprise(isHighTechnologyEnterprise);
				if (list2 != null) {
					String path = list2.get(0).get("URL").toString();
					String filename = list2.get(0).get("newName").toString();
					FileLoadUtils.delFile(path, filename);
				}
			} else {
				incubator.setIsHighTechnologyEnterprise(isHighTechnologyEnterprise);
				incubator.setCertificateTime(CountDatetoNowDays.StrconversionData(req.getParameter("certificateTime")));
				incubator.setCertificateCode(req.getParameter("certificateCode"));
				iFlists.add(iFile1);
			}
			byte isTechnologyEnterprise = new Byte(req.getParameter("isTechnologyEnterprise"));
			if (isTechnologyEnterprise == 0) {
				incubator.setIsTechnologyEnterprise(isTechnologyEnterprise);
			} else {
				incubator.setIsTechnologyEnterprise(isTechnologyEnterprise);
				incubator.setIncomingRegistrationCode(req.getParameter("incomingRegistrationCode"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "page/industry/inform/addFaildind";

		}

		if((iFlists.get(0).getFileName())!=null){
			System.out.println("--------------"+iFlists);
			int row = incubatorService.insert(incubator);
			if (row > 0 ) {
				System.out.println(incubator.getId());
				iFile.setIncubatorId(incubator.getId());
				iFile1.setIncubatorId(incubator.getId());
				int args = incubatorFileService.insert(iFlists);
				if (args > 0) {
					return "page/industry/inform/addSuccesdind";
				} else {
					return "page/industry/inform/addFaildind";
				}
			} else {
				return "page/industry/inform/addFaildind";
			}
		}else{
			return "page/industry/inform/addFaildind";
		}



	}

	//添加股东信息
	@ResponseBody
	@RequestMapping(value="addShareholderInfo.do",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public JsonResult addShareholderInfo(HttpServletRequest req) throws UnsupportedEncodingException, ParseException {
		req.setCharacterEncoding("UTF-8");
		StockEquity stockEquity=new StockEquity();
		try {	
			stockEquity.setShareholderName(req.getParameter("shareholderName"));
			stockEquity.setContributionProportion(req.getParameter("contributionProportion"));
			stockEquity.setContributionTime(CountDatetoNowDays.StrconversionData(req.getParameter("contributionTime")));
			stockEquity.setShareholderPosition(req.getParameter("shareholderPosition"));
			stockEquity.setIncubatorId(Integer.parseInt(req.getParameter("id")));
		} catch (Exception e) {
			return new JsonResult("数据传入有误"+e);
		}
		int row=stockEquityService.insert(stockEquity);
		if(row>0) {
			return new JsonResult("添加成功");
		}else {
			return new JsonResult();
		}
	}
	
			
	
	//孵化企业管理页面
	@ResponseBody
	@RequestMapping(value="selectIndusInfo.do",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public Layui selectIndusInfo(HttpServletRequest request ) {
		List<Incubator> incubator=incubatorService.selectAlllist();
			int count =incubator.size();
			if(incubator!=null) {
				return Layui.data(count, incubator);
			}else {
				return Layui.data(count, incubator);
			}
		
		}
	
	
	
	//孵化企业详情页面
	@ResponseBody
	@RequestMapping(value="selectIndusCheckInfo.do",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public JsonResult selectIndusCheckInfo(HttpServletRequest req) throws UnsupportedEncodingException {
			req.setCharacterEncoding("UTF-8");
			Incubator incubator=new Incubator();
			List<IncubatorFile> iFile=new ArrayList<>();
			List<Object>list=new ArrayList<>();
			Integer id=Integer.parseInt(req.getParameter("id"));
			incubator= incubatorService.selectByPrimaryKey(id);
			iFile=incubatorFileService.selectByPrimaryKey(id);
			System.out.println(iFile.get(0).getFileName());
			incubator2=incubator;
			list.add(incubator);
			list.add(iFile);
			if(incubator!=null) {
				return new JsonResult(list);
			}else {
				return new JsonResult();
			}
					
		}
	
	//孵化企业股东详情页面
	@ResponseBody
	@RequestMapping(value="selectIndusStackInfo.do",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public Layui selectIndusStackInfo(HttpServletRequest req) throws UnsupportedEncodingException {
			req.setCharacterEncoding("UTF-8");
			List<StockEquity> stockEquity=new ArrayList<>();
			Integer id=Integer.parseInt(req.getParameter("id"));
			stockEquity=stockEquityService.selectByPrimaryKey(id);
			System.out.println(stockEquity);
			int count =stockEquity.size();
			if(stockEquity!=null) {
				return Layui.data(count, stockEquity);
			}else {
				return Layui.data(count, stockEquity);
			}
		
		}
	
	
	//更新孵化企业信息
	
	@ResponseBody
	@RequestMapping(value="updateIndusInfo.do",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public JsonResult updateIndusInfo(HttpServletRequest req) throws UnsupportedEncodingException {
		req.setCharacterEncoding("UTF-8");
		Incubator oldImcubator=incubator2;
		Integer idString=oldImcubator.getId();
		Incubator newIncubator=new Incubator();
		newIncubator.setId(idString);
		Map<String,String>result=new HashMap<>();
		try {
			IncubatorInfo(req, newIncubator);
			byte isTechnologyEnterprise = new Byte(req.getParameter("isTechnologyEnterprise"));
			if (isTechnologyEnterprise == 0) {
				newIncubator.setIsTechnologyEnterprise(isTechnologyEnterprise);
			} else {
				newIncubator.setIsTechnologyEnterprise(isTechnologyEnterprise);
				newIncubator.setIncomingRegistrationCode(req.getParameter("incomingRegistrationCode"));
			}
			byte isHighTechnologyEnterprise = new Byte(req.getParameter("isHighTechnologyEnterprise"));
			if (isHighTechnologyEnterprise == 0) {
				newIncubator.setIsHighTechnologyEnterprise(isHighTechnologyEnterprise);
			}else {
				newIncubator.setIsHighTechnologyEnterprise(isHighTechnologyEnterprise);
				newIncubator.setCertificateTime(CountDatetoNowDays.StrconversionData(req.getParameter("certificateTime")));
				newIncubator.setCertificateCode(req.getParameter("certificateCode"));
			}
			
			String isThousandSailEnterprise = req.getParameter("isThousandSailEnterprise");
			newIncubator.setIsThousandSailEnterprise(new Byte(isThousandSailEnterprise));
			newIncubator.setIsBillionEnterprise(new Byte(req.getParameter("isBillionEnterprise")));
		} catch (ParseException e) {
			e.printStackTrace();
			return new JsonResult("传入数据有误" + e);
		}

		int row= incubatorService.updateByPrimaryKeySelective(newIncubator);
		if(row>0) {
			BeanChangeUtil<T> tBeanChangeUtil=new BeanChangeUtil<>();
			List<Map<String, Object>> strlist=tBeanChangeUtil.contrastObj(oldImcubator,newIncubator,idString.toString());
	        if (strlist==null) {
	        	String recordmsg="";
	        	result.put("recordmsg",recordmsg);
	        	return new JsonResult(recordmsg);
	        } else {
	        	List<IncubatorRecord> list=new ArrayList<>();
				String time=DateUtils.getFullDate();
				Date times=DateUtils.parseStringToDate(time);
	        	for (Map map :strlist){
					Object list_name=map.get("list_name");
					Object old_name=map.get("old_name");
					Object new_name=map.get("new_name");
					Object pid=map.get("id");
					IncubatorRecord incubatorRecord=new IncubatorRecord();
					incubatorRecord.setListName(list_name.toString());
					incubatorRecord.setChangedTime(times);
					incubatorRecord.setOldName(old_name.toString());
					incubatorRecord.setNewName(new_name.toString());
					incubatorRecord.setPid(Integer.parseInt(pid.toString()));
					list.add(incubatorRecord);
				}
	        	int rows=incubatorRecordService.insert(list);
	        	if(rows!=0){
					String recordmsg="SSUCCESS";
					String recordres=strlist.toString();
					result.put("recordmsg",recordmsg);
					result.put("recordres",recordmsg);
					return new JsonResult(result);
				}else{
					String recordmsg="DBERROR";
					result.put("recordmsg",recordmsg);
					return new JsonResult(result);
				}

	        }
		}else {
			return new JsonResult();
		}




	}

	//删除孵化企业管理
	@ResponseBody
	@RequestMapping(value="dellIndusStackInfo.do",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public JsonResult dellIndusStackInfo(@RequestParam(value = "requestDate[]") Integer[] id) throws UnsupportedEncodingException {

		int row=incubatorService.deleteByPrimaryKey(id);
		if(row!=0) {
			return  new JsonResult(row);
		}else {
			return  new JsonResult();

		}
	}







	private void IncubatorInfo(HttpServletRequest req, Incubator incubator) throws ParseException {
		incubator.setCompanyName(req.getParameter("companyName"));
		incubator.setCreditCode(req.getParameter("creditCode"));
		String establishTime = req.getParameter("establishTime");
		incubator.setEstablishTime(CountDatetoNowDays.StrconversionData(establishTime));
		incubator.setCompanyType(req.getParameter("companyType"));
		incubator.setCompanyLocation(req.getParameter("companyLocation"));
		incubator.setLegalRepresentative(req.getParameter("legalRepresentative"));
		incubator.setRegisteredCapital(req.getParameter("registeredCapital"));
		incubator.setBusinessScope(req.getParameter("businessScope"));
		incubator.setIncubatorName(req.getParameter("incubatorName"));
		incubator.setHatchingTime(CountDatetoNowDays.StrconversionData(req.getParameter("hatchingTime")));
		incubator.setLimitedPeriod(req.getParameter("limitedPeriod"));
	}
}
