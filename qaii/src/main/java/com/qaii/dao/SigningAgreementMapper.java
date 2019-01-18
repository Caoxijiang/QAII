package com.qaii.dao;

import com.qaii.domain.SigningAgreement;

public interface SigningAgreementMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SigningAgreement record);

    int insertSelective(SigningAgreement record);

    SigningAgreement selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SigningAgreement record);

    int updateByPrimaryKey(SigningAgreement record);
}