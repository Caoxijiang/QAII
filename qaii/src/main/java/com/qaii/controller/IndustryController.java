package com.qaii.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class IndustryController {
	@RequestMapping("industry.do")
	public String science(){
		return "page/industry/industry";
	}
}
