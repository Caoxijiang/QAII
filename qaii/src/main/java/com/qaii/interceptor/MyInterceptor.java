package com.qaii.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.qaii.domain.User;

public class MyInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//首先进入的方法
//        System.out.println("preHandle");
        //return false表示拦截，不向下执行
         //return true表示放行
        String path=request.getServletPath();
//        System.out.println(request.getServletPath());
//        System.out.println(request.getRequestURI());
        HttpSession session = request.getSession();
        User u=(User)session.getAttribute("user");
        if(u!=null){
            return true;
        }else{
			//response.getWriter().write("强制下线");
        	request.getRequestDispatcher("indexUI.do").forward(request, response);
            return false;
        }
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
