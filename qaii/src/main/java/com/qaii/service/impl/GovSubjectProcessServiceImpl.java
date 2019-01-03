package com.qaii.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaii.dao.GovsubjectprocessMapper;
import com.qaii.domain.Govsubjectprocess;
import com.qaii.service.GovSubjectProcessService;

@Service
public class GovSubjectProcessServiceImpl implements GovSubjectProcessService {
	
	@Resource
	private GovsubjectprocessMapper processmapper;

	@Override
	public List<Govsubjectprocess> getAllMsgBypid(Integer pid) {
		// TODO Auto-generated method stub
		return processmapper.getAllMsgBypid(pid);
	}

	@Override
	public int addProcess(Govsubjectprocess process) {
		// TODO Auto-generated method stub
		return processmapper.insert(process);
	}

	@Override
	public int deleteRecord(Integer[] id) {
		return processmapper.deleteByPrimaryKeys(id);
	}

}
