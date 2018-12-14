package com.qaii.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaii.dao.StockEquityMapper;
import com.qaii.domain.StockEquity;
import com.qaii.service.StockEquityService;
@Service("stockEquityService")
public class StockEquityServiceImpl implements StockEquityService{
	@Resource
	private StockEquityMapper StockEquityMapper;
	
	@Override
	public int insert(StockEquity stockEquity) {
		
		return StockEquityMapper.insert(stockEquity);
	}

	@Override
	public List<StockEquity> selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return StockEquityMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateShareholderStatus(Integer id) {
		return StockEquityMapper.updateShareholderStatus(id);
	}
}
