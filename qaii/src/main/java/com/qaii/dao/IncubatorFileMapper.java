package com.qaii.dao;

import com.qaii.domain.IncubatorFile;

public interface IncubatorFileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IncubatorFile record);

    int insertSelective(IncubatorFile record);

    IncubatorFile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IncubatorFile record);

    int updateByPrimaryKey(IncubatorFile record);
}