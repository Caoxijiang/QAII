package com.qaii.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaii.dao.GovfundprocessMapper;
import com.qaii.domain.Govfundprocess;
import com.qaii.service.GovFundProcessService;

@Service
public class GovFundProcessServiceImpl implements GovFundProcessService {
	
	@Resource
	private GovfundprocessMapper processmapper;

	@Override
	public List<Govfundprocess> getAllMsgBypid(Integer pid) {
		// TODO Auto-generated method stub
		return processmapper.getAllMsgBypid(pid);
	}

	@Override
	public int addProcess(Govfundprocess process) {
		// TODO Auto-generated method stub
		return processmapper.insert(process);
	}

}
