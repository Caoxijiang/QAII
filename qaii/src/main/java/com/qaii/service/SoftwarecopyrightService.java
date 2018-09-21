package com.qaii.service;

import java.util.List;

import com.qaii.domain.Softwarecopyright;

public interface SoftwarecopyrightService {
	
	int getCountNum();
	
	List<Softwarecopyright> getAllSoftwareMsg();

	int dellsoftMsg(Integer[] eid);
	
	Softwarecopyright selectByPrimaryKey(int id);
	
	int updateSoft(Softwarecopyright soft);
	
	int insertSoft(Softwarecopyright soft);
}
