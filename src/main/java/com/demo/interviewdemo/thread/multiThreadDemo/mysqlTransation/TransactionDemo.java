package com.demo.interviewdemo.thread.multiThreadDemo.mysqlTransation;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.sql.*;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-04-24 16:19
 **/
@Slf4j
public class TransactionDemo {
    private static String password = "11111";
    private static String username = "root";

    private static String url = "jdbc:mysql://localhost:3306/seckill?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useTimezone=true";
    private static String driver = "com.mysql.cj.jdbc.Driver";
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 数据库原生操作
     * @throws SQLException
     */
    public static void oper() throws SQLException {

        String sql ="select * from t limit 0,1";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)){
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int c = resultSet.getInt("c");
                int d = resultSet.getInt("d");
                BigDecimal e = resultSet.getBigDecimal("e");
                BigDecimal f = resultSet.getBigDecimal("f");

                log.info("id:{},c:{},d:{},e:{},f:{}", id, c, d, e, f);
            }

        }

    }

}
