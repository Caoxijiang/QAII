package com.qaii.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class IndexController {
	/**首页控制器*/
	@RequestMapping("indexUI.do")
	public String indexUI(){
		return "page/login";
	}
}
