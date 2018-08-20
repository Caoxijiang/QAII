package com.qaii.service;

import java.util.List;

import com.qaii.domain.Role;

public interface RoleService {
	int insert( Role role );
	List <Role> findAllRoleList();
}
