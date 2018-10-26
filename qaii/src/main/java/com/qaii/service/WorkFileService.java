package com.qaii.service;

import com.qaii.domain.WorkFile;

public interface WorkFileService {
	
	int insertMessage(WorkFile record);
			
	int updateMessage(WorkFile record);
	
	int deleteMessage(long id);

}
