package com.qaii.service;

import com.qaii.domain.MeetingThesisFile;

public interface MeetingThesisFileService {
	
	int insertMessage(MeetingThesisFile record);
	
	int updateMessage(MeetingThesisFile record);
	
	int deleteMessage(long id);

}
