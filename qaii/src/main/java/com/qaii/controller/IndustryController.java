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

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mysql.fabric.xmlrpc.base.Data;
import com.qaii.domain.Incubator;
import com.qaii.domain.IncubatorFile;
import com.qaii.service.IncubatorFileService;
import com.qaii.service.IncubatorService;
import com.qaii.util.CountDatetoNowDays;
import com.qaii.util.FileLoadUtils;
import com.qaii.util.JsonResult;
@Controller
public class IndustryController {
	private static String PATH="C:/File/img/industry/";
	@Resource
	private IncubatorService incubatorService;
	@Resource
	private IncubatorFileService incubatorFileService;
	
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
	@RequestMapping("/hatchmumber.do")
	public String hatchmumber(){
		return "page/industry/hatch/hatchmumber";
	}
	//孵化企业变更时间修改界面（修改界面之内）
	@RequestMapping("/hatchchangetime.do")
	public String hatchchangetime(){
		return "page/industry/hatch/hatchchangetime";
	}
	//孵化企业变更修改界面
	@RequestMapping("/hatchshare.do")
	public String hatchshare(){
		return "page/industry/hatch/hatchshare";
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
	@RequestMapping("/hatchCheck.do")
	public String hatchCheck(){
		return "page/industry/hatch/hatchCheck";
	}
	//孵化企业修改界面
	@RequestMapping("/hatchEdit.do")
	public String hatchEdit(){
		return "page/industry/hatch/hatchEdit";
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
	//孵化企业获奖情况界面
	@RequestMapping("/incubate.do")
	public String incubate(){
		return "page/industry/honor/incubate/incubate";
	}
	//个人获奖界面
	@RequestMapping("/person.do")
	public String person(){
		return "page/industry/honor/person/person";
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
	
	
	
	// 政府资助数据接口
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping("/insertIndustryInfo.do")
	public JsonResult insertIndustryInfo(@RequestParam("file") MultipartFile[] files,HttpServletRequest req) throws UnsupportedEncodingException, ParseException {
		req.setCharacterEncoding("utf-8");
		Incubator incubator =new Incubator();
		IncubatorFile iFile=new IncubatorFile();
		IncubatorFile iFile1=new IncubatorFile();
		List<IncubatorFile> iFlists=new ArrayList<>();
		Map<String,Object> result = new HashMap<>();
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		try {
			//文件上传结果
			result=FileLoadUtils.fileload(files,PATH);	
			list = (List<Map<String, Object>>) result.get("0");		
			list2=(List<Map<String, Object>>) result.get("1");
			System.out.println(list);
			System.out.println(list2);
		} catch (IOException e1) {
			return new JsonResult("图片上传失败"+e1);
		}
		try {
			incubator.setCompanyName(req.getParameter("companyName"));
			incubator.setCreditCode(req.getParameter("creditCode"));
			String establishTime= req.getParameter("establishTime");
			incubator.setEstablishTime(CountDatetoNowDays.StrconversionData(establishTime));
			incubator.setCompanyType(req.getParameter("companyType"));
			incubator.setCompanyLocation(req.getParameter("companyLocation"));
			incubator.setLegalRepresentative(req.getParameter("legalRepresentative"));
			incubator.setRegisteredCapital(req.getParameter("registeredCapital"));
			incubator.setBusinessScope(req.getParameter("businessScope"));
			incubator.setIncubatorName(req.getParameter("incubatorName"));
			incubator.setHatchingTime(CountDatetoNowDays.StrconversionData(req.getParameter("hatchingTime")));
			incubator.setLimitedPeriod(req.getParameter("limitedPeriod"));
			list = (List<Map<String, Object>>) result.get("0");		
			if(list!=null) {
				//String file1=list.get(0).get("oleName").toString();
				iFile.setFileName(list.get(0).get("oldName").toString());
				iFile.setFilePath(list.get(0).get("URL").toString());
				iFile.setFileStyle("License");
				iFlists.add(iFile);
			}
			if(list2!=null) {
				iFile1.setFileName(list2.get(0).get("oldName").toString());
				iFile1.setFilePath(list2.get(0).get("URL").toString());
				iFile1.setFileStyle("Electronic");
				
			}
			String isThousandSailEnterprise=req.getParameter("isThousandSailEnterprise");
			incubator.setIsThousandSailEnterprise(new Byte(isThousandSailEnterprise));	
			incubator.setIsBillionEnterprise(new Byte(req.getParameter("isBillionEnterprise")));
			
			byte isHighTechnologyEnterprise=new Byte(req.getParameter("isHighTechnologyEnterprise"));
			
			if(isHighTechnologyEnterprise==0) {
				incubator.setIsHighTechnologyEnterprise(isHighTechnologyEnterprise);
				if(list2!=null) {
					String path=list2.get(0).get("URL").toString();
					String filename=list2.get(0).get("newName").toString();
					FileLoadUtils.delFile(path, filename);
				}
			}else {
				incubator.setIsHighTechnologyEnterprise(isHighTechnologyEnterprise);
				incubator.setCertificateTime(CountDatetoNowDays.StrconversionData(req.getParameter("certificateTime")));
				incubator.setCertificateCode(req.getParameter("certificateCode"));
				iFlists.add(iFile1);
			}
			byte isTechnologyEnterprise= new Byte(req.getParameter("isTechnologyEnterprise"));
			if(isTechnologyEnterprise==0) {
				incubator.setIsTechnologyEnterprise(isTechnologyEnterprise);
			}else {
				incubator.setIsTechnologyEnterprise(isTechnologyEnterprise);
				incubator.setIncomingRegistrationCode(req.getParameter("incomingRegistrationCode"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult("传入数据有误"+e);
			
		}
		int row =incubatorService.insert(incubator);
		if(row>0) {
			System.out.println(incubator.getId());
			iFile.setIncubatorId(incubator.getId());
			iFile1.setIncubatorId(incubator.getId());
			int args= incubatorFileService.insert(iFlists);
			if(args>0) {
				return new JsonResult("添加成功");
			}else {
				return new JsonResult("添加失败");
			}
		}else {
			return new JsonResult("信息输入有误");
		}				
		
	}
	
}
