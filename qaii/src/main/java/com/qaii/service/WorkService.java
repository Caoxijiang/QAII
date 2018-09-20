package com.qaii.service;

import java.util.List;

import com.qaii.domain.Work;

public interface WorkService {
	
	int getCountNum();
	
	List<Work> getAllWorkMsg();
	
	int deleteMsg(Integer[] eid);

	Work selectByPrimaryKey(int id);

	int updateMsg(Work work);

	int insertMsg(Work work);

}
