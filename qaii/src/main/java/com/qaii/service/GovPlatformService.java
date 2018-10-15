package com.qaii.service;

import java.util.List;

import com.qaii.domain.Govplatform;

public interface GovPlatformService {

	List<Govplatform> getAllPlatformMsg();
	
	int deleteMsg(Integer[] eid);

	Govplatform selectByPrimaryKey(int id);

	int updateMsg(Govplatform govplatform);

	int insertMsg(Govplatform govplatform);
	
	List<Govplatform> listByNum(int num);
}
