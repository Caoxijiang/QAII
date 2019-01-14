package com.qaii.controller;

import com.qaii.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by kunpeng on 2019/1/14 13:46
 */
@Controller
public class ChangePasswordController extends HttpServlet {
    @Resource
    private UserService userServivce;
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        super.doGet(httpServletRequest, httpServletResponse);
    }

    @Override
    @RequestMapping("changePwd.do")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户输入信息
        String username=request.getParameter("Username");
        String oldpassword = request.getParameter("Password");
        String newpassword=request.getParameter("Confirm_Password");
        //获取输出流
        PrintWriter out = response.getWriter();
        if(oldpassword.equals(newpassword)){
            out.print("<html>");
            out.print("<head></head>");
            out.print("<body>新密码不可与旧密码一致！</body>");
            out.print("</html>");
        }

    }
}
