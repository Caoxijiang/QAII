package com.qaii.service;

import java.util.List;

import com.qaii.domain.Copyright;

public interface CopyrightService {

	List<Copyright> listCopyright();
	
	int insert(Copyright copyright);
	
	Copyright selectByPrimaryKey(Integer id);
	
	int update(Copyright copyright);
	
	int delete(Integer[] id);
}
