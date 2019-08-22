package com.feiyang.interviewdemo.multiThreadDemo;

import com.feiyang.interviewdemo.multiThreadDemo.mysqlTransation.TransactionDemo;

import java.sql.SQLException;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-04-24 16:18
 **/
public class MultiThreadDemo {

    public static void main(String[] args) throws SQLException {
        TransactionDemo.oper();

    }

}
