package com.qaii.service;

import com.qaii.domain.MinistryFile;

public interface MinistryFileService {

    int insertRecord(MinistryFile record);

    int deleteByPrimaryKeys(Integer[] id);

    int updateByPrimaryKey(MinistryFile record);
}
