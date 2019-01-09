package com.qaii.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaii.dao.GovplatformprocessMapper;
import com.qaii.domain.Govplatformprocess;

@Service
public class GovPlatformProcessServiceImpl implements com.qaii.service.GovPlatformProcessService {
	
	@Resource
	private GovplatformprocessMapper processmapper;

	@Override
	public List<Govplatformprocess> getAllMsgBypid(Integer pid) {
		// TODO Auto-generated method stub
		return processmapper.getAllMsgBypid(pid);
	}

	@Override
	public int addProcess(Govplatformprocess process) {
		// TODO Auto-generated method stub
		return processmapper.insert(process);
	}

	@Override
	public int deleteRecord(Integer[] id) {
		return processmapper.deleteByPrimaryKeys(id);
	}

	@Override
	public int deleteByPid(Integer[] pid) {
		return processmapper.deleteByPid(pid);
	}

}
