package com.feiyang.servlet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-04-11 15:29
 **/
public class MyServlet extends HttpServlet implements ServletContextListener {

    private static final Log logger = LogFactory.getLog(MyServlet.class);

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //用于在容器关闭时,操作
        System.out.println("--------------关闭容器-------------");
    }

    //用于在容器开启时,操作
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String rootpath = sce.getServletContext().getRealPath("/");
        System.out.println("-------------rootPath:"+rootpath);
        if (rootpath != null) {
            rootpath = rootpath.replaceAll("\\\\", "/");
        } else {
            rootpath = "/";
        }
        if (!rootpath.endsWith("/")) {
            rootpath = rootpath + "/";
        }
        //Constant.ROOTPATH = rootpath;
        logger.info("Application Run Path:" + rootpath);
        String urlrewrtie = sce.getServletContext().getInitParameter("urlrewrite");
        boolean burlrewrtie = false;
        if (urlrewrtie != null) {
            burlrewrtie = Boolean.parseBoolean(urlrewrtie);
        }
        //Constant.USE_URL_REWRITE = burlrewrtie;
        logger.info("Use Urlrewrite:" + burlrewrtie);
    }


}
