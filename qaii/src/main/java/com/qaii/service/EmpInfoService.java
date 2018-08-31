package com.qaii.service;

import java.util.List;

import java.util.Map;


import com.qaii.domain.EmpInfo;

public interface EmpInfoService {
	int insert(EmpInfo info);

	
	List<EmpInfo> getcontractmsg(String empContractendtime);
	
	List<EmpInfo> gettrymsg(String empTryoutendtime);
	
	int countEntry(String lastm,String thism);
	
	int countDepart(String lastm,String thism);
	
	int countnumofcollege(String lastm,String thism);
	
	int countnumofIncubationComp(String lasty,String thisy);
	
	int countnumofcollegeComp(String lasty,String thisy);
	
	int countnumfoTalents(String dept);
	
	int countHigherTalents(String title);

	List<EmpInfo> findAllEmpInfo();
	
	EmpInfo findEmpinfoAndAvatarByid(Integer id);
	
	int updateByPrimaryKey(EmpInfo emp);
	
	int delete(Integer[] eid);
	
	List <EmpInfo> findDellInfoByStatus();
	
	int updataempStatus(EmpInfo emp);
}
