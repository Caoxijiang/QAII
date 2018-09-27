package com.qaii.service;

import java.util.List;

import com.qaii.domain.Trademark;

public interface TradeMarkService {
	
	int getCountNum();
	
	List<Trademark> getAllTradeMarkMsg();
	
	int deleteMsg(Integer[] eid);
	
	Trademark selectByPrimaryKey(int id);
	
	int updatetrademark(Trademark trademark);
	
	int insertMsg(Trademark trademark);
}
