package com.qaii.util;

import com.qaii.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*  Created by kunpeng on 2019/1/8 10:41*/



public class SingleUserInterceptor implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)

            throws Exception {
// TODO Auto-generated method stub

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
            throws Exception {
// TODO Auto-generated method stub

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
        String url = request.getRequestURI();

//如果拦截到的是登录的页面的话放行
        if (url.indexOf("indexUI.do") >= 0 || url.indexOf("checkLogin.do")>=0 || url.indexOf("logout.do") >= 0) {
            return true;
        }
//如果是其他请求地址，进行拦截
        User admin = (User) request.getSession().getAttribute("user");
        if (admin != null) {

            String sessionid = MemoryData.getSessionIDMap().get(admin.getAdminAccount());
//如果用户名存在放心（即登录放行）
            String id=request.getSession().getId();
            if (sessionid.equals(request.getSession().getId())) {
                return true;
            } else { //如果请求的sessionID和此账号Map中存放的sessionID不一致，跳转到登陆页

//判断如果是异步请求，设置响应头 sessionstatus为timeout，自动跳转，否则重定向
                if (request.getHeader("x-requested-with") != null
                        && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
                    response.setHeader("sessionstatus", "timeout");
                    return false;
                } else {
                    String indexurl = request.getContextPath() + "/logout.do";
                   /* Request.getRequestDispatcher(url).forward(request,response)*/
                    response.sendRedirect(indexurl);
                    return false;
                }
            }
        }

//如果session中没有admin，跳转到登陆页
        request.getRequestDispatcher(request.getContextPath() + "/index.do").forward(request, response);
        return false;
    }
}
