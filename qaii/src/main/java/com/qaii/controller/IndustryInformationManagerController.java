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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
    public Layui SelectComPanyInfo() throws ParseException {
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        List<CompanyInfo> list1=new ArrayList<>();
        List<CompanyInfo>Incubatorlist =new ArrayList<>();
        //内连接查询企业和股东表，将股东表的id，所属企业ID均封装起来然后传到前台不同的事件对应
        //不同的操作
             Incubatorlist=incubatorService.selectAlllistByPreThreeMonth();
             Date date1=CountDatetoNowDays.Monthlow(sdf.format(date));
             String sd=sdf.format(date1);
             System.out.println(sd);
        //这里是把内连接查询出来的数据进行判断，如果股东出资时间在当前时间以前三个月以后的数据则保留，不是则删除
             for (CompanyInfo companyInfo:Incubatorlist){
                 if (companyInfo.getContributionTime().after(CountDatetoNowDays.Monthlow(sdf.format(date)))){
                     list1.add(companyInfo);
                 }else{
                     System.out.println("there is a system wrong!because The ContibuteTime is above Three month");
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
    //这里是点击已处理按钮改变数据库股东表状态
    @RequestMapping("Imby.do")
    public ModelAndView updateShareholderStatus(@RequestParam Integer id){
        int i=stockEquityService.updateShareholderStatus(id);
        if (i>0){
            System.out.println("更新成功");

        }else{
            System.out.println("更新失败");
        }
        return new ModelAndView("page/industry/indnews");
    }

}
