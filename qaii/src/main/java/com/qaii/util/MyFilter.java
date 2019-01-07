package com.qaii.util;
/**
 * Created by kunpeng on 2018/12/21 16:33
 */
import sun.java2d.loops.DrawGlyphListAA;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Enumeration;

public class MyFilter implements Filter{

    private FilterConfig filterConfig = null;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;	//request对象
        HttpServletResponse response = (HttpServletResponse) res;//response对象
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragrma", "no-cache");
        response.setDateHeader("Expires", 0);//禁止浏览器缓存
        String referer = request.getHeader("referer");    //链接的来源地址
        System.out.println(referer);
        request.getSession().setAttribute("LocalName",referer);
        if (referer!=null) {//判断访问来源
            chain.doFilter(request, response); //正常显示图片
        } else {
            request.getRequestDispatcher("401.html").forward(request, response);//显示错误图片
        }
    }

    public void destroy(){
        filterConfig = null;
    }
}
