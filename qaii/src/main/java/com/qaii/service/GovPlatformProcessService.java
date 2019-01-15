package com.qaii.service;

import java.util.List;

import com.qaii.domain.Govplatformprocess;

public interface GovPlatformProcessService {
	
	List<Govplatformprocess> getAllMsgBypid(Integer pid);
	
	int addProcess(Govplatformprocess process);

	int deleteRecord(Integer[] id);

	int deleteByPid(Integer[] pid);
}
