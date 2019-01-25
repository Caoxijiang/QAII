package com.qaii.service;

import com.qaii.domain.IndustryAttendMeetingFiles;
import com.qaii.domain.IndustryExchangeTalksFiles;

public interface IndustryExchangeTalksFilesService {

    int deleteByPrimaryKey(Integer[] id);

    int insert(IndustryExchangeTalksFiles record);

    int insertSelective(IndustryExchangeTalksFiles record);

    IndustryExchangeTalksFiles selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IndustryExchangeTalksFiles record);

    int updateByPrimaryKey(IndustryExchangeTalksFiles record);

    IndustryExchangeTalksFiles selectFilePathByexchangetalksId(Integer[] id);
}
