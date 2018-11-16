package com.qaii.service;

import com.qaii.domain.Incubator;

import java.util.List;

public interface IncubatorService {
	int insert(Incubator incubator );
	List<String> selectestablishtime();
	int selectCountNums(String establishtime);
}
