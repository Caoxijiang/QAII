package com.qaii.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaii.dao.IncubatorFileMapper;
import com.qaii.domain.IncubatorFile;
import com.qaii.service.IncubatorFileService;
@Service("incubatorFileService")
public class IncubatorFileServiceImpl implements IncubatorFileService{
	@Resource
	private IncubatorFileMapper incubatorFileMapper;
	@Override
	public int insert(List<IncubatorFile>iFile) {
		// TODO Auto-generated method stub
		return incubatorFileMapper.insert(iFile) ;
	}
	@Override
	public List<IncubatorFile> selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return incubatorFileMapper.selectByPrimaryKey(id);
	}

}
