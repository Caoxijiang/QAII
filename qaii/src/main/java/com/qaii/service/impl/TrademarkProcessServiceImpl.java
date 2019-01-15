package com.qaii.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaii.dao.TrademarkprocessMapper;
import com.qaii.domain.Trademarkprocess;
import com.qaii.service.TrademarkProcessService;

@Service
public class TrademarkProcessServiceImpl implements TrademarkProcessService {
	
	@Resource
	private TrademarkprocessMapper processmapper;

	@Override
	public List<Trademarkprocess> getAllMsgBypid(Integer pid) {
		// TODO Auto-generated method stub
		return processmapper.getAllMsgBypid(pid);
	}

	@Override
	public int addProcess(Trademarkprocess process) {
		// TODO Auto-generated method stub
		return processmapper.insert(process);
	}

	@Override
	public int deleteRecord(Integer[] id) {
		return processmapper.deleteByPrimaryKeys(id);
	}

	@Override
	public int deleteByPid(Integer[] pid) {
		return processmapper.deleteByPid(pid);
	}

}
