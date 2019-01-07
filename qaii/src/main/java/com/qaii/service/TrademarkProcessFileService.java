package com.qaii.service;

import java.util.List;

import com.qaii.domain.Trademarkprocessfile;

public interface TrademarkProcessFileService {
	
	int insertMsg(Trademarkprocessfile record);
	
	List<Trademarkprocessfile> getAllMsg(Integer sid);
	
	int deleteByPrimaryKey(Integer[] id);
	
	int updateMsg(Trademarkprocessfile record);

	int deleteBySid(Integer sid);
}
