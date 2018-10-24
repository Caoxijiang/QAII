package com.qaii.service;

import com.qaii.domain.PeriodicalThesisFile;

public interface PeriodicalThesisFileService {
	
	int insertMessage(PeriodicalThesisFile record);
	
	int updateMessage(PeriodicalThesisFile record);
	
	int deleteMessage(long id);

}
