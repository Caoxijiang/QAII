package com.qaii.dao;

import com.qaii.domain.AwardIncubateFile;

public interface AwardIncubateFileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AwardIncubateFile record);

    int insertSelective(AwardIncubateFile record);

    AwardIncubateFile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AwardIncubateFile record);

    int updateByPrimaryKey(AwardIncubateFile record);

    int deleteByParimaryKeys(Integer[] id);
}