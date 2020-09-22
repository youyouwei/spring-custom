package com.demo.interviewdemo.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @description: jdbc事务
 * @author: jhyang
 * @create: 2019-08-08 10:56
 **/
public class JDBCTransactionDemo {

    private static String url = "";
    private static String user = "";
    private static String password = "";

    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection("","","");



    }
}
