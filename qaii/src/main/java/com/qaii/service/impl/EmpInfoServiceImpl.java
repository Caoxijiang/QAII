package com.qaii.service.impl;

import java.util.List;
import java.util.Map;

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


	@Override
	public List<EmpInfo> findAllEmpInfo() {
		// TODO Auto-generated method stub
		return empinfoService.findAllEmpInfo();
	}





	
}
