package com.qaii.service;

import com.qaii.domain.AwardCollegeFile;

public interface AwardCollegeFileService {

    int insertRecord(AwardCollegeFile record);

    int deleteByPrimaryKeys(Integer[] id);

    int updateByPrimaryKey(AwardCollegeFile record);

}
