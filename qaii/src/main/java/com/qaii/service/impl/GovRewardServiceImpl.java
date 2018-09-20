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

}
