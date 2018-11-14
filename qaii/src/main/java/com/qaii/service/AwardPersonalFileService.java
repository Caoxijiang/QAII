package com.qaii.service;

import com.qaii.domain.AwardPersonalFile;

public interface AwardPersonalFileService {

    int insertRecord(AwardPersonalFile record);

    int deleteByPrimaryKeys(Integer[] id);

    int updateByPrimaryKey(AwardPersonalFile record);

}
