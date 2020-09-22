package com.demo.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-04-12 10:02
 **/
@WebServlet
@WebFilter(filterName = "logfilter", urlPatterns = "/*")
public class LogFilter implements Filter {

    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        ServletContext servletContext = filterConfig.getServletContext();

        long before = System.currentTimeMillis();
        System.out.println("-------------开始过滤------------");
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        System.out.println("filter已经截获到用户的请求地址" + httpServletRequest.getServletPath());
        System.out.println(((HttpServletRequest) request).getRequestURI());

        //开始执行servlet请求链
        chain.doFilter(request, response);
        //servlet请求链执行完成，开始执行filter返回请求
        long after = System.currentTimeMillis();
        System.out.println("---------过滤结束---------");
        System.out.println("请求被定为到" + httpServletRequest.getServletPath() + " 所花时间为" + (after - before));

    }

    @Override
    public void destroy() {
        filterConfig = null;

    }
}
