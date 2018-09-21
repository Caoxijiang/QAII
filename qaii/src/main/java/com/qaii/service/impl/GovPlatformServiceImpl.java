package com.qaii.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaii.dao.GovplatformMapper;
import com.qaii.domain.Govplatform;
import com.qaii.service.GovPlatformService;
@Service("govplatform")
public class GovPlatformServiceImpl implements GovPlatformService {

	@Resource
	private GovplatformMapper govplatformmapper;
	@Override
	public List<Govplatform> getAllPlatformMsg() {
		// TODO Auto-generated method stub
		return govplatformmapper.getAllPlatformMsg();
	}
	@Override
	public int deleteMsg(Integer[] eid) {
		// TODO Auto-generated method stub
		return govplatformmapper.deleteByPrimaryKeys(eid);
	}
	@Override
	public Govplatform selectByPrimaryKey(int id) {
		// TODO Auto-generated method stub
		return govplatformmapper.selectByPrimaryKey(id);
	}
	@Override
	public int updateMsg(Govplatform govplatform) {
		// TODO Auto-generated method stub
		return govplatformmapper.updateByPrimaryKey(govplatform);
	}
	@Override
	public int insertMsg(Govplatform govplatform) {
		// TODO Auto-generated method stub
		return govplatformmapper.insert(govplatform);
	}

}
