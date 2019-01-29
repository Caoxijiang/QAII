package com.qaii.service.impl;

import com.qaii.dao.SigningAgreementFilesMapper;
import com.qaii.domain.SigningAgreementFiles;
import com.qaii.service.SigningAgreementFilesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by kunpeng on 2019/1/21 11:02
 */
@Service("SigningAgreementFilesService")
public class SigningAgreementFilesServiceImpl implements SigningAgreementFilesService {
    @Resource
    private SigningAgreementFilesMapper signingAgreementFilesMapper;
    @Override
    public int deleteByPrimaryKey(Integer[] id) {
        return signingAgreementFilesMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SigningAgreementFiles record) {
        return signingAgreementFilesMapper.insert(record);
    }

    @Override
    public int insertSelective(SigningAgreementFiles record) {
        return signingAgreementFilesMapper.insertSelective(record);
    }

    @Override
    public SigningAgreementFiles selectByPrimaryKey(Integer id) {
        return signingAgreementFilesMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SigningAgreementFiles record) {
        return signingAgreementFilesMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SigningAgreementFiles record) {
        return signingAgreementFilesMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<SigningAgreementFiles> selectFilePathBysigningagreementId(Integer[] id) {
        return signingAgreementFilesMapper.selectFilePathBysigningagreementId(id);
    }
}
