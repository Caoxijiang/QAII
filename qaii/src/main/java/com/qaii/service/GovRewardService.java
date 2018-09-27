package com.qaii.service;

import java.util.List;

import com.qaii.domain.Govreward;

public interface GovRewardService {
	
	List<Govreward> getAllRewardMsg();
	
	int deleteMsg(Integer[] eid);

	Govreward selectByPrimaryKey(int id);

	int updateMsg(Govreward govreward);

	int insertMsg(Govreward govreward);

}
