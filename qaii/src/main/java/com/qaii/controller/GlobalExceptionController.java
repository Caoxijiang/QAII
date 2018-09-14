package com.qaii.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.qaii.util.AlertException;
import com.qaii.util.CustomException;

@ControllerAdvice
public class GlobalExceptionController {
	@ExceptionHandler(value=CustomException.class)
	@ResponseBody
	public ModelAndView CusExceptionhandler(CustomException e) {
		e.printStackTrace();
		String errmsg=e.getMsg();
		return new ModelAndView("errorpage/Customerror","errmsg",errmsg);
	}
	
	@ExceptionHandler(value=AlertException.class)
	@ResponseBody
	public String AlertExceptionhandler(AlertException e) {
		e.printStackTrace();
		return e.getMessage();
	}

}
