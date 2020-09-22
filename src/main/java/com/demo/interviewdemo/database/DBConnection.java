package com.demo.interviewdemo.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:  普通数据库连接 每次请求会创建一个连接
 * @author: jhyang
 * @create: 2019-04-03 19:31
 **/
public class DBConnection {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private String user = "root";
    private String passWord = "root";
    private String driverName = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://mysql.springfans.org/springfans?useSSL=false&characterEncoding=utf-8";

    public DBConnection() {

    }

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("加载数据库驱动失败！");
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(url, user, passWord);
        } catch (SQLException e) {
            System.out.println("创建数据库连接失败！");
            connection = null;
            e.printStackTrace();
        }

        return connection;
    }

    public static void main(String[] args) {

        List<AppUpdateVersion> list = new ArrayList<>();
        Connection con = new DBConnection().getConnection();
        if (con != null) {
            try {
                String sql = "select * from fortune_app_version";
                PreparedStatement preparedStatement = con.prepareStatement(sql);

                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    AppUpdateVersion version = new AppUpdateVersion();
                    version.setId(rs.getInt("id"));
                    version.setVersionId(rs.getString("version_id"));
                    version.setUpdateVersionDate(rs.getDate("update_version_date"));
                    version.setUpdateUrl(rs.getString("update_url"));
                    version.setUpdateType(rs.getString("update_type"));
                    version.setUpdateTime(rs.getDate("update_time"));
                    version.setCreateTime(rs.getDate("create_time"));
                    version.setUpdateContent(rs.getString("update_content"));
                    list.add(version);
                }

                list.forEach(System.out::println);

            } catch (SQLException e) {
                e.printStackTrace();

            } finally {
                try {
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }

    }

}
