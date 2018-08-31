package com.qaii.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qaii.domain.EmpInfo;
import com.qaii.service.EmpInfoService;
import com.qaii.util.CountDatetoNowDays;

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
	
	
	@RequestMapping("adddetail.do")
	public String adddetail() {
		return "page/personnel/adddetail";
	}
	
}
