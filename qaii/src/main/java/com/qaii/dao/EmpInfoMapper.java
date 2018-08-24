package com.qaii.dao;

import java.util.List;
import java.util.Map;

import com.qaii.domain.EmpInfo;

public interface EmpInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EmpInfo record);

    int insertSelective(EmpInfo record);

    EmpInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmpInfo record);

    int updateByPrimaryKey(EmpInfo record);
    List <EmpInfo> findAllEmpInfo();
}