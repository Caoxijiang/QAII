package com.qaii.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaii.dao.GovsubjectprocessfileMapper;
import com.qaii.domain.Govsubjectprocessfile;
import com.qaii.service.GovSubjectProcessFileService;

@Service
public class GovSubjectProcessFileServiceImpl implements GovSubjectProcessFileService {
	
	@Resource
	private GovsubjectprocessfileMapper processfilemapper;

	@Override
	public int insertMsg(Govsubjectprocessfile record) {
		// TODO Auto-generated method stub
		return processfilemapper.insert(record);
	}

	@Override
	public List<Govsubjectprocessfile> getAllMsg(Integer sid) {
		// TODO Auto-generated method stub
		return processfilemapper.getAllMsgBysid(sid);
	}

	@Override
	public int deleteByPrimaryKey(Integer[] id) {
		// TODO Auto-generated method stub
		return processfilemapper.deleteMsg(id);
	}

	@Override
	public int updateMsg(Govsubjectprocessfile record) {
		// TODO Auto-generated method stub
		return processfilemapper.updateByPrimaryKey(record);
	}

	@Override
	public int deleteBySid(Integer sid) {
		return processfilemapper.deleteBySid(sid);
	}

}
