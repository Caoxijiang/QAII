/*
package com.qaii.controller;
import com.qaii.domain.User;
import com.qaii.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


*/
/**
 * Created by kunpeng on 2019/1/14 13:46
 **//*


@Controller
public class ChangePasswordController{
    @Resource
    private UserService userServivce;

    @RequestMapping(value = "changePwd.do", method = RequestMethod.POST)
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
