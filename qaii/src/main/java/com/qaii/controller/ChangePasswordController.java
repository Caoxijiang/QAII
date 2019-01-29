package com.qaii.controller;
import com.qaii.domain.User;
import com.qaii.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * Created by kunpeng on 2019/1/14 13:46
 **/

@Controller
public class ChangePasswordController{
    @Resource
    private UserService userServivce;

    @RequestMapping(value = "changePwd.do", method = RequestMethod.POST)
    public String ChangePassword(HttpServletRequest request) {
        HttpSession session=request.getSession();
        Object name=session.getAttribute("name");
        System.out.println(session.getAttribute("name"));
        //获取用户输入信息
        String username=request.getParameter("Username");
        String oldpassword = request.getParameter("Password");
        String newpassword=request.getParameter("Confirm_Password");
        //获取输出流这里的前台已经判定过了后台就不用再判定了
       /* if(oldpassword.equals(newpassword)){
            System.out.println("密码相同提示");
        }*/
        User user=new User();
        user.setAdminAccount(username);
        user.setAdminPwd(oldpassword);
        int totalRows=userServivce.findWithLogin(user);
        if (totalRows>0){
            User user1=new User();
            user1.setAdminAccount(username);
            user1.setAdminPwd(newpassword);
            int count=userServivce.updatePassword(user1);
            if (count>0){
                //到时候这里是需要根据前台页面结果做调整的
                return "page/changePwdSuccess";
            }else{
                //到时候这里是需要根据前台页面结果做调整的
                return "page/changePwdError";
            }
        }else{
            //到时候这里是需要根据前台页面结果做调整的
            return "page/NoChangePwdUser";
        }

    }
}
