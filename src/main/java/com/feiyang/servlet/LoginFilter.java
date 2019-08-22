package com.feiyang.servlet;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-04-28 11:20
 **/
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init LoginFilter");

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //把 ServletRequest 和 ServletResponse转换成真正的类型
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        //由于web.xml中设置Filter过滤全部请求，可以排除不需要过滤的url
        String requestURI = req.getRequestURI();
        if (requestURI.endsWith("login.jsp")) {
            chain.doFilter(request, response);
            return;
        }

        //如果是非登陆页面，判断用户是否登陆，进行页面的处理
        if (null == session.getAttribute("user")) {
            //为登陆用户，重定向到登陆页面
            ((HttpServletResponse) response).sendRedirect("login.jsp");
            return;
        } else {
            //已登录，允许访问
            chain.doFilter(request, response);
        }

    }

    @Override
    public void destroy() {
        System.out.println("destroy LoginFilter");

    }
}
