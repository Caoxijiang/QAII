package com.qaii.dao;

import com.qaii.domain.PeriodicalThesisAuthor;

import java.util.List;

public interface PeriodicalThesisAuthorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PeriodicalThesisAuthor record);

    int insertSelective(PeriodicalThesisAuthor record);

    PeriodicalThesisAuthor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PeriodicalThesisAuthor record);

    int updateByPrimaryKey(PeriodicalThesisAuthor record);

    List<PeriodicalThesisAuthor> listRecord();

    int deleteByPrimaryKeys(Integer[] id);
}