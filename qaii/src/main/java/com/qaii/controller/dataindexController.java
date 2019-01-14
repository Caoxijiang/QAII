package com.qaii.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class dataindexController {
	@RequestMapping("dataindexNav.do")
	public String dataindexNav(){
		return "page/demonstration/dataindexNav";
	}

	@RequestMapping("dataindexIndustry.do")
	public String dataindexIndustry(){
		return "page/demonstration/dataindexIndustry";
	}

	@RequestMapping("dataindexPersonnel.do")
	public String dataindexPersonnel(){
		return "page/demonstration/dataindexPersonnel";
	}

	@RequestMapping("dataindexScience.do")
	public String dataindexScience(){
		return "page/demonstration/dataindexScience";
	}
}

