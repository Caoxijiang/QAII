package com.qaii.service;

import com.qaii.domain.CooperationFile;

public interface CooperationFileService {

    int insertRecord(CooperationFile record);

    int deleteByPrimaryKeys(Integer[] id);

    int updateByPrimaryKey(CooperationFile record);
}
