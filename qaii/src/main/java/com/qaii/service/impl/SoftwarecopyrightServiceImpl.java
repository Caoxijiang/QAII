package com.qaii.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaii.dao.SoftwarecopyrightMapper;
import com.qaii.domain.Softwarecopyright;
import com.qaii.service.SoftwarecopyrightService;

@Service("softwarecopyright")
public class SoftwarecopyrightServiceImpl implements SoftwarecopyrightService {
	
	@Resource
	private SoftwarecopyrightMapper softMapper;

	@Override
	public int getCountNum() {
		// TODO Auto-generated method stub
		return softMapper.selectCountNum();
	}

	@Override
	public List<Softwarecopyright> getAllSoftwareMsg() {
		// TODO Auto-generated method stub
		return softMapper.getAllSoftWareMsg();
	}

	@Override
	public int dellsoftMsg(Integer[] eid) {
		// TODO Auto-generated method stub
		return softMapper.deleteByPrimaryKeys(eid);
	}

	@Override
	public Softwarecopyright selectByPrimaryKey(int id) {
		// TODO Auto-generated method stub
		return softMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateSoft(Softwarecopyright soft) {
		// TODO Auto-generated method stub
		return softMapper.updateByPrimaryKey(soft);
	}

	@Override
	public int insertSoft(Softwarecopyright soft) {
		// TODO Auto-generated method stub
		return softMapper.insert(soft);
	}

	@Override
	public int countApplycopyright(String firstDay, String endDay) {
		// TODO Auto-generated method stub
		return softMapper.countApplycopyright(firstDay, endDay);
	}

	@Override
	public int countAuthorizationcopyright(String firstDay, String endDay) {
		// TODO Auto-generated method stub
		return softMapper.countAuthorizationcopyright(firstDay, endDay);
	}

}
