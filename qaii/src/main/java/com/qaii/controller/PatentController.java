package com.qaii.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qaii.domain.DeptInfo;
import com.qaii.domain.Patent;
import com.qaii.service.PatentService;
import com.qaii.util.JsonResult;
import com.qaii.util.Layui;

@Controller
public class PatentController {
	@Resource
	private PatentService patentService;
	//增加专利信息
	@ResponseBody
	@RequestMapping(value="addPatentInfo.do",produces="application/json;charset=UTF-8")
	public JsonResult addPatentInfo(HttpServletRequest req ,Patent patent) {
		PatentInfo(req, patent);
		int row = patentService.insert(patent);
    	if(row!=0) {
    		return  new JsonResult(row);
    	}else {
    		return  new JsonResult();
    		
    	}
	}
	
	//专利列表
	@ResponseBody
	@RequestMapping(value="findPatentInfo.do",produces="application/json;charset=UTF-8")
	public Layui findPatentInfo() {
		List<Patent> deptInfo=patentService.findAllPatentInfo();
		int count =deptInfo.size();
			if(deptInfo!=null) {
				return Layui.data(count, deptInfo);
			}else {
				return Layui.data(count, deptInfo);
			}
	}
	
	
	
	
	//专利详情
	@ResponseBody
	@RequestMapping(value="findPatentInfoById.do",produces="application/json;charset=UTF-8")
	public JsonResult findPatentInfoById(HttpServletRequest req,Patent patent) {
		patent.setId(Integer.valueOf(req.getParameter("id"))); 
		Patent row=patentService.selectByPrimaryKey(patent.getId());
		
			if(row!=null) {
				return new JsonResult(row);
			}else {
				return new JsonResult();
			}
	}
	
	
	//删除专利信息
    @ResponseBody
    @RequestMapping(value="dellPatentInfo.do", method=RequestMethod.POST,produces="application/json;charset=UTF-8")
    public JsonResult dellPatentInfo(@RequestParam(value = "requestDate[]") Integer[] id ){
     	int row=patentService.deleteByPrimaryKey(id);
     
    	if(row!=0) {
    		return  new JsonResult(row);
    	}else {
    		return  new JsonResult();
    		
    	}
        
    }
    
    
    
	//修改部门信息
    @ResponseBody
    @RequestMapping(value="uptatePatentInfo.do", method=RequestMethod.POST,produces="application/json;charset=UTF-8")
    public JsonResult uptatePatentInfo(HttpServletRequest req,Patent patent){
    	PatentInfo(req, patent);
    	patent.setId(Integer.parseInt(req.getParameter("param")));
     	int row=patentService.updateByPrimaryKey(patent);
    	if(row!=0) {
    		return  new JsonResult(row);
    	}else {
    		return  new JsonResult();
    		
    	}
        
    }
    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	private void PatentInfo(HttpServletRequest req, Patent patent) {
		patent.setPatDept(req.getParameter("pat_Dept"));
		patent.setPatType(req.getParameter("pat_Type"));
		patent.setPatName(req.getParameter("pat_Name"));
		patent.setPatAuthor(req.getParameter("pat_Author"));
		patent.setPatApplyper(req.getParameter("pat_ApplyPer"));
		patent.setPatTelltime(req.getParameter("pat_TellTime"));
		patent.setPatAgency(req.getParameter("pat_Agency"));
		patent.setPatPrepublishaudit(req.getParameter("pat_PrePublishAudit"));
		patent.setPatApplynum(req.getParameter("pat_ApplyNum"));
		patent.setPatApplytime(req.getParameter("pat_ApplyTime"));
		patent.setPatPublishnum(req.getParameter("pat_PublishNum"));
		patent.setPatAuthorzationtime(req.getParameter("pat_AuthorzationTime"));
		patent.setPatRemission(req.getParameter("pat_Remission"));
		patent.setPatCost(req.getParameter("pat_Cost"));
		patent.setPatInvoiceper(req.getParameter("pat_InvoicePer"));
		patent.setPatDigest(req.getParameter("pat_Digest"));
		patent.setPatRemark(req.getParameter("pat_Remark"));
	}
	
}
