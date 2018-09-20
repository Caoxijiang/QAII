package com.qaii.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaii.dao.GovfundMapper;
import com.qaii.domain.Govfund;
import com.qaii.service.GovFundService;

@Service("govfund")
public class GovFundServiceImpl implements GovFundService {

	@Resource
	private GovfundMapper govfundmapper;
	@Override
	public List<Govfund> getAllFundMsg() {
		// TODO Auto-generated method stub
		return govfundmapper.getAllFundMsg();
	}
	@Override
	public int deleteMsg(Integer[] eid) {
		// TODO Auto-generated method stub
		return govfundmapper.deleteByPrimaryKeys(eid);
	}
	@Override
	public Govfund selectByPrimaryKey(int id) {
		// TODO Auto-generated method stub
		return govfundmapper.selectByPrimaryKey(id);
	}
	@Override
	public int updateMsg(Govfund govfund) {
		// TODO Auto-generated method stub
		return govfundmapper.updateByPrimaryKey(govfund);
	}
	@Override
	public int insertMsg(Govfund govfund) {
		// TODO Auto-generated method stub
		return govfundmapper.insert(govfund);
	}

}
