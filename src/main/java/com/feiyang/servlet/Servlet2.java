package com.feiyang.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-04-12 10:34
 **/
@WebServlet(name = "servlet2", urlPatterns = "/server2")
public class Servlet2 extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        doPost(request, response);
    }


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        System.out.println("-----servlet2请求链---------");

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html>");
        stringBuilder.append("<head>");
        stringBuilder.append("<title>");
        stringBuilder.append("my second servlet</title>");
        stringBuilder.append("</head>");
        stringBuilder.append("<body>");
        stringBuilder.append("welcome to my second servlet </body>");
        stringBuilder.append("</html>");

        out.println(stringBuilder);
        out.flush();
        out.close();



    }

}
