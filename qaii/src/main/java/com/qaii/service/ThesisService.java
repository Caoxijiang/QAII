package com.qaii.service;

import java.util.List;

import com.qaii.domain.Thesis;

public interface ThesisService {
	
	int getCountNum();
	
	List<Thesis> getAllThesisMsg();

	int deleteMsg(Integer[] eid);

	Thesis selectByPrimaryKey(int id);

	int updateMsg(Thesis thesis);

	int insertMsg(Thesis thesis);
	
	int countEachMonththesis(String firstDay, String endDay);
}
