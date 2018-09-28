package com.qaii.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaii.dao.TrademarkImgMapper;
import com.qaii.domain.TrademarkImg;
import com.qaii.service.TrademarkImgService;

@Service
public class TrademarkImgServiceImpl implements TrademarkImgService {

	@Resource
	private TrademarkImgMapper tradeimg;
	
	@Override
	public int insertmsg(TrademarkImg trade) {
		// TODO Auto-generated method stub
		return tradeimg.insert(trade);
	}

}
