package com.qaii.service.impl;
import com.qaii.dao.IndustryAttendMeetingFilesMapper;
import com.qaii.domain.IndustryAttendMeetingFiles;
import com.qaii.service.IndustryAttendMeetingFilesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("industryAttendMeetingFilesService")
public class IndustryAttendMeetingFilesServiceImpl implements IndustryAttendMeetingFilesService {
    @Resource
    private IndustryAttendMeetingFilesMapper industryAttendMeetingFilesMapper;

    @Override
    public int deleteByPrimaryKey(Integer[] id) {
        return industryAttendMeetingFilesMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(IndustryAttendMeetingFiles record) {
        return industryAttendMeetingFilesMapper.insert(record);
    }

    @Override
    public int insertSelective(IndustryAttendMeetingFiles record) {
        return industryAttendMeetingFilesMapper.insertSelective(record);
    }

    @Override
    public IndustryAttendMeetingFiles selectByPrimaryKey(Integer id) {
        return industryAttendMeetingFilesMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(IndustryAttendMeetingFiles record) {
        return industryAttendMeetingFilesMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(IndustryAttendMeetingFiles record) {
        return industryAttendMeetingFilesMapper.updateByPrimaryKey(record);
    }

    @Override
    public IndustryAttendMeetingFiles selectFilePathByattendmeetingId(Integer[] id) {
        return industryAttendMeetingFilesMapper.selectFilePathByattendmeetingId(id);
    }
}
