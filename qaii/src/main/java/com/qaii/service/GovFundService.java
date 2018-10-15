package com.qaii.service;

import java.util.List;

import com.qaii.domain.Govfund;

public interface GovFundService {
	
	List<Govfund> getAllFundMsg();
	
	int deleteMsg(Integer[] eid);

	Govfund selectByPrimaryKey(int id);

	int updateMsg(Govfund govfund);

	int insertMsg(Govfund govfund);
	
	List<Govfund> listByNum(int num);
}
