package com.qaii.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Null;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.apache.poi.ss.formula.functions.T;
import org.aspectj.apache.bcel.generic.ReturnaddressType;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.fabric.xmlrpc.base.Data;
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
	
	Incubator incubator2=new Incubator();
	
	
	@RequestMapping("industry.do")
	public String science(){
		return "page/industry/industry";
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
	@RequestMapping("hatchchangetime.do")
	public String hatchchangetime(){
		return "page/industry/hatch/hatchchangetime";
	}
	//孵化企业变更修改界面
	@RequestMapping("hatchshare.do")
	public String hatchshare(){
		return "page/industry/hatch/hatchshare";
	}
	//孵化企业添加界面
	@RequestMapping("hatchAdd.do")
	public String hatchAdd(){
		return "page/industry/hatch/hatchAdd";
	}
	//孵化企业成员添加界面
	@RequestMapping("hatch.do")
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
	@RequestMapping("innovate.do")
	public String innovate(){
		return "page/industry/innovate/innovate";
	}
	//院获奖情况界面
	@RequestMapping("institute.do")
	public String institute(){
		return "page/industry/honor/institute/institute";
	}
	//孵化企业获奖情况界面
	@RequestMapping("incubate.do")
	public String incubate(){
		return "page/industry/honor/incubate/incubate";
	}
	//个人获奖界面
	@RequestMapping("person.do")
	public String person(){
		return "page/industry/honor/person/person";
	}
	//服务企业管理界面
	@RequestMapping("serviceFirm.do")
	public String serviceFirm(){
		return "page/industry/serviceFirm/serviceFirm";
	}
	//服务企业管理添加界面
	@RequestMapping("serviceFirmAdd.do")
	public String serviceFirmAdd(){
		return "page/industry/serviceFirm/serviceFirmAdd";
	}
	//服务企业管理查看详情界面
	@RequestMapping("serviceFirmCheck.do")
	public String serviceFirmCheck(){
		return "page/industry/serviceFirm/serviceFirmCheck";
	}
	//服务企业管理修改界面
	@RequestMapping("serviceFirmEdit.do")
	public String serviceFirmEdit(){
		return "page/industry/serviceFirm/serviceFirmEdit";
	}
	
	
	
	// 孵化企业管理添加接口
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping("/insertIndustryInfo.do")
	public JsonResult insertIndustryInfo(@RequestParam("file") MultipartFile[] files, HttpServletRequest req)
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
			System.out.println(list);
			System.out.println(list2);
		} catch (IOException e1) {
			return new JsonResult("图片上传失败" + e1);
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
			return new JsonResult("传入数据有误" + e);

		}
		int row = incubatorService.insert(incubator);
		if (row > 0) {
			System.out.println(incubator.getId());
			iFile.setIncubatorId(incubator.getId());
			iFile1.setIncubatorId(incubator.getId());
			int args = incubatorFileService.insert(iFlists);
			if (args > 0) {
				return new JsonResult("添加成功");
			} else {
				return new JsonResult("添加失败");
			}
		} else {
			return new JsonResult("信息输入有误");
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
		for(Incubator in : incubator) {
			in.getCertificateTime();
			DateUtils.dateToOriStr(in.getCertificateTime());
			System.out.println(DateUtils.dateToOriStr(in.getCertificateTime()));
		}
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
			Integer id=Integer.parseInt(req.getParameter("id"));
			incubator= incubatorService.selectByPrimaryKey(id);
			incubator2=incubator;
			if(incubator!=null) {
				return new JsonResult(incubator);
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
		Incubator newIncubator=new Incubator();
		try {
			IncubatorInfo(req, newIncubator);
			String isThousandSailEnterprise = req.getParameter("isThousandSailEnterprise");
			newIncubator.setIsThousandSailEnterprise(new Byte(isThousandSailEnterprise));
			newIncubator.setIsBillionEnterprise(new Byte(req.getParameter("isBillionEnterprise")));
			byte isHighTechnologyEnterprise = new Byte(req.getParameter("isHighTechnologyEnterprise"));
			newIncubator.setIsHighTechnologyEnterprise(isHighTechnologyEnterprise);
			newIncubator.setCertificateTime(CountDatetoNowDays.StrconversionData(req.getParameter("certificateTime")));
			newIncubator.setCertificateCode(req.getParameter("certificateCode"));
			byte isTechnologyEnterprise = new Byte(req.getParameter("isTechnologyEnterprise"));
			newIncubator.setIsTechnologyEnterprise(isTechnologyEnterprise);
			newIncubator.setIncomingRegistrationCode(req.getParameter("incomingRegistrationCode"));
		} catch (ParseException e) {
			e.printStackTrace();
			return new JsonResult("传入数据有误" + e);
		}
		BeanChangeUtil<T> tBeanChangeUtil=new BeanChangeUtil<>();
		String str=tBeanChangeUtil.contrastObj(oldImcubator,newIncubator);
        if (str.equals("")) {
            System.out.println("未有改变");
        } else {
            System.out.println(str);
        }
    
		return new JsonResult(str);
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
