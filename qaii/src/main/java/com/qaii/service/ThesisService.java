package com.qaii.service;

import java.util.List;

import com.qaii.domain.Thesis;

public interface ThesisService {
	
	int getCountNum();
	
	List<Thesis> getAllThesisMsg();

	int deleteMsg(Integer[] eid);
}
