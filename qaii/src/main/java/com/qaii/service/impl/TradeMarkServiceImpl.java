package com.qaii.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaii.dao.TrademarkMapper;
import com.qaii.domain.Trademark;
import com.qaii.service.TradeMarkService;

@Service("trademark")
public class TradeMarkServiceImpl implements TradeMarkService {
	
	@Resource
	private TrademarkMapper trademarkmapper;

	@Override
	public int getCountNum() {
		// TODO Auto-generated method stub
		return trademarkmapper.selectCountNum();
	}

	@Override
	public List<Trademark> getAllTradeMarkMsg() {
		// TODO Auto-generated method stub
		return trademarkmapper.getAllTradeMarkMsg();
	}

	@Override
	public int deleteMsg(Integer[] eid) {
		// TODO Auto-generated method stub
		return trademarkmapper.deleteByPrimaryKeys(eid);
	}

}
