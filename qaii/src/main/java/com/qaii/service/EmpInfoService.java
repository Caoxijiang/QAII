package com.qaii.service;

import java.util.List;
import java.util.Map;

import com.qaii.domain.EmpInfo;

public interface EmpInfoService {
	int insert(EmpInfo info);
	List<EmpInfo> findAllEmpInfo();
}
