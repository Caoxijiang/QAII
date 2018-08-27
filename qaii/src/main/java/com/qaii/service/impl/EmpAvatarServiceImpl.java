package com.qaii.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaii.dao.EmpAvatarinfoMapper;
import com.qaii.domain.EmpAvatarinfo;
import com.qaii.service.EmpAvatarService;

@Service("empAvatarService")
public class EmpAvatarServiceImpl implements EmpAvatarService {
	 @Resource
	 private EmpAvatarinfoMapper empAvatarinfoMapper;

	@Override
	public int insert(EmpAvatarinfo empInfo) {
		// TODO Auto-generated method stub
		return empAvatarinfoMapper.insert(empInfo);
	}


	
}
