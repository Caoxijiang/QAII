package com.qaii.service;

import java.util.List;

import com.qaii.domain.Govsubjectprocessfile;

public interface GovSubjectProcessFileService {
	
	int insertMsg(Govsubjectprocessfile record);
	
	List<Govsubjectprocessfile> getAllMsg(Integer sid);
	
	int deleteByPrimaryKey(Integer[] id);
	
	int updateMsg(Govsubjectprocessfile record);

}
