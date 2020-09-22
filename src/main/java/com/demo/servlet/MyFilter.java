package com.demo.servlet;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import java.io.IOException;

/**
 * @description:  自定义filter过滤器 过滤请求（在servlet接收请求前）和返回（在servlet返回数据后）的数据
 * @author: jhyang
 * @create: 2019-04-11 13:39
 **/
public class MyFilter extends HttpFilter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("----------filter过滤器-------------");
        chain.doFilter(request,response);

    }

}
