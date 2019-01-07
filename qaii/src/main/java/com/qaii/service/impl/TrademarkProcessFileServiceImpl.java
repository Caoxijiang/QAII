package com.qaii.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaii.dao.TrademarkprocessfileMapper;
import com.qaii.domain.Trademarkprocessfile;
import com.qaii.service.TrademarkProcessFileService;
@Service()
public class TrademarkProcessFileServiceImpl implements TrademarkProcessFileService {
	
	@Resource
	private TrademarkprocessfileMapper processfilemapper;

	@Override
	public int insertMsg(Trademarkprocessfile record) {
		// TODO Auto-generated method stub
		return processfilemapper.insert(record);
	}

	@Override
	public List<Trademarkprocessfile> getAllMsg(Integer sid) {
		// TODO Auto-generated method stub
		return processfilemapper.getAllMsgBysid(sid);
	}

	@Override
	public int deleteByPrimaryKey(Integer[] id) {
		// TODO Auto-generated method stub
		return processfilemapper.deleteMsg(id);
	}

	@Override
	public int updateMsg(Trademarkprocessfile record) {
		// TODO Auto-generated method stub
		return processfilemapper.updateByPrimaryKey(record);
	}

	@Override
	public int deleteBySid(Integer sid) {
		return processfilemapper.deleteBySid(sid);
	}

}
