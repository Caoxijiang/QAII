package com.qaii.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaii.dao.GovrewardMapper;
import com.qaii.domain.Govreward;
import com.qaii.service.GovRewardService;
@Service("govreward")
public class GovRewardServiceImpl implements GovRewardService {

	@Resource
	private GovrewardMapper govrewardmapper;
	@Override
	public List<Govreward> getAllRewardMsg() {
		// TODO Auto-generated method stub
		return govrewardmapper.getAllrewardMsg();
	}
	@Override
	public int deleteMsg(Integer[] eid) {
		// TODO Auto-generated method stub
		return govrewardmapper.deleteByPrimaryKeys(eid);
	}
	@Override
	public Govreward selectByPrimaryKey(int id) {
		// TODO Auto-generated method stub
		return govrewardmapper.selectByPrimaryKey(id);
	}
	@Override
	public int updateMsg(Govreward govreward) {
		// TODO Auto-generated method stub
		return govrewardmapper.updateByPrimaryKey(govreward);
	}
	@Override
	public int insertMsg(Govreward govreward) {
		// TODO Auto-generated method stub
		return govrewardmapper.insert(govreward);
	}
	@Override
	public List<Govreward> listByNum(int num) {
		// TODO Auto-generated method stub
		return govrewardmapper.listByNum(num);
	}

}
