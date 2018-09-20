package com.qaii.service;

import java.util.List;

import com.qaii.domain.Govfund;

public interface GovFundService {
	
	List<Govfund> getAllFundMsg();
	
	int deleteMsg(Integer[] eid);
}
