package com.qaii.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaii.dao.PatentMapper;
import com.qaii.domain.Patent;
import com.qaii.service.PatentService;

@Service("PatentService")
public class PatentServiceImpl implements PatentService{
	@Resource
	private PatentMapper patentMapper;

	@Override
	public int insert(Patent record) {
		// TODO Auto-generated method stub
		return patentMapper.insert(record);
	}

	@Override
	public List<Patent> findAllPatentInfo() {
		// TODO Auto-generated method stub
		return patentMapper.findAllPatentInfo();
	}

}