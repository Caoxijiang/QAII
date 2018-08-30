package com.qaii.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.qaii.domain.EmpAvatarinfo;
import com.qaii.domain.EmpInfo;
import com.qaii.domain.User;
import com.qaii.service.EmpAvatarService;
import com.qaii.service.EmpInfoService;
import com.qaii.util.CountDatetoNowDays;
import com.qaii.util.JsonResult;
import com.qaii.util.Layui;

@Controller
public class EmpController {
	@Resource
	private EmpInfoService empInfoService;
	@Resource
	private EmpAvatarService empAvatarService; 
	
	//修改员工信息页面
	@RequestMapping(value="updateEmpInfo.do",produces="application/json;charset=UTF-8")
	public String updateEmpInfo() {
		return "page/personnel/editdetail";
	}
	


	@RequestMapping(value="delldellEmpInfo.do",produces="application/json;charset=UTF-8")
	public String dellEmpInfo() {
		return "page/personnel/delPersonnel";
	}
	
	
	

	@RequestMapping(value="seeEmpInfo.do",produces="application/json;charset=UTF-8")
	public String seeEmpInfo() {
		
		return "page/personnel/checkdetail";
		
	}
	
	
	//添加员工信息接口
	@ResponseBody
    @RequestMapping(value="addEmpInfo.do", method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public JsonResult addEmpInfo(HttpServletRequest req, EmpInfo empInfo) throws ParseException {
		 HttpSession session = req.getSession();  
	     User user = (User)session.getAttribute("user");  
	     if(user!=null) {
	    	 empInfo.setEmpReviewstatus("通过");
	     }else {
	    	 empInfo.setEmpReviewstatus("待审核");
	     }		

		empInfo.setEid(req.getParameter("imageVal"));
		empInfo.setEmpName(req.getParameter("empName"));
		empInfo.setEmpGender(req.getParameter("empGender"));
		empInfo.setEmpDept(req.getParameter("empDept"));
		empInfo.setEmpPosition(req.getParameter("empPosition"));
		empInfo.setEmpHireStarttime(req.getParameter("empHireStarttime"));
		empInfo.setEmpIdcard(req.getParameter("empIdcard"));
		empInfo.setEmpIdcardEndtime(CountDatetoNowDays.SDatetoStamp(req.getParameter("empIdcardEndtime")));
		empInfo.setEmpEthnic(req.getParameter("empEthnic"));
		empInfo.setEmpPoliticallandscape(req.getParameter("empPoliticallandscape"));
		empInfo.setEmpMaritalstatus(req.getParameter("empMaritalstatus"));
		empInfo.setEmpFirsteducation(req.getParameter("empFirsteducation"));
		empInfo.setEmpSecondeducation(req.getParameter("empSecondeducation"));
		empInfo.setEmpSecondeducation(req.getParameter("empThirdeducation"));
		empInfo.setEmpFirsteducationschool(req.getParameter("empFirsteducationschool"));
		empInfo.setEmpSecondeducationschool(req.getParameter("empSecondeducationschool"));
		empInfo.setEmpThirdeducationschool(req.getParameter("empThirdeducationschool"));
		empInfo.setEmpFirsteducationpro(req.getParameter("empFirsteducationpro"));
		empInfo.setEmpSecondeducationpro(req.getParameter("empSecondeducationpro"));
		empInfo.setEmpSecondeducationpro(req.getParameter("empThirdeducationpro"));
		empInfo.setEmpFirstgraduationtime(CountDatetoNowDays.SDatetoStamp(req.getParameter("empFirstgraduationtime")));
		empInfo.setEmpSecondgraduationtime(CountDatetoNowDays.SDatetoStamp(req.getParameter("empSecondgraduationtime")));
		empInfo.setEmpThirdgraduationtime(CountDatetoNowDays.SDatetoStamp(req.getParameter("empThirdgraduationtime")));
		empInfo.setEmpJobtitle(req.getParameter("empJobtitle"));
		empInfo.setEmpJobtitlelevel(req.getParameter("empJobtitlelevel"));
		empInfo.setEmpJobtitleobtaintime(CountDatetoNowDays.SDatetoStamp(req.getParameter("empJobtitleobtaintime")));
		empInfo.setEmpPhone(req.getParameter("empPhone"));
		empInfo.setEmpEmergencycontactandphone(req.getParameter("empEmergencycontactandphone"));
		empInfo.setEmpFileaddress(req.getParameter("empFileaddress"));
		empInfo.setEmpAccountaddress(req.getParameter("empAccountaddress"));
		empInfo.setEmpHomeaddress(req.getParameter("empHomeaddress"));
		empInfo.setEmpWorktype(req.getParameter("empWorktype"));
		empInfo.setEmpCompile(req.getParameter("empCompile"));
		empInfo.setEmpInductiontime(CountDatetoNowDays.SDatetoStamp(req.getParameter("empInductiontime")));
		empInfo.setEmpTryoutendtime(CountDatetoNowDays.SDatetoStamp(req.getParameter("empTryoutendtime")));
		empInfo.setEmpContractendtime(CountDatetoNowDays.SDatetoStamp(req.getParameter("empContractendtime")));
		empInfo.setEmpContractsignednum(Integer.parseInt(req.getParameter("empContractsignednum")));
		empInfo.setEmpReturnee(req.getParameter("empReturnee"));
		empInfo.setEmpForeign(req.getParameter("empForeign"));
		empInfo.setEmpRemarks(req.getParameter("empRemarks"));	
		empInfo.setEmpTitle(req.getParameter("empTitle"));
		EmpInfo(req, empInfo);
		empInfo.setEmpStat("1");
		empInfo.setEmpDepartureTime("");
		empInfo.setEmpTryStatus("1");
		empInfo.setEmpContractStatus("1");
		empInfo.setEmpRemarks("1");
		
		
		
		System.out.println(empInfo.toString());
		int row = empInfoService.insert(empInfo);
		if(row>0) {
			Map<String,String> map=new HashMap<>();
			 map.put("url","intoPerSys.do");
			 map.put("data", "提交成功");
			return new JsonResult();
		}else {
			return new JsonResult();
		}
		
	}







		//员工图片上传
		@ResponseBody
	 	@RequestMapping("/EmpAupload.do")  
	    public Map<String,String> upload(@RequestParam("file") MultipartFile file , EmpAvatarinfo EMpA,HttpServletRequest request) throws Exception{  
	  //  System.out.println(request.getParameter("name"));  
	    Map<String,String> result=new HashMap<>();
	    if(file.isEmpty()) {
	    	result.put("code", "1");
	    	result.put("msg", "文件为空");
	    }
        String uuid = UUID.randomUUID().toString().replaceAll("-","");    
        //获得文件类型（可以判断如果不是图片，禁止上传）    
        String contentType=EMpA.getFile().getContentType();    
        //获得文件后缀名   
        String suffixName=contentType.substring(contentType.indexOf("/")+1);  
        //得到 文件名  
        String fileName=uuid+"."+suffixName; 
	    
	  //  String fileName=file.getOriginalFilename();
	    int size=(int)file.getSize();
	    System.out.println(fileName+":---"+size);
	    String path="E:/File";
	    File dest =new File(path+"/"+fileName);
	    if(!dest.getParentFile().exists()) {
	    	dest.getParentFile().mkdirs();
	    }
	    try {
			file.transferTo(dest);//保存文件
			EMpA.setUrl(dest.getPath());
			InsertEmpAvator(EMpA, result, dest);
			result.put("code", "0");
			result.put("msg", "上传成功");
			result.put("url", dest.getPath());
		} catch (IllegalStateException e) {
			// TODO: handle exception
			e.printStackTrace();
			result.put("code", "1");
	    	result.put("msg", "上传失败");
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
			result.put("code", "1");
	    	result.put("msg", "上传失败");
		}
	    
	    return result;  
    
	    }







	
	
	//获取员工信息接口
	@ResponseBody
	@RequestMapping(value="findAllEmpInfo.do", method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public Layui findAllEmpInfo(HttpServletRequest req) {
		List<EmpInfo> empInfo=empInfoService.findAllEmpInfo();
		int count =empInfo.size();
		System.out.println(count);
			if(empInfo!=null) {
				return Layui.data(count, empInfo);
			}else {
				return Layui.data(count, empInfo);
			}
	}
	
	@ResponseBody
	@RequestMapping(value="seeEmpInfos.do", method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public JsonResult seeEmpInfos(EmpInfo emp,HttpServletRequest req) {	
		
		int userid=Integer.parseInt(req.getParameter("userId"));
		System.out.println("user:"+userid);
		//emp.setId();
		emp = empInfoService.findEmpinfoAndAvatarByid(userid);
		if(emp!=null) {
			emp.setEmpTryoutendtime(CountDatetoNowDays.StamptoDate(emp.getEmpTryoutendtime()));
			emp.setEmpIdcardEndtime(CountDatetoNowDays.StamptoDate(emp.getEmpIdcardEndtime()));
			emp.setEmpContractendtime(CountDatetoNowDays.StamptoDate(emp.getEmpContractendtime()));
			emp.setEmpFirstgraduationtime(CountDatetoNowDays.StamptoDate(emp.getEmpFirstgraduationtime()));
			emp.setEmpSecondgraduationtime(CountDatetoNowDays.StamptoDate(emp.getEmpSecondgraduationtime()));
			emp.setEmpThirdgraduationtime(CountDatetoNowDays.StamptoDate(emp.getEmpThirdgraduationtime()));
			emp.setEmpInductiontime(CountDatetoNowDays.StamptoDate(emp.getEmpInductiontime()));
			emp.setEmpJobtitleobtaintime(CountDatetoNowDays.StamptoDate(emp.getEmpJobtitleobtaintime()));
			return new JsonResult(emp);
		}else {
			return new JsonResult();
		}
		
	}
	
	
	
	@ResponseBody
	@RequestMapping(value="updateEmpInfos.do", method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public JsonResult updateEmpInfos(EmpInfo empInfo,HttpServletRequest req) {	
		EmpInfo(req, empInfo);
		

		int row =empInfoService.updateByPrimaryKey(empInfo);
		if(row>=1) {
			String data="更新成功";
			return new JsonResult(data);
		}else {
			return new JsonResult();
		}
		
		
	}
	
	//删除员工信息
    @ResponseBody
    @RequestMapping(value="DellempInfo.do", method=RequestMethod.POST,produces="application/json;charset=UTF-8")
    public JsonResult DellempInfo(@RequestParam(value = "requestDate[]") Integer[] eid ){
    	System.out.println(eid);
    	
     	int row=empInfoService.delete(eid);
    	if(row!=0) {
    		return  new JsonResult(row);
    	}else {
    		return  new JsonResult();
    		
    	}
        
    }
	
	
	
	
	
	
	
	
	
	
	
	private void InsertEmpAvator(EmpAvatarinfo EMpA, Map<String, String> result, File dest) {
		int row=empAvatarService.insert(EMpA);
		if(row > 0) {
			int eid=EMpA.getId();
			System.out.println(eid);
			if(eid>=1) {
				result.put("code", "0");
				result.put("msg", "上传成功");
				result.put("eid",EMpA.getId().toString() );
				result.put("url", dest.getPath());
				
			}else {
				result.put("code", "1");
		    	result.put("msg", "上传失败");
			}
		}else {
			result.put("code", "1");
	    	result.put("msg", "上传失败");
		}
	}  
	
	
	

	private void EmpInfo(HttpServletRequest req, EmpInfo empInfo) {
		//System.out.println("---------------:"+);
		empInfo.setId(Integer.parseInt(req.getParameter("userId")));
		empInfo.setEid(req.getParameter("imageVal"));
		empInfo.setEmpName(req.getParameter("empName"));
		empInfo.setEmpGender(req.getParameter("empGender"));
		empInfo.setEmpDept(req.getParameter("empDept"));
		empInfo.setEmpPosition(req.getParameter("empPosition"));
		empInfo.setEmpHireStarttime(req.getParameter("empHireStarttime"));
		empInfo.setEmpIdcard(req.getParameter("empIdcard"));
		empInfo.setEmpIdcardEndtime(req.getParameter("empIdcardEndtime"));
		empInfo.setEmpEthnic(req.getParameter("empEthnic"));
		empInfo.setEmpPoliticallandscape(req.getParameter("empPoliticallandscape"));
		empInfo.setEmpMaritalstatus(req.getParameter("empMaritalstatus"));
		empInfo.setEmpFirsteducation(req.getParameter("empFirsteducation"));
		empInfo.setEmpSecondeducation(req.getParameter("empSecondeducation"));
		empInfo.setEmpSecondeducation(req.getParameter("empThirdeducation"));
		empInfo.setEmpFirsteducationschool(req.getParameter("empFirsteducationschool"));
		empInfo.setEmpSecondeducationschool(req.getParameter("empSecondeducationschool"));
		empInfo.setEmpThirdeducationschool(req.getParameter("empThirdeducationschool"));
		empInfo.setEmpFirsteducationpro(req.getParameter("empFirsteducationpro"));
		empInfo.setEmpSecondeducationpro(req.getParameter("empSecondeducationpro"));
		empInfo.setEmpSecondeducationpro(req.getParameter("empThirdeducationpro"));
		empInfo.setEmpFirstgraduationtime(req.getParameter("empFirstgraduationtime"));
		empInfo.setEmpSecondgraduationtime(req.getParameter("empSecondgraduationtime"));
		empInfo.setEmpThirdgraduationtime(req.getParameter("empThirdgraduationtime"));
		empInfo.setEmpJobtitle(req.getParameter("empJobtitle"));
		empInfo.setEmpJobtitlelevel(req.getParameter("empJobtitlelevel"));
		empInfo.setEmpJobtitleobtaintime(req.getParameter("empJobtitleobtaintime"));
		empInfo.setEmpPhone(req.getParameter("empPhone"));
		empInfo.setEmpEmergencycontactandphone(req.getParameter("empEmergencycontactandphone"));
		empInfo.setEmpFileaddress(req.getParameter("empFileaddress"));
		empInfo.setEmpAccountaddress(req.getParameter("empAccountaddress"));
		empInfo.setEmpHomeaddress(req.getParameter("empHomeaddress"));
		empInfo.setEmpWorktype(req.getParameter("empWorktype"));
		empInfo.setEmpCompile(req.getParameter("empCompile"));
		empInfo.setEmpInductiontime(req.getParameter("empInductiontime"));
		empInfo.setEmpTryoutendtime(req.getParameter("empTryoutendtime"));
		empInfo.setEmpContractendtime(req.getParameter("empContractendtime"));
		empInfo.setEmpContractsignednum(Integer.parseInt(req.getParameter("empContractsignednum")));
		empInfo.setEmpReturnee(req.getParameter("empReturnee"));
		empInfo.setEmpForeign(req.getParameter("empForeign"));
		empInfo.setEmpTitle(req.getParameter("empTitle"));
		empInfo.setEmpRemarks(req.getParameter("empRemarks"));
	}
	

	
	
	
	
	
	
}
