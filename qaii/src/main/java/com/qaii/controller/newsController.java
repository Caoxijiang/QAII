package com.qaii.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class newsController {
	/**消息管理页面*/
	@RequestMapping("newsUI.do")
	public String indexUI(){
		return "page/personnel/newsPersonnel";
	}
}

