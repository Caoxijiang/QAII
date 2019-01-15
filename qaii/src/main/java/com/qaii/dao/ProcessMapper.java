package com.qaii.dao;

import java.util.List;

import com.qaii.domain.PatProcess;

public interface ProcessMapper {
	int addProcessInfo(PatProcess process);
	
	List<PatProcess> findProcessList(Integer pid);

	int deleteByPrimaryKeys(Integer[] id);

	int deleteByPid(Integer[] pid);
}
