package com.qaii.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaii.dao.GovrewardprocessfileMapper;
import com.qaii.domain.Govrewardprocessfile;
import com.qaii.service.GovRewardProcessFileService;

@Service
public class GovRewardProcessFileServiceImpl implements GovRewardProcessFileService {
	
	@Resource
	private GovrewardprocessfileMapper processfilemapper;

	@Override
	public int insertMsg(Govrewardprocessfile record) {
		// TODO Auto-generated method stub
		return processfilemapper.insert(record);
	}

	@Override
	public List<Govrewardprocessfile> getAllMsg(Integer sid) {
		// TODO Auto-generated method stub
		return processfilemapper.getAllMsgBysid(sid);
	}

	@Override
	public int deleteByPrimaryKey(Integer[] id) {
		// TODO Auto-generated method stub
		return processfilemapper.deleteMsg(id);
	}

	@Override
	public int updateMsg(Govrewardprocessfile record) {
		// TODO Auto-generated method stub
		return processfilemapper.updateByPrimaryKey(record);
	}

	@Override
	public int deleteBySid(Integer sid) {
		return processfilemapper.deleteBySid(sid);
	}

}
