package com.qaii.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaii.dao.CopyrightMapper;
import com.qaii.domain.Copyright;
import com.qaii.service.CopyrightService;

@Service
public class CopyrightServiceImpl implements CopyrightService {

	@Resource
	private CopyrightMapper mapper;
	
	@Override
	public List<Copyright> listCopyright() {
		// TODO Auto-generated method stub
		return mapper.listCopyright();
	}

	@Override
	public int insert(Copyright copyright) {
		// TODO Auto-generated method stub
		return mapper.insert(copyright);
	}

	@Override
	public Copyright selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mapper.selectWithUrl(id);
	}

	@Override
	public int update(Copyright copyright) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKey(copyright);
	}

	@Override
	public int delete(Integer[] id) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKeys(id);
	}

}
