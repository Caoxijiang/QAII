package com.qaii.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaii.dao.PeriodicalThesisFileMapper;
import com.qaii.domain.PeriodicalThesisFile;
import com.qaii.service.PeriodicalThesisFileService;

@Service
public class PeriodicalThesisFileServiceImpl implements PeriodicalThesisFileService {

	@Resource
	private PeriodicalThesisFileMapper mapper;
	
	@Override
	public int insertMessage(PeriodicalThesisFile record) {
		// TODO Auto-generated method stub
		return mapper.insert(record);
	}

	@Override
	public int updateMessage(PeriodicalThesisFile record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int deleteMessage(long id) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(id);
	}

}
