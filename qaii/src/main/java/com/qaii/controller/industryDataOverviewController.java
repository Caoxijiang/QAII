package com.qaii.controller;

import com.qaii.domain.AwardCollege;
import com.qaii.domain.AwardIncubate;
import com.qaii.domain.AwardPersonal;
import com.qaii.service.*;
import com.qaii.util.CountDatetoNowDays;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class industryDataOverviewController {
    @Resource
    private MinistryService ministryService;
    @Resource
    private IncubatorService incubatorService;
    @Resource
    private AwardCollegeService awardCollegeService;
    @Resource
    private AwardIncubateService awardIncubateService;
    @Resource
    private AwardPersonalService awardPersonalService;
    /*
     * 千人计划、高新技术、百千万工程、中小型企业接口
     * */
    @RequestMapping("HighLevel.do")
    @ResponseBody
    public Map<String, Integer> SelectHighLevel() {
        Map<String, Integer> result = new HashMap<>();
        result.put("QianFan",incubatorService.selectCountNumsByQianFan());
        result.put("GaoxinJishu",incubatorService.selectCountNumsByGaoxin());
        result.put("BaiQIan",incubatorService.selectCountNumsByBaiQIan());
        result.put("ZhongXiaoXing",incubatorService.selectCountNumsByMiddleLittle());
        return result;
    }



    /*
     * 服务企业数量接口
     * */
    @RequestMapping("servercm.do")
    @ResponseBody
    public Map<String, List> ServeEnterprise() {
        Map<String, List> result = new HashMap<>();
        List<Integer> listq=new ArrayList<>();
        List<Integer> liste=new ArrayList<>();
        Date date =new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        List<String> list=new ArrayList<>();
        try {
            list= CountDatetoNowDays.getpreYears(sdf.format(date), 7);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (String str :list){
            String FinnalStr=str.substring(0,4);
            listq.add(ministryService.selectCountNums(FinnalStr));
            //这里只截取出年，按年份进行查询；
            result.put("ServiceYearNums",listq);
            result.put("ServiceYear",list);
        }
        return result;
    }

    /*
     * 孵化企业总数接口
     * */
    @RequestMapping("hatchit.do")
    @ResponseBody
    public Map<String, List> HatchEnterprise() {
        Map<String, List> result = new HashMap<>();
        List<Integer> listcompany=new ArrayList<>();
        //思路同服务企业数量接口;根据成立时间查询
        Date date =new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        List<String> list=new ArrayList<>();
        try {
            list= CountDatetoNowDays.getpreYears(sdf.format(date), 7);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (String str :list){
            String FinnalStr=str.substring(0,4);
            listcompany.add(incubatorService.selectCountNums(FinnalStr));
            result.put("CompanyNums",listcompany);
            result.put("CompanyYear",list);
        }
        return result;
    }
    /*
     * 院获奖、孵化企业获奖、个人获奖情况信息接口
     * */
    @RequestMapping("Award.do")
    @ResponseBody
    public Map<String, List> Awardcollege() {
        Map<String, List> result = new HashMap<>();
        List<AwardCollege> collegelist = awardCollegeService.listRecords();
        List<AwardIncubate> Incubatelist=awardIncubateService.listRecords();
        List<AwardPersonal>personallist=awardPersonalService.listRecords();
        result.put("awardcollege",collegelist);
        result.put("awardincubate",Incubatelist);
        result.put("awardpersonal",personallist);
        return result;
    }
}