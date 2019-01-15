/*
package com.qaii.controller;

import com.qaii.domain.*;
import com.qaii.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
*/
/**
 * Created by kunpeng on 2019/1/14 16:38
 *//*

@Controller
public class PwdController {

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
        @Resource
        private UserService userServivce;
        */
/*
         * 千帆计划、高新技术、百千万工程、中小型企业接口
         * *//*


*/
/*//*
/千帆计划查询出所有的公司名称。
    @RequestMapping("SelectQianfan.do")
    @ResponseBody
    public Map<String,Integer> SelectQianfanaLeval(){
        Map<String,Integer> result=new HashMap<>();

        return null;
    }*//*


        //查询高新技术企业接口
        */
/*
         * 服务企业数量接口
         * *//*


        */
/*
         * 孵化企业总数接口
         * *//*

        */
/*
         * 院获奖、孵化企业获奖、个人获奖情况信息接口
         * *//*

        */
/*
         * 孵化企业旋转图接口
         * *//*

        @RequestMapping(value = "changeit.do",method = RequestMethod.POST)
        public void ChangePassword(HttpServletRequest request) {
            //获取用户输入信息
            String username=request.getParameter("Username");
            String oldpassword = request.getParameter("Password");
            String newpassword=request.getParameter("Confirm_Password");
            //获取输出流
            if(oldpassword.equals(newpassword)){
                System.out.println("密码相同提示");
            }
            User user=new User();
            user.setAdminAccount(username);
            user.setAdminPwd(oldpassword);
            int totalRows=userServivce.findWithLogin(user);
            if (totalRows>0){
                User user1=new User();
                user1.setAdminAccount(username);
                user1.setAdminPwd(newpassword);
                userServivce.updatePassword(user1);
            }else{
                System.out.println("查无账号，做进一步处理");
            }

        }

    }
*/
