package com.qaii.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaii.dao.GovrewardprocessMapper;
import com.qaii.domain.Govrewardprocess;
import com.qaii.service.GovRewardProcessService;

@Service
public class GovRewardProcessServiceImpl implements GovRewardProcessService {
	
	@Resource
	private GovrewardprocessMapper processmapper;

	@Override
	public List<Govrewardprocess> getAllMsgBypid(Integer pid) {
		// TODO Auto-generated method stub
		return processmapper.getAllMsgBypid(pid);
	}

	@Override
	public int addProcess(Govrewardprocess process) {
		// TODO Auto-generated method stub
		return processmapper.insert(process);
	}

}
