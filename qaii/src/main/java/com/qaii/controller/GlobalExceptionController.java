package com.qaii.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qaii.util.CustomException;

@ControllerAdvice
public class GlobalExceptionController {
	@ExceptionHandler(value=CustomException.class)
	@ResponseBody
	public String CusExceptionhanlder(CustomException e) {
		e.printStackTrace();
		System.out.println(e.getMsg());
		return e.getMsg();
	}

}
