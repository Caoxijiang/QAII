package com.qaii.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonController {
	@RequestMapping("personal.do")
	public String personal() {
		return "page/personnel/indexPersonnel";
	}
	
	@RequestMapping("intoPerSys.do")
	public String intoPerSys() {
		return "page/personnel/personnel";
	}
	
	@RequestMapping("intoPerSysadd.do")
	public String intoPerSysadd() {
		return "page/personnel/addPersonnel";
	}
	
}
