package com.qaii.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaii.dao.ProcessMapper;
import com.qaii.domain.PatProcess;
import com.qaii.service.ProcessService;
@Service("ProcessMapper")
public class ProcessServiceImpl implements ProcessService {
	@Resource
	private ProcessMapper processMapper;
	
	@Override
	public int addProcessInfo(PatProcess process) {
		// TODO Auto-generated method stub
		return processMapper.addProcessInfo(process);
	}

	@Override
	public List<PatProcess> findProcessList(Integer pid) {
		// TODO Auto-generated method stub
		return processMapper.findProcessList(pid);
	}

}
