package com.qaii.service;

import java.util.List;

import com.qaii.domain.DeptInfo;

public interface DeptInfoService {
	List <DeptInfo> findAllRoleList();
	
	int dellDeptInfoByid(Integer id);
}
