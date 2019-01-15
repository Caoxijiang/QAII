package com.qaii.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaii.dao.GovplatformprocessfileMapper;
import com.qaii.domain.Govplatformprocessfile;

@Service
public class GovPlatformProcessFileServiceImpl implements com.qaii.service.GovPlatformProcessFileService {
	
	@Resource
	private GovplatformprocessfileMapper processfilemapper;

	@Override
	public int insertMsg(Govplatformprocessfile record) {
		// TODO Auto-generated method stub
		return processfilemapper.insert(record);
	}

	@Override
	public List<Govplatformprocessfile> getAllMsg(Integer sid) {
		// TODO Auto-generated method stub
		return processfilemapper.getAllMsgBysid(sid);
	}

	@Override
	public int deleteByPrimaryKey(Integer[] id) {
		// TODO Auto-generated method stub
		return processfilemapper.deleteMsg(id);
	}

	@Override
	public int updateMsg(Govplatformprocessfile record) {
		// TODO Auto-generated method stub
		return processfilemapper.updateByPrimaryKey(record);
	}

	@Override
	public int deleteBySid(Integer sid) {
		return processfilemapper.deleteBySid(sid);
	}

	@Override
	public int deleteByOid(Integer[] oid) {
		return processfilemapper.deleteByOid(oid);
	}

}
