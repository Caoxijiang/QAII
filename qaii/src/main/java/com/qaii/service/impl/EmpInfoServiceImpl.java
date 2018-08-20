package com.qaii.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaii.dao.EmpInfoMapper;
import com.qaii.domain.EmpInfo;
import com.qaii.service.EmpInfoService;
@Service("empInfoService")
public class EmpInfoServiceImpl implements EmpInfoService{
	
	@Resource
	private EmpInfoMapper empinfoService;
	

	@Override
	public int insert(EmpInfo info) {
		// TODO Auto-generated method stub
		return empinfoService.insert(info);
	}
	
	
}
