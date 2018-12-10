package com.qaii.controller;

import com.qaii.domain.CompanyInfo;
import com.qaii.domain.Incubator;
import com.qaii.domain.StockEquity;
import com.qaii.service.IncubatorService;
import com.qaii.service.StockEquityService;
import com.qaii.util.CountDatetoNowDays;
import com.qaii.util.Layui;
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
    public Layui SelectHighLevel() throws ParseException {
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        List<CompanyInfo> list1=new ArrayList<>();
        List<CompanyInfo>Incubatorlist =new ArrayList<>();
        //先从孵化企业表里面把当前时间三个月以来的所有孵化企业信息得到
             Incubatorlist=incubatorService.selectAlllistByPreThreeMonth();
             Date date1=CountDatetoNowDays.Monthlow(sdf.format(date));
             String sd=sdf.format(date1);
             System.out.println(sd);
             for (CompanyInfo companyInfo:Incubatorlist){
                 if (companyInfo.getEstablishTime().after(CountDatetoNowDays.Monthlow(sdf.format(date)))){
                     list1.add(companyInfo);
                 }else{
                     System.out.println("there is a system wrong!");
                 }
             }
             System.out.println(list1);

        int count =list1.size();
        if(list1!=null) {
            return Layui.data(count, list1);
        }else {
            return Layui.data(count, list1);
        }
    }
}
