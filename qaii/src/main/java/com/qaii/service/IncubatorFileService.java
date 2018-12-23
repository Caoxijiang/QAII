package com.qaii.service;

import java.util.List;

import com.qaii.domain.IncubatorFile;

public interface IncubatorFileService {
	int insert(List<IncubatorFile> iFlist);
	
	List<IncubatorFile> selectByPrimaryKey(Integer id);

	int updateByPrimaryKey(List<IncubatorFile> record);
}
