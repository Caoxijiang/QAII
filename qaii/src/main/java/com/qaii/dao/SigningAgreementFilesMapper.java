package com.qaii.dao;

import com.qaii.domain.SigningAgreementFiles;

public interface SigningAgreementFilesMapper {
    int deleteByPrimaryKey(Integer[] id);

    int insert(SigningAgreementFiles record);

    int insertSelective(SigningAgreementFiles record);

    SigningAgreementFiles selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SigningAgreementFiles record);

    int updateByPrimaryKey(SigningAgreementFiles record);

    SigningAgreementFiles selectFilePathBysigningagreementId(Integer[] id);
}