package com.feiyang.servlet;

import com.feiyang.interviewdemo.springcontext.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import java.util.Date;

/**
 * @description: web.xml中servlet处理所有请求
 * 自定义servlet 和 spring 容器框架结合使用
 * @author: jhyang
 * @create: 2019-04-02 11:45
 **/
public class MyDispatcherServlet extends HttpServlet implements ServletContextListener {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException {

        //使用 spring 容器加载类



        System.out.println("--------自定义servlet加载-----------");
        User user = null;
        try {
            //ServletContext servletContext = request.getSession().getServletContext();
            //ApplicationContext context;
            //自定义servlet context 获取失败
            //context = WebApplicationContextUtils.getWebApplicationContext(servletContext);

            //使用spring 容器
            ApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");


            user = (User) context.getBean("user");

            System.out.println(user);

        } catch (Exception e) {
            e.printStackTrace();
        }



        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>my first servlet.</title>");
        out.println("<body>");
        out.println(new Date());
        out.println("<br>");
        out.println("Welcome to my first Servlet");
        out.println("<br>");
        out.println("我是一个可以接收任意http请求的简单servlet");
        out.println("<br>");
        out.println(user.toString());
        out.println("</body>");
        out.println("</html>");
        out.flush();
        out.close();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * 容器初始化
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("--------------容器初始化----------------");
    }

    /**
     * 销毁容器
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("--------------容器销毁---------------");
    }

}
