package com.qaii.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qaii.domain.User;
import com.qaii.domain.UserRole;
import com.qaii.domain.Role;
import com.qaii.service.RoleService;
import com.qaii.service.UserRoleService;
import com.qaii.service.UserService;

import com.qaii.util.JsonResult;
import com.qaii.util.Layui;

import net.sf.json.JSONObject;

@Controller
public class RoleController {
	
	@Resource
	private UserService userServivce;
	
	@Resource
	private RoleService roleServivce;
	
	@Resource
	private UserRoleService userroleServivce;
	
	
	@RequestMapping("Role.do")
	public String Role(){
		return "page/limited";
	}
	
	@RequestMapping("RoleIframe.do")
	public String RoleIframe(){
		return "page/limited-iframe";
	}
	
	@RequestMapping("limitededit.do")
	public String limitededit(){
		return "page/limited-edit";
	}
	
	
	@RequestMapping("RoleIframeadd.do")
	public String RoleIframeadd(){
		return "page/limited-add";
	}
	@ResponseBody
	@RequestMapping(value="addRoleuser.do", method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public JsonResult addUser(User user, UserRole role ,String requestDate ) {						
		Map map = new HashMap();
		JSONObject requestJson = JSONObject.fromObject(requestDate);
		map.put("name", requestJson.getString("name"));
		map.put("password", requestJson.getString("password"));
		map.put("role", requestJson.getString("role"));
		user.setAdminAccount(requestJson.getString("name"));
		user.setAdminPwd(requestJson.getString("password"));
		role.setRid(requestJson.getInt("role"));
		//int row=userServivce.insert(user);	
		int id= userServivce.insert(user);		
		if(id!=-1) {
			role.setUid(id);
			int row =userroleServivce.insert(role);
			if(row!=-1) {
				//String data="添加成功";
				System.out.println(new JsonResult(row));
				return new JsonResult(row);
			}else {
				return new JsonResult();
			}
			
		}else {
			return new JsonResult();
		}
	
	
		
		
		
	}
	
	@ResponseBody
	@RequestMapping(value="findRoleuser.do", method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public JsonResult findroleList() {
		List <Role> role= roleServivce.findAllRoleList();
		System.out.println(role);
		if(role!=null) {
			return new JsonResult(role);
			
		}
		else {
			return new JsonResult();
		}
		
	}
	
	@ResponseBody
	@RequestMapping(value="findUserRoleList.do", method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public Layui findUserRoleList() {
	List<Map<String,Object>>userrole= userroleServivce.findUserRoleList();
	int count =userrole.size();
	System.out.println(count);
		if(userrole!=null) {
			return Layui.data(count, userrole);
		}else {
			return Layui.data(count, userrole);
		}

	}
	
	@ResponseBody
	@RequestMapping(value="updateUserRole.do", method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public JsonResult updateUserRole(@Param("uid") Integer uid) {
		int row=userroleServivce.updateUserRoleByUid(uid);
		if(row>0) {
			return new JsonResult(row);
		}else {
			return new JsonResult(row);
		}
	}
}