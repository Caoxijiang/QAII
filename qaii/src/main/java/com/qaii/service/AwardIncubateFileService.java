package com.qaii.service;

import com.qaii.domain.AwardIncubateFile;

public interface AwardIncubateFileService {

    int insertRecord(AwardIncubateFile record);

    int deleteByPrimaryKeys(Integer[] id);

    int updateByPrimaryKey(AwardIncubateFile record);
}
