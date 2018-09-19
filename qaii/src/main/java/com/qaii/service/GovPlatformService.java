package com.qaii.service;

import java.util.List;

import com.qaii.domain.Govplatform;

public interface GovPlatformService {

	List<Govplatform> getAllPlatformMsg();
	
	int deleteMsg(Integer[] eid);
}
