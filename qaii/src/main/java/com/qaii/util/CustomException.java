package com.qaii.util;

public class CustomException extends Exception {
	private String msg;
	public CustomException(){
		super();
	}
	public CustomException(String msg){
		super(msg);
		this.msg=msg;
		this.printStackTrace();
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public void printStackTrace(String msg) {
		this.msg=msg;
		System.out.println(msg);
	}
}
