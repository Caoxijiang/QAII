package com.qaii.service;

import java.util.List;

import com.qaii.domain.Incubator;

import java.util.List;

public interface IncubatorService {
	int insert(Incubator incubator );
	List<String> selectestablishtime();
	int selectCountNums(String establishtime);
	int selectCountNumsByQianFan();
	int selectCountNumsByGaoxin();
	int selectCountNumsByBaiQIan();
	int selectCountNumsByMiddleLittle();
	Incubator selectByPrimaryKey(Integer id);
	List<Incubator> selectAlllist();
	int updateByPrimaryKeySelective(Incubator incubator);
	int deleteByPrimaryKey(Integer[] id);
}
