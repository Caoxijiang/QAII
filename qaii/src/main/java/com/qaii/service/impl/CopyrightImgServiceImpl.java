package com.qaii.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaii.service.CopyrightImgService;
import com.qaii.dao.CopyrightimgMapper;
import com.qaii.domain.Copyrightimg;

@Service
public class CopyrightImgServiceImpl implements CopyrightImgService {
	
	@Resource
	private CopyrightimgMapper mapper;

	@Override
	public int insert(Copyrightimg record) {
		// TODO Auto-generated method stub
		return mapper.insertReturnId(record);
	}

}
