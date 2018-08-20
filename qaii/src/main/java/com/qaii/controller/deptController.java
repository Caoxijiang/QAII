package com.qaii.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class deptController {
	@RequestMapping("dept.do")
	public String dept(){
		return "page/indexNav";
	}
}
