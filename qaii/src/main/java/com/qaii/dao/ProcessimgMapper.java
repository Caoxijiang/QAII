package com.qaii.dao;

import java.util.List;

import com.qaii.domain.Processimg;

public interface ProcessimgMapper {
	int insert (Processimg img);

	List<Processimg> selectProimgList(Integer sid);
	
	int deleteByPrimaryKey(Integer[] id);
	
	int updataProcessInfo(Integer id);
}
