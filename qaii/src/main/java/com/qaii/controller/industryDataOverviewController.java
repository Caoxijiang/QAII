package com.qaii.controller;

import com.qaii.domain.AwardCollege;
import com.qaii.domain.AwardIncubate;
import com.qaii.domain.AwardPersonal;
import com.qaii.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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
     * 服务企业数量接口
     * */
    @RequestMapping("servercm.do")
    @ResponseBody
    public Map<String, Integer> ServeEnterprise() {
        Map<String, Integer> result = new HashMap<>();
        //先从产业表里面查出服务时间，并对数据库中的服务时间进行判断重复，
        // 再根据同一服务时间时查询服务公司数量
        List<String> list = ministryService.listministrytime();

        for  ( int i= 0 ; i <  list.size() -1 ; i ++ )  {
            for  ( int j =  list.size()- 1 ; j >i; j -- )  {
                if  (list.get(j).equals(list.get(i)))  {
                    list.remove(j);
                }
            }
        }
        for (String str :list){
            //这里只截取出年，按年份进行查询；
            String FinnalStr=str.substring(0,4);
            result.put(FinnalStr,ministryService.selectCountNums(FinnalStr));
        }
        return result;
    }

    /*
     * 孵化企业总数接口
     * */
    @RequestMapping("hatchit.do")
    @ResponseBody
    public Map<String, Integer> HatchEnterprise() {
        Map<String, Integer> result = new HashMap<>();
        //思路同服务企业数量接口;根据成立时间查询
        List<String> list = incubatorService.selectestablishtime();
        for  ( int i= 0 ; i <  list.size() -1 ; i ++ )  {
            for  ( int j =  list.size()- 1 ; j >i; j -- )  {
                if  (list.get(j).equals(list.get(i)))  {
                    list.remove(j);
                }
            }
        }
        for (String str :list){
            String FinnalStr=str.substring(0,4);
            result.put(FinnalStr,incubatorService.selectCountNums(FinnalStr));
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