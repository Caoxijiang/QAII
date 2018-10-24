package com.qaii.dao;

import com.qaii.domain.PeriodicalThesisFile;

public interface PeriodicalThesisFileMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PeriodicalThesisFile record);

    int insertSelective(PeriodicalThesisFile record);

    PeriodicalThesisFile selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PeriodicalThesisFile record);

    int updateByPrimaryKey(PeriodicalThesisFile record);
}