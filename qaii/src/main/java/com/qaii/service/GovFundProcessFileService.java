package com.qaii.service;

import java.util.List;

import com.qaii.domain.Govfundprocessfile;

public interface GovFundProcessFileService {
	
	int insertMsg(Govfundprocessfile record);
	
	List<Govfundprocessfile> getAllMsg(Integer sid);
	
	int deleteByPrimaryKey(Integer[] id);
	
	int updateMsg(Govfundprocessfile record);

	int deleteBySid(Integer sid);

}
