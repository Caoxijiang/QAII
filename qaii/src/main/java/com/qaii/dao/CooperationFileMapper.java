package com.qaii.dao;

import com.qaii.domain.CooperationFile;

public interface CooperationFileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CooperationFile record);

    int insertSelective(CooperationFile record);

    CooperationFile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CooperationFile record);

    int updateByPrimaryKey(CooperationFile record);
}