package com.qaii.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaii.dao.GovsubjectMapper;
import com.qaii.domain.Govsubject;
import com.qaii.service.GovSubjectService;
@Service("govsubject")
public class GovSubjectServiceImpl implements GovSubjectService {

	@Resource
	private GovsubjectMapper govsubjectmapper;
	@Override
	public List<Govsubject> getAllSubjectMsg() {
		// TODO Auto-generated method stub
		return govsubjectmapper.getAllSubjectMsg();
	}
	@Override
	public int deleteMsg(Integer[] eid) {
		// TODO Auto-generated method stub
		return govsubjectmapper.deleteByPrimaryKeys(eid);
	}

}
