package com.qaii.service;

import com.qaii.dao.IncubatorRecordMapper;
import com.qaii.domain.IncubatorRecord;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


public interface IncubatorRecordService {
    int insert(List<IncubatorRecord> record);
    int updateByPrimaryKey(List<IncubatorRecord> record);
    List<IncubatorRecord> selectByPrimaryKey(Integer id);
    int updataTime(IncubatorRecord incubatorRecord);
}
