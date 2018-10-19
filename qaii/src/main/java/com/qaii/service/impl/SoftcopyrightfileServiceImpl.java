package com.qaii.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaii.dao.SoftcopyrightfileMapper;
import com.qaii.domain.Softcopyrightfile;
import com.qaii.service.SoftcopyrightfileService;
@Service
public class SoftcopyrightfileServiceImpl implements SoftcopyrightfileService {

	@Resource
	private SoftcopyrightfileMapper mapper;
	
	@Override
	public int insert(Softcopyrightfile record) {
		// TODO Auto-generated method stub
		return mapper.insert(record);
	}

	@Override
	public List<Softcopyrightfile> listBysid(int sid) {
		// TODO Auto-generated method stub
		return mapper.listBysid(sid);
	}

}
