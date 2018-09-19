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
    	patent.setId(Integer.parseInt(req.getParameter("id")));
     	int row=patentService.updateByPrimaryKey(patent);
    	if(row!=0) {
    		return  new JsonResult(row);
    	}else {
    		return  new JsonResult();
    		
    	}
        
    }
    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	private void PatentInfo(HttpServletRequest req, Patent patent) {
		patent.setPatDept(req.getParameter("patDept"));
		patent.setPatType(req.getParameter("patType"));
		patent.setPatName(req.getParameter("patName"));
		patent.setPatAuthor(req.getParameter("patAuthor"));
		patent.setPatApplyper(req.getParameter("patApplyper"));
		patent.setPatTelltime(req.getParameter("patTelltime"));
		patent.setPatAgency(req.getParameter("patAgency"));
		patent.setPatPrepublishaudit(req.getParameter("patPrepublishaudit"));
		patent.setPatApplynum(req.getParameter("patApplynum"));
		patent.setPatApplytime(req.getParameter("patApplytime"));
		patent.setPatPublishnum(req.getParameter("patPublishtime"));
		patent.setPatAuthorzationtime(req.getParameter("patAuthorzationtime"));
		patent.setPatRemission(req.getParameter("patRemission"));
		patent.setPatCost(req.getParameter("patCost"));
		patent.setPatInvoiceper(req.getParameter("patInvoiceper"));
		patent.setPatDigest(req.getParameter("patDigest"));
		patent.setPatRemark(req.getParameter("patRemark"));
	}
	
}
