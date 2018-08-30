package com.qaii.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaii.dao.UserRoleMapper;
import com.qaii.domain.UserRole;
import com.qaii.service.UserRoleService;

@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService{
	@Resource
	private UserRoleMapper userRoleMapper;

	@Override
	public UserRole findUSerRoleByUserId(Integer userid) {
		
		return userRoleMapper.findUserRoleByUserId(userid);
	}

	@Override
	public int insert(UserRole userrole) {
		
		return userRoleMapper.insert(userrole);
	}

	@Override
	public List<Map<String, Object>> findUserRoleList() {
		
		return userRoleMapper.findUserRoleList();
	}

	@Override
	public int updateUserRoleByUid(UserRole r) {
		// TODO Auto-generated method stub
		return userRoleMapper.updateByPrimaryKey(r) ;
	}



	


}
