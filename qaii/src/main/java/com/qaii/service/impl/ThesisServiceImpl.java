package com.qaii.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaii.dao.ThesisMapper;
import com.qaii.domain.Thesis;
import com.qaii.service.ThesisService;

@Service("thesis")
public class ThesisServiceImpl implements ThesisService {

	@Resource
	private ThesisMapper thesismapper;
	@Override
	public int getCountNum() {
		// TODO Auto-generated method stub
		return thesismapper.selectCountNum();
	}
	
	@Override
	public List<Thesis> getAllThesisMsg() {
		// TODO Auto-generated method stub
		return thesismapper.getAllThesisMsg();
	}

	@Override
	public int deleteMsg(Integer[] eid) {
		// TODO Auto-generated method stub
		return thesismapper.deleteByPrimaryKeys(eid);
	}

	@Override
	public Thesis selectByPrimaryKey(int id) {
		// TODO Auto-generated method stub
		return thesismapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateMsg(Thesis thesis) {
		// TODO Auto-generated method stub
		return thesismapper.updateByPrimaryKey(thesis);
	}

	@Override
	public int insertMsg(Thesis thesis) {
		// TODO Auto-generated method stub
		return thesismapper.insert(thesis);
	}
	

}
