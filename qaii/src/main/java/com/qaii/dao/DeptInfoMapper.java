package com.qaii.dao;

import java.util.List;

import com.qaii.domain.DeptInfo;

public interface DeptInfoMapper {
	
	List<DeptInfo> findAlldeptInfoList();
	
	int dellDeptInfoByid(Integer id);
}
