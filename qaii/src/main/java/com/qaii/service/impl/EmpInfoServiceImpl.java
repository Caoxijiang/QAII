package com.qaii.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaii.dao.EmpInfoMapper;
import com.qaii.domain.EmpInfo;
import com.qaii.service.EmpInfoService;
@Service("empInfoService")
public class EmpInfoServiceImpl implements EmpInfoService{
	
	@Resource
	private EmpInfoMapper empinfoService;
	

	@Override
	public int insert(EmpInfo info) {
		// TODO Auto-generated method stub
		return empinfoService.insert(info);
	}
	@Override
	public List<EmpInfo> getcontractmsg(String empContractendtime) {
		// TODO Auto-generated method stub
		return empinfoService.checkbyContract(empContractendtime);
	}
	@Override
	public List<EmpInfo> gettrymsg(String empTryoutendtime) {
		// TODO Auto-generated method stub
		return empinfoService.checkbyTry(empTryoutendtime);
	}
	@Override
	public int countEntry(String lastm, String thism) {
		// TODO Auto-generated method stub
		return empinfoService.selectnumbyEntry(lastm, thism);
	}
	@Override
	public int countDepart(String lastm, String thism) {
		// TODO Auto-generated method stub
		return empinfoService.selectnumbyDeparture(lastm, thism);
	}
	@Override
	public int countnumofcollege(String lastm, String thism) {
		// TODO Auto-generated method stub
		return empinfoService.selectnumofcollege(lastm, thism);
	}
	@Override
	public int countnumofIncubationComp(String lasty, String thisy) {
		// TODO Auto-generated method stub
		return empinfoService.selectnumofIncubationComp(lasty, thisy);
	}
	@Override
	public int countnumofcollegeComp(String lasty, String thisy) {
		// TODO Auto-generated method stub
		return empinfoService.selectnumofcollegeComp(lasty, thisy);
	}
	@Override
	public int countnumfoTalents(String dept) {
		// TODO Auto-generated method stub
		return empinfoService.selectnumoftalnets(dept);
	}
	@Override
	public int countHigherTalents(String title) {
		// TODO Auto-generated method stub
		return empinfoService.selectnumofHightalents(title);
	}

	
	
}
