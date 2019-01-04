package com.qaii.service;

import java.util.List;

import com.qaii.domain.Trademarkprocess;

public interface TrademarkProcessService {

	List<Trademarkprocess> getAllMsgBypid(Integer pid);
	
	int addProcess(Trademarkprocess process);

	int deleteRecord(Integer[] id);
}
