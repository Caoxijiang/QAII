package com.qaii.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaii.dao.GovfundprocessfileMapper;
import com.qaii.domain.Govfundprocessfile;
import com.qaii.service.GovFundProcessFileService;

@Service
public class GovFundProcessFileServiceImpl implements GovFundProcessFileService {
	
	@Resource
	private GovfundprocessfileMapper processfilemapper;

	@Override
	public int insertMsg(Govfundprocessfile record) {
		// TODO Auto-generated method stub
		return processfilemapper.insert(record);
	}

	@Override
	public List<Govfundprocessfile> getAllMsg(Integer sid) {
		// TODO Auto-generated method stub
		return processfilemapper.getAllMsgBysid(sid);
	}

	@Override
	public int deleteByPrimaryKey(Integer[] id) {
		// TODO Auto-generated method stub
		return processfilemapper.deleteMsg(id);
	}

	@Override
	public int updateMsg(Govfundprocessfile record) {
		// TODO Auto-generated method stub
		return processfilemapper.updateByPrimaryKey(record);
	}

	@Override
	public int deleteBySid(Integer sid) {
		return processfilemapper.deleteBySid(sid);
	}

}
