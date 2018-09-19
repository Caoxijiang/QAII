package com.qaii.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaii.dao.PatentMapper;
import com.qaii.service.PatentService;

@Service("patentService")
public class PatentServiceImpl implements PatentService {
	
	@Resource
	private PatentMapper patentMapper;

	@Override
	public int getPatentCount() {
		// TODO Auto-generated method stub
		return patentMapper.selectCountbyNum();
	}

}
