package com.qaii.controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qaii.domain.EmpAvatarinfo;
import com.qaii.util.JsonResult;

@Controller
public class EmpController {
	//添加员工信息接口
	@ResponseBody
    @RequestMapping(value="addEmpInfo.do", method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public JsonResult addEmpInfo() {
		
		return new JsonResult();
	}
	
	
	 @RequestMapping("/EmpAupload.do")  
	    public String upload(EmpAvatarinfo EMpA,HttpServletRequest request) throws Exception{  
	    System.out.println(request.getParameter("name"));  
	      //保存数据库的路径  
	      String sqlPath = null;   
	      //定义文件保存的本地路径  
	      String localPath="D:\\File\\";  
	      //定义 文件名  
	      String filename=null;    
	      if(!EMpA.getFile().isEmpty()){    
	          //生成uuid作为文件名称    
	          String uuid = UUID.randomUUID().toString().replaceAll("-","");    
	          //获得文件类型（可以判断如果不是图片，禁止上传）    
	          String contentType=EMpA.getFile().getContentType();    
	          //获得文件后缀名   
	          String suffixName=contentType.substring(contentType.indexOf("/")+1);  
	          //得到 文件名  
	          filename=uuid+"."+suffixName;   
	          System.out.println(filename);  
	          //文件保存路径  
	          EMpA.getFile().transferTo(new File(localPath+filename));    
	      }  
	      //把图片的相对路径保存至数据库  
	      sqlPath = "/images/"+filename;  
	      System.out.println(sqlPath);  
	      EMpA.setUrl(sqlPath);  
	   //   userService.addUser(user);  
	  //    model.addAttribute("user", user);  
	      return "MyJsp";  
	    }  
	
	
	
	
	
	
}
