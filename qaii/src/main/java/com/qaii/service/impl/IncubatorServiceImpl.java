package com.qaii.service.impl;

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
}
