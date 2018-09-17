package com.qaii.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
		return "page/science/patent";
	}
	//专利添加界面
		@RequestMapping("patentAdd.do")
		public String patentAdd(){
			return "page/science/patentAdd";
		}
	//软著
	@RequestMapping("soft.do")
	public String soft(){
		return "page/science/soft";
	}
	//商标
	@RequestMapping("brand")
	public String brand(){
		return "page/science/brand";
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
	//科研项目
	@RequestMapping("research.do")
	public String research(){
		return "page/science/research";
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
