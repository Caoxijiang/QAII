package com.qaii.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.qaii.domain.DeptInfo;
import com.qaii.domain.EmpInfo;
import com.qaii.service.DeptInfoService;
import com.qaii.util.JsonResult;
import com.qaii.util.Layui;

@Controller
public class techController {
	//主框架
	@RequestMapping("science.do")
	public String science(){
		return "page/science/science";
	}
	//科技处数据可视化
	@RequestMapping("indexScience.do")
	public String indexScience(){
		return "page/science/indexScience";
	}
	//专利
	@RequestMapping("patent.do")
	public String patent(){
		return "page/science/patent/patent";
	}
	//专利添加界面
		@RequestMapping("patentAdd.do")
		public String patentAdd(){
			return "page/science/patent/patentAdd";
		}
	//专利查看详情界面
		@RequestMapping("patentCheck.do")
		public String patentCheck(){
			return "page/science/patent/patentCheck";
	}
	//专利修改界面
	@RequestMapping("patentEdit.do")
	public String patentEdit(){
		return "page/science/patent/patentEdit";
	}
	//专利资料审查界面
	@RequestMapping("patentProcess.do")
	public String patentProcess(){
		return "page/science/patent/patentProcess";
	}
	//专利资料审查文件预览界面
	@RequestMapping("patentData.do")
	public ModelAndView patentData(HttpServletRequest request) throws UnsupportedEncodingException{
		List<String> result=new ArrayList<String>();
		result.add(new String(request.getParameter("patName").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("patAuthor").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("patPublishtime").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("userId").getBytes("ISO-8859-1"),"utf-8"));
		return new ModelAndView("page/science/patent/patentData", "utflist", result);
	}
	//专利资料审查文件流程添加界面
		@RequestMapping("patentDataAdd.do")
		public String patentDataAdd(){
			return "page/science/patent/patentDataAdd";
		}
	//专利资料审查文件添加界面
			@RequestMapping("patentDataAddFile.do")
			public String patentDataAddFile(){
				return "page/science/patent/patentDataAddFile";
			}
	//软著
	@RequestMapping("soft.do")
	public String soft(){
		return "page/science/soft";
	}
	//商标
	@RequestMapping("brand.do")
	public String brand() {
		return "page/science/brand/brand";
	}
	//商标添加界面
	@RequestMapping("brandAdd.do")
	public String brandAdd(){
		return "page/science/brand/brandAdd";
	}
	//商标查看详情界面
	@RequestMapping("brandCheck.do")
	public String brandCheck(){
		return "page/science/brand/brandCheck";
	}
	//商标修改界面
	@RequestMapping("brandEdit.do")
	public String brandEdit(){
		return "page/science/brand/brandEdit";
	}
	//商标资料审查界面
	@RequestMapping("brandProcess.do")
	public ModelAndView brandProcess(HttpServletRequest request) throws UnsupportedEncodingException{
		List<String> result=new ArrayList<String>();
		result.add(new String(request.getParameter("tradmDept").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("tradmApplyper").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("tradmRegistertime").getBytes("ISO-8859-1"),"utf-8"));
		return new ModelAndView("page/science/brand/brandProcess", "utflist", result);
	}
	//商标资料审查文件预览界面
	@RequestMapping("brandData.do")
	public ModelAndView brandData(HttpServletRequest request) throws UnsupportedEncodingException{
		List<String> result=new ArrayList<String>();
		result.add(new String(request.getParameter("tradmDept").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("tradmApplyper").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("tradmRegistertime").getBytes("ISO-8859-1"),"utf-8"));
		return new ModelAndView("page/science/brand/brandData", "utflist", result);
	}
	//商标资料审查文件流程添加界面
	@RequestMapping("brandDataAdd.do")
	public String brandDataAdd(){
		return "page/science/brand/brandDataAdd";
	}
	//商标资料审查文件添加界面
	@RequestMapping("brandDataAddFile.do")
	public String brandDataAddFile(){
		return "page/science/brand/brandDataAddFile";
	}
	//基金
	@RequestMapping("fund.do")
	public String fund(){
		return "page/science/fund";
	}
	//创新平台
	@RequestMapping("create.do")
	public String create(){
		return "page/science/create";
	}
	//纵向课题
	@RequestMapping("research.do")
	public String research(){
		return "page/science/research/research";
	}
	//纵向课题添加界面
	@RequestMapping("researchAdd.do")
	public String researchAdd(){
		return "page/science/research/researchAdd";
	}
	//纵向课题查看详情界面
	@RequestMapping("researchCheck.do")
	public String researchCheck(){
		return "page/science/research/researchCheck";
	}
	//纵向课题修改界面
	@RequestMapping("researchEdit.do")
	public String researchEdit(){
		return "page/science/research/researchEdit";
	}
	//纵向课题资料审查界面
	@RequestMapping("researchProcess.do")
	public String researchProcess(){
		return "page/science/research/researchProcess";
	}
	//纵向课题资料审查文件预览界面
	@RequestMapping("researchData.do")
	public ModelAndView researchData(HttpServletRequest request) throws UnsupportedEncodingException{
		List<String> result=new ArrayList<String>();
		result.add(new String(request.getParameter("govsubName").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("govsubSource").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("govsubApprovalnum").getBytes("ISO-8859-1"),"utf-8"));
		return new ModelAndView("page/science/research/researchData", "utflist", result);
	}
	//纵向课题资料审查文件流程添加界面
	@RequestMapping("researchDataAdd.do")
	public String researchDataAdd(){
		return "page/science/research/researchDataAdd";
	}
	//纵向课题资料审查文件添加界面
	@RequestMapping("researchDataAddFile.do")
	public String researchDataAddFile(){
		return "page/science/research/researchDataAddFile";
	}
	//科技奖励
	@RequestMapping("award.do")
	public String award(){
		return "page/science/award";
	}
	//论文
	@RequestMapping("paper.do")
	public String paper(){
		return "page/science/paper";
	}
	//著作
	@RequestMapping("work.do")
	public String work(){
		return "page/science/work";
	}
}
