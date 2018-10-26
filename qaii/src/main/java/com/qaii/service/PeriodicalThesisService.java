package com.qaii.service;

import java.util.List;

import com.qaii.domain.PeriodicalThesis;

public interface PeriodicalThesisService {
	
	List<PeriodicalThesis> listAllMessage();
	
	int deleteMessages(Integer[] id);
	
	PeriodicalThesis getMessage(long id);
	
	int updateMessage(PeriodicalThesis record);
	
	//此方法可以保存插入对象的id
	int insertMessage(PeriodicalThesis record);

	List<PeriodicalThesis> listNotPass();
}
