package com.qaii.service;

import java.util.List;

import com.qaii.domain.Govsubject;

public interface GovSubjectService {
	
	List<Govsubject> getAllSubjectMsg();
	
	int deleteMsg(Integer[] eid);

	Govsubject selectByPrimaryKey(int id);

	int updateMsg(Govsubject govsubject);

	int insertMsg(Govsubject govsubject);
	
	List<Govsubject> listByNum(int num);

}
