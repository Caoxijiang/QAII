package com.qaii.service.impl;

import com.qaii.dao.IndustryAttendMeetingMapper;
import com.qaii.domain.IndustryAttendMeeting;
import com.qaii.service.IndustryAttendMeetingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("industryAttendMeetingService")
public class IndustryAttendMeetingServiceImpl implements IndustryAttendMeetingService {
    @Resource
    private IndustryAttendMeetingMapper industryAttendMeetingMapper;

    @Override
    public int deleteByPrimaryKey(Integer[] id) {
        return industryAttendMeetingMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(IndustryAttendMeeting record) {
        return industryAttendMeetingMapper.insert(record);
    }

    @Override
    public int insertSelective(IndustryAttendMeeting record) {
        return industryAttendMeetingMapper.insertSelective(record);
    }

    @Override
    public IndustryAttendMeeting selectByPrimaryKey(Integer id) {
        return industryAttendMeetingMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(IndustryAttendMeeting record) {
        return industryAttendMeetingMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(IndustryAttendMeeting record) {
        return industryAttendMeetingMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<IndustryAttendMeeting> listRecords() {
        return industryAttendMeetingMapper.listRecords();
    }

    @Override
    public IndustryAttendMeeting getRecords(Integer id) {
        return industryAttendMeetingMapper.getRecords(id);
    }
}
