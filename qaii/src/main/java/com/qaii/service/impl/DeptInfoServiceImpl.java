package com.qaii.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaii.dao.DeptInfoMapper;
import com.qaii.domain.DeptInfo;
import com.qaii.service.DeptInfoService;

@Service("deptInfoService")
public class DeptInfoServiceImpl implements DeptInfoService{
	@Resource
	private DeptInfoMapper deptInfoMapper;
	@Override
	public List<DeptInfo> findAllRoleList() {
		// TODO Auto-generated method stub
		return deptInfoMapper.findAlldeptInfoList();
	}
	
	@Override
	public int dellDeptInfoByid(Integer id) {
		// TODO Auto-generated method stub
		return deptInfoMapper.dellDeptInfoByid(id);
	}

	@Override
	public int addDeptInfo(DeptInfo dept) {
		// TODO Auto-generated method stub
		return deptInfoMapper.addDeptinfo(dept);
	}

	@Override
	public int updateDeptInfoById(DeptInfo dept) {
		// TODO Auto-generated method stub
		return deptInfoMapper.updateDeptInfoById(dept) ;
	}

}
