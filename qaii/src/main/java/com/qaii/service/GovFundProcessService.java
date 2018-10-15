package com.qaii.service;

import java.util.List;

import com.qaii.domain.Govfundprocess;

public interface GovFundProcessService {
	
	List<Govfundprocess> getAllMsgBypid(Integer pid);
	
	int addProcess(Govfundprocess process);

}
