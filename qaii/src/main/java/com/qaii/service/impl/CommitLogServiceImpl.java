package com.qaii.service.impl;

import com.qaii.dao.CommitLogMapper;
import com.qaii.domain.CommitLog;
import com.qaii.service.CommitLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class CommitLogServiceImpl implements CommitLogService {

    @Resource
    private CommitLogMapper mapper;

    @Override
    public int insertRecord(CommitLog Record) {
        return mapper.insertSelective(Record);
    }
}
