package com.qaii.service;

import java.util.List;

import com.qaii.domain.Processimg;

public interface ProcessimgService {
	int insert (Processimg img);
	
	List<Processimg> selectProimgList(Integer sid);
	
	int deleteByPrimaryKey(Integer[] id);
	
	int updataProcessInfo(Integer id);
}
