package com.qaii.service;

import java.util.List;

import com.qaii.domain.Govsubjectprocess;

public interface GovSubjectProcessService {
	
	List<Govsubjectprocess> getAllMsgBypid(Integer pid);
	
	int addProcess(Govsubjectprocess process);

}
