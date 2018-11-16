package com.qaii.service;

import java.util.List;

import com.qaii.domain.Incubator;

public interface IncubatorService {
	int insert(Incubator incubator );
	Incubator selectByPrimaryKey(Integer id);
	List<Incubator> selectAlllist();
}
