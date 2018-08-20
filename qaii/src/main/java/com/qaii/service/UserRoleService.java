package com.qaii.service;

import java.util.List;
import java.util.Map;

import com.qaii.domain.User;
import com.qaii.domain.UserRole;

public interface UserRoleService {
	UserRole findUSerRoleByUserId(Integer userid);
	int insert(UserRole userrole);
	List <Map<String,Object>> findUserRoleList();
	int updateUserRoleByUid(Integer uid);
}