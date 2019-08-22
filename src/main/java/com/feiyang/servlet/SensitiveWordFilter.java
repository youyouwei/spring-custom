package com.feiyang.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-04-28 11:46
 **/
public class SensitiveWordFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        System.out.println("init SensitiveWordFilter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        //转换成实例的请求和相应对象
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        //获取评论并且屏蔽关键字
        String comment = req.getParameter("comment");
        comment = comment.replace("A", "**");
        //重新设置参数
        req.setAttribute("comment", comment);
        //继续执行
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("destroy SensitiveWordFilter");

    }
}
