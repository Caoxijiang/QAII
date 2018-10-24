package com.qaii.service;

import java.util.List;

import com.qaii.domain.MeetingThesis;

public interface MeetingThesisService {
	
	List<MeetingThesis> listAllMessage();
	
	int deleteMessages(Integer[] id);
	
	MeetingThesis getMessage(long id);
	
	int updateMessage(MeetingThesis record);
	
	//此方法可以保存插入对象的id
	int insertMessage(MeetingThesis record);

}
