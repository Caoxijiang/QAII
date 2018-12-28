package com.qaii.service.impl;

import com.qaii.dao.MeetingThesisAuthorMapper;
import com.qaii.domain.MeetingThesisAuthor;
import com.qaii.service.MeetingThesisAuthorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Company: 青岛智能产业技术研究院
 * @author: wangxin
 * @Descrpiton:
 * @Time 2018-12-27 9:15
 */
@Service()
public class MeetingThesisAuthorServiceImpl implements MeetingThesisAuthorService {

    @Resource
    private MeetingThesisAuthorMapper mapper;

    @Override
    public List<MeetingThesisAuthor> listAuthor() {
        return mapper.listRecord();
    }

    @Override
    public int inset(MeetingThesisAuthor Record) {
        return mapper.insert(Record);
    }

    @Override
    public int delete(Integer[] id) {
        return mapper.deleteByPrimaryKeys(id);
    }

    @Override
    public int update(MeetingThesisAuthor Record) {
        return mapper.updateByPrimaryKeySelective(Record);
    }

    @Override
    public MeetingThesisAuthor getRecord(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }
}
