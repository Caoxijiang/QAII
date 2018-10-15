package com.qaii.service;

import java.util.List;

import com.qaii.domain.Govrewardprocess;

public interface GovRewardProcessService {
	
	List<Govrewardprocess> getAllMsgBypid(Integer pid);
	
	int addProcess(Govrewardprocess process);

}
