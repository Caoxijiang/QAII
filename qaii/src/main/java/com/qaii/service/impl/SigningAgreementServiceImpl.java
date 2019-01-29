package com.qaii.service.impl;

import com.qaii.dao.SigningAgreementMapper;
import com.qaii.domain.SigningAgreement;
import com.qaii.service.SigningAgreementService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by kunpeng on 2019/1/21 9:51
 */
@Service("SigningAgreementService")
public class SigningAgreementServiceImpl implements SigningAgreementService {
    @Resource
    private SigningAgreementMapper signingAgreementMapper;
    @Override
    public int deleteByPrimaryKey(Integer[] id) {
        return signingAgreementMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SigningAgreement record) {
        return signingAgreementMapper.insert(record);
    }

    @Override
    public int insertSelective(SigningAgreement record) {
        return signingAgreementMapper.insertSelective(record);
    }

    @Override
    public SigningAgreement selectByPrimaryKey(Integer id) {
        return signingAgreementMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SigningAgreement record) {
        return signingAgreementMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SigningAgreement record) {
        return signingAgreementMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<SigningAgreement> listRecords() {
        return signingAgreementMapper.listRecords();
    }

    @Override
    public SigningAgreement getRecord(Integer id) {
        return signingAgreementMapper.getRecord(id);
    }
}
