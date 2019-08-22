package com.feiyang.interviewdemo.dataSourcePoolDemo;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * @description: c3p0连接池管理类
 * @author: jhyang
 * @create: 2019-07-01 11:13
 **/
public class C3P0ConnectionProvider {
    private static final String JDBC_DRIVER = "driverClass";
    private static final String JDBC_URL = "jdbcUrl";

    private static DataSource ds;

    static{
        initDBSource();
    }

    private static final void initDBSource() {
        Properties c3p0Pro = new Properties();
        try {
            String path = C3P0ConnectionProvider.class.getResource("/").getPath();
            String websiteUrl = (path.replace("/build/classes", "").replace("%20", " ").replace("classes/", "") + "c3p0.properties").replaceFirst("/", "");
            FileInputStream in = new FileInputStream(websiteUrl);
            c3p0Pro.load(in);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String driverClass = c3p0Pro.getProperty(JDBC_DRIVER);
        if (driverClass != null) {
            try {
                Class.forName(driverClass);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        Properties jdbcpropes = new Properties();
        Properties c3propes = new Properties();
        for (Object key : c3p0Pro.keySet()) {
            String skey = (String) key;
            if (skey.startsWith("c3p0.")) {
                c3p0Pro.put(skey, c3p0Pro.getProperty(skey));
            } else {
                jdbcpropes.put(skey, c3p0Pro.getProperty(skey));
            }
        }

        //try {
        //    //DataSource unPooled = datasources
        //}

    }
}
