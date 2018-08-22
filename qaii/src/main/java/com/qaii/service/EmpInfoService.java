package com.qaii.service;

import java.util.List;

import com.qaii.domain.EmpInfo;

public interface EmpInfoService {
	int insert(EmpInfo info);
	List<EmpInfo> getcontractmsg(String empContractendtime);
	List<EmpInfo> gettrymsg(String empTryoutendtime);
}
