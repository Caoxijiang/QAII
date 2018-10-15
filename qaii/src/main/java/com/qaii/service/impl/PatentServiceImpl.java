package com.qaii.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaii.dao.PatentMapper;
import com.qaii.service.PatentService;

import com.qaii.domain.Patent;
import com.qaii.service.PatentService;

@Service("PatentService")
public class PatentServiceImpl implements PatentService{
	@Resource
	private PatentMapper patentMapper;

	@Override
	public int getPatentCount() {
		// TODO Auto-generated method stub
		return patentMapper.selectCountbyNum();
	}
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

	@Override
	public Patent selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return patentMapper.selectByPrimaryKey(id);
	}

	@Override
	public int deleteByPrimaryKey(Integer[] id) {
		// TODO Auto-generated method stub
		return patentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(Patent record) {
		// TODO Auto-generated method stub
		return patentMapper.updateByPrimaryKey(record);
	}
	@Override
	public int countAgencyPatent(String firstDay, String endDay) {
		// TODO Auto-generated method stub
		return patentMapper.countAgencyPatent(firstDay, endDay);
	}
	@Override
	public int countAuthorizationPatent(String firstDay, String endDay) {
		// TODO Auto-generated method stub
		return patentMapper.countAuthorizationPatent(firstDay, endDay);
	}
	@Override
	public int countAuthorizationPatentNum() {
		// TODO Auto-generated method stub
		return patentMapper.countAuthorizationPatentNum();
	}

	


}
