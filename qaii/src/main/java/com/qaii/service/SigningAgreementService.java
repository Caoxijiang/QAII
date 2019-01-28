package com.qaii.service;

import com.qaii.domain.SigningAgreement;

import java.util.List;

/**
 * Created by kunpeng on 2019/1/21 9:50
 */
public interface SigningAgreementService {
    int deleteByPrimaryKey(Integer[] id);

    int insert(SigningAgreement record);

    int insertSelective(SigningAgreement record);

    SigningAgreement selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SigningAgreement record);

    int updateByPrimaryKey(SigningAgreement record);

    List<SigningAgreement> listRecords();

    SigningAgreement getRecord(Integer id);
}
