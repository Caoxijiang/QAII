package com.qaii.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qaii.domain.IncubatorFile;

public interface IncubatorFileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(List<IncubatorFile>iFile);

    int insertSelective(IncubatorFile record);

    List<IncubatorFile> selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IncubatorFile record);

    int updateByPrimaryKey(IncubatorFile record);
}