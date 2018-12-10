package com.qaii.controller;

import com.qaii.domain.CompanyInfo;
import com.qaii.domain.Incubator;
import com.qaii.domain.StockEquity;
import com.qaii.service.IncubatorService;
import com.qaii.service.StockEquityService;
import com.qaii.util.CountDatetoNowDays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by kunpeng on 2018/12/7 16:16
 */
@Controller
public class IndustryInformationManagerController {
    @Autowired
    private IncubatorService incubatorService;
    @Autowired
    private StockEquityService stockEquityService;
    @RequestMapping("Ihkp.do")
    @ResponseBody
    public Map<String, List<CompanyInfo>> SelectHighLevel() throws ParseException {
        Map<String,List<CompanyInfo>> result=new HashMap<>();
        //List<?> listall=new ArrayList<>();
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        List<String> list=new ArrayList<>();
        List<CompanyInfo>Incubatorlist =new ArrayList<>();
        list= CountDatetoNowDays.getpremonth(sdf.format(date),3);
        //先从孵化企业表里面把当前时间三个月以来的所有孵化企业信息得到
        for (String finalStr:list){
             String Yearmonth=finalStr.substring(0,7);
             Incubatorlist=incubatorService.selectAlllistByPreThreeMonth(Yearmonth);
             System.out.println(Incubatorlist);
             result.put(Yearmonth,Incubatorlist);
        }

        return result;
    }
}
