package com.qaii.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaii.dao.WorkFileMapper;
import com.qaii.domain.WorkFile;
import com.qaii.service.WorkFileService;

@Service
public class WorkFileServiceImpl implements WorkFileService {

	@Resource
	private WorkFileMapper mapper;
	
	@Override
	public int insertMessage(WorkFile record) {
		// TODO Auto-generated method stub
		return mapper.insert(record);
	}

	@Override
	public int updateMessage(WorkFile record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int deleteMessage(long id) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(id);
	}

}
