package com.qaii.service.impl;



import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaii.dao.UserMapper;
import com.qaii.domain.User;
import com.qaii.service.UserRoleService;
import com.qaii.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper usermapper;
	

	@Override
	public User checkLogin(User user) {
		// TODO Auto-generated method stub
		return usermapper.findWithLoginAndPassword(user);
	}

	@Override
	public int insert(User user) {
		// TODO Auto-generated method stub
		User user1=new User();
		user1.setAdminAccount(user.getAdminAccount());
		user1.setAdminPwd(user.getAdminPwd());
		usermapper.insert(user1);
		int userId=user1.getUserId();
		System.out.println(userId);
		return userId;
		
	}

	@Override
	public int delete(Integer[] userId) {
		// TODO Auto-generated method stub
		return usermapper.deleteByPrimaryKey(userId) ;
	}

	@Override
	public User findWithLogin(String userName) {
		return usermapper.findWithLogin(userName);
	}
}








	
	

	
	


