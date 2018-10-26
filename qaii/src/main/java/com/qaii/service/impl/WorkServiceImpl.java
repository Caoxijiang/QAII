package com.qaii.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaii.dao.WorkMapper;
import com.qaii.domain.Work;
import com.qaii.service.WorkService;

@Service("workservice")
public class WorkServiceImpl implements WorkService {
	
	@Resource
	private WorkMapper workmapper;

	@Override
	public int getCountNum() {
		// TODO Auto-generated method stub
		return workmapper.selectCountNum();
	}

	@Override
	public List<Work> getAllWorkMsg() {
		// TODO Auto-generated method stub
		return workmapper.getAllWorkMsg();
	}

	@Override
	public int deleteMsg(Integer[] eid) {
		// TODO Auto-generated method stub
		return workmapper.deleteByPrimaryKeys(eid);
	}

	@Override
	public Work getMessage(int id) {
		// TODO Auto-generated method stub
		return workmapper.getMessage(id);
	}

	@Override
	public int updateMsg(Work work) {
		// TODO Auto-generated method stub
		return workmapper.updateByPrimaryKeySelective(work);
	}

	@Override
	public int insertMsg(Work work) {
		// TODO Auto-generated method stub
		return workmapper.insert(work);
	}

	@Override
	public int countEachMonthwork(String firstDay, String endDay) {
		// TODO Auto-generated method stub
		return workmapper.countEachMonthwork(firstDay, endDay);
	}

	@Override
	public int insertMessage(Work work) {
		// TODO Auto-generated method stub
		return workmapper.insertMessage(work);
	}

	@Override
	public List<Work> listNotPass() {
		// TODO Auto-generated method stub
		return workmapper.listNotPass();
	}

}
