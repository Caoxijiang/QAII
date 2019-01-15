package com.qaii.service;

import java.util.List;

import com.alibaba.druid.sql.visitor.functions.Insert;
import com.qaii.domain.StockEquity;

public interface StockEquityService {
	int insert(StockEquity stockEquity);
	List<StockEquity> selectByPrimaryKey(Integer id);
	int updateShareholderStatus(Integer id);

	int deleteByIncubatorId(Integer[] id);

	int deleteByPrimaryKey(Integer id);
}
