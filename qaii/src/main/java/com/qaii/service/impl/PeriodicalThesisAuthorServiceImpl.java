package com.qaii.service.impl;

import com.qaii.dao.PeriodicalThesisAuthorMapper;
import com.qaii.domain.PeriodicalThesisAuthor;
import com.qaii.service.PeriodicalThesisAuthorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Company: 青岛智能产业技术研究院
 * @author: wangxin
 * @Descrpiton: 期刊论文作者服务层实现类
 * @Time 2018-12-27 9:00
 */
@Service()
public class PeriodicalThesisAuthorServiceImpl implements PeriodicalThesisAuthorService {

    @Resource
    private PeriodicalThesisAuthorMapper mapper;

    @Override
    public List<PeriodicalThesisAuthor> listRecord() {
        return mapper.listRecord();
    }

    @Override
    public int inset(PeriodicalThesisAuthor Record) {
        return mapper.insert(Record);
    }

    @Override
    public int delete(Integer[] id) {
        return mapper.deleteByPrimaryKeys(id);
    }

    @Override
    public int update(PeriodicalThesisAuthor Record) {
        return mapper.updateByPrimaryKeySelective(Record);
    }

    @Override
    public PeriodicalThesisAuthor getRecord(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }
}
