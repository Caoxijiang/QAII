package com.qaii.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaii.dao.ProcessimgMapper;
import com.qaii.domain.Processimg;
import com.qaii.service.ProcessimgService;
@Service("ProcessimgMapper")
public class ProcessimgServiceImpl implements ProcessimgService{
	@Resource
	private ProcessimgMapper processimgMapper;
	
	@Override
	public int insert(Processimg img) {
		// TODO Auto-generated method stub
		return processimgMapper.insert(img);
	}

	@Override
	public List<Processimg> selectProimgList(Integer sid) {
		// TODO Auto-generated method stub
		return processimgMapper.selectProimgList(sid);
	}

	@Override
	public int deleteByPrimaryKey(Integer[] id) {
		// TODO Auto-generated method stub
		return processimgMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updataProcessInfo(Processimg img) {
		// TODO Auto-generated method stub
		return processimgMapper.updataProcessInfo(img);
	}


}
