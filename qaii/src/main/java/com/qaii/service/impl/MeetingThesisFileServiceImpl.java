package com.qaii.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaii.dao.MeetingThesisFileMapper;
import com.qaii.domain.MeetingThesisFile;
import com.qaii.service.MeetingThesisFileService;

@Service
public class MeetingThesisFileServiceImpl implements MeetingThesisFileService {

	@Resource
	private MeetingThesisFileMapper mapper;
	
	@Override
	public int insertMessage(MeetingThesisFile record) {
		// TODO Auto-generated method stub
		return mapper.insert(record);
	}

	@Override
	public int updateMessage(MeetingThesisFile record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int deleteMessage(long id) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(id);
	}

}
