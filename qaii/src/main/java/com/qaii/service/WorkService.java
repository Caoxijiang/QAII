package com.qaii.service;

import java.util.List;

import com.qaii.domain.Work;

public interface WorkService {
	
	int getCountNum();
	
	List<Work> getAllWorkMsg();
	
	int deleteMsg(Integer[] eid);

}
