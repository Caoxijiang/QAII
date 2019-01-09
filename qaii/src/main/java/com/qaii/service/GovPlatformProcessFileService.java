package com.qaii.service;

import java.util.List;

import com.qaii.domain.Govplatformprocessfile;

public interface GovPlatformProcessFileService {
	
	int insertMsg(Govplatformprocessfile record);
	
	List<Govplatformprocessfile> getAllMsg(Integer sid);
	
	int deleteByPrimaryKey(Integer[] id);
	
	int updateMsg(Govplatformprocessfile record);

	int deleteBySid(Integer sid);

	int deleteByOid(Integer[] oid);

}
