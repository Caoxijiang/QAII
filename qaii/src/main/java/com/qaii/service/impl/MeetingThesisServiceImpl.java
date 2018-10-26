package com.qaii.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaii.dao.MeetingThesisMapper;
import com.qaii.domain.MeetingThesis;
import com.qaii.service.MeetingThesisService;

@Service
public class MeetingThesisServiceImpl implements MeetingThesisService {

	@Resource
	private MeetingThesisMapper mapper;
	
	@Override
	public List<MeetingThesis> listAllMessage() {
		// TODO Auto-generated method stub
		return mapper.listAllMessage();
	}

	@Override
	public int deleteMessages(Integer[] id) {
		// TODO Auto-generated method stub
		return mapper.deleteMessages(id);
	}

	@Override
	public MeetingThesis getMessage(long id) {
		// TODO Auto-generated method stub
		return mapper.getMessage(id);
	}

	@Override
	public int updateMessage(MeetingThesis record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int insertMessage(MeetingThesis record) {
		// TODO Auto-generated method stub
		return mapper.insertMessage(record);
	}

	@Override
	public List<MeetingThesis> listNotPass() {
		// TODO Auto-generated method stub
		return mapper.listNotPass();
	}

}
