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

}
