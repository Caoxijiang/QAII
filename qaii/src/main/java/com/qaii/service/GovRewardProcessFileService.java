package com.qaii.service;

import java.util.List;

import com.qaii.domain.Govrewardprocessfile;

public interface GovRewardProcessFileService {
	
	int insertMsg(Govrewardprocessfile record);
	
	List<Govrewardprocessfile> getAllMsg(Integer sid);
	
	int deleteByPrimaryKey(Integer[] id);
	
	int updateMsg(Govrewardprocessfile record);

	int deleteBySid(Integer sid);

}
