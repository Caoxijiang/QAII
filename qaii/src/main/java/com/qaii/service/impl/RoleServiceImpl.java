package com.qaii.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaii.dao.RoleMapper;
import com.qaii.domain.Role;
import com.qaii.service.RoleService;

@Service("RoleService")
public class RoleServiceImpl implements RoleService {
	@Resource
	private RoleMapper rolemapper;

	@Override
	public int insert(Role role) {
		
		return rolemapper.insert(role);
	}

	@Override
	public List<Role> findAllRoleList() {
		// TODO Auto-generated method stub
		return rolemapper.findAllroleList();
	}






}
