package com.qaii.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaii.dao.IncubatorMapper;
import com.qaii.domain.Incubator;
import com.qaii.service.IncubatorService;

import java.util.List;

@Service("incubatorService")
public class IncubatorServiceImpl implements IncubatorService {
	@Resource
	private IncubatorMapper incubatorMapper;

	@Override
	public int insert(Incubator incubator) {
		
		return incubatorMapper.insert(incubator);
	}

	@Override
	public List<String> selectestablishtime() {
		return incubatorMapper.selectestablishtime();
	}

	@Override
	public int selectCountNums(String establishtime) {
		return incubatorMapper.selectCountNums(establishtime);
	}
	public Incubator selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return incubatorMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Incubator> selectAlllist() {
		// TODO Auto-generated method stub
		return incubatorMapper.selectAlllist();
	}

	@Override
	public int selectCountNumsByQianFan() {
		return incubatorMapper.selectCountNumsByQianFan();
	}

	@Override
	public int selectCountNumsByGaoxin() {
		return incubatorMapper.selectCountNumsByGaoxin();
	}

	@Override
	public int selectCountNumsByBaiQIan() {
		return incubatorMapper.selectCountNumsByBaiQIan();
	}

	@Override
	public int selectCountNumsByMiddleLittle() {
		return incubatorMapper.selectCountNumsByMiddleLittle();
	}

	@Override
	public int updateByPrimaryKeySelective(Incubator incubator) {
		// TODO Auto-generated method stub
		return incubatorMapper.updateByPrimaryKeySelective(incubator);
	}

	@Override
	public int deleteByPrimaryKey(Integer[] id) {
		return incubatorMapper.deleteByPrimaryKey(id);
	}
}
