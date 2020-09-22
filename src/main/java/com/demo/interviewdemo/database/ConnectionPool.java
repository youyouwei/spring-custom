package com.demo.interviewdemo.database;

import com.mysql.cj.jdbc.MysqlPooledConnection;

import javax.sql.PooledConnection;
import java.sql.*;
import java.util.Vector;

/**
 * @description: 数据库连接池
 * @author: jhyang
 * @create: 2019-04-03 20:12
 **/
public class ConnectionPool {
    private String jdbcDriver = "";
    private String url = "";
    private String userName = "";
    private String passWord = "";
    private String testTable = "";

    private int initialConnections = 10;  //连接池的初始大小
    private int incrementalConnections = 5;  //连接池自动增加大小
    private int maxConnections = 50;         //连接池最大值
    private Vector connections = null;       //存放连接池的向量，线程安全

    public ConnectionPool(String jdbcDriver, String url, String userName, String passWord) {
        this.jdbcDriver = jdbcDriver;
        this.url = url;
        this.userName = userName;
        this.passWord = passWord;
    }

    public int getInitialConnections() {
        return this.initialConnections;
    }

    public void setInitialConnections(int initialConnections) {
        this.initialConnections = initialConnections;
    }

    public int getIncrementalConnections() {
        return this.incrementalConnections;
    }

    public void setIncrementalConnections(int incrementalConnections) {
        this.incrementalConnections = incrementalConnections;
    }

    public int getMaxConnections() {
        return this.maxConnections;
    }

    public void setMaxConnections(int maxConnections) {
        this.maxConnections = maxConnections;
    }

    public String getTestTable() {
        return testTable;
    }

    public void setTestTable(String testTable) {
        this.testTable = testTable;
    }

    public synchronized void createPool() throws Exception {
        if (connections != null) {
            return;
        }

        Driver driver = (Driver) (Class.forName(this.jdbcDriver).newInstance());
        DriverManager.registerDriver(driver);
        connections = new Vector();
        //创建连接池

    }

    private void createConnections(int numConnections) throws SQLException {
        for (int i = 0; i < numConnections; i++) {
            if (this.maxConnections > 0 && this.connections.size() >= this.maxConnections) {
                break;
            }

            try {

                connections.addElement(newConnection());
            } catch (Exception e) {
                System.out.println("创建数据库连接失败！");
                e.printStackTrace();
            }

        }
    }

    private Connection newConnection() throws  SQLException {
        Connection connection = DriverManager.getConnection(url, userName, passWord);
        if (connections.size() == 0) {
            DatabaseMetaData metaData = connection.getMetaData();
            int driverMaxConnections = metaData.getMaxConnections();

            if (driverMaxConnections > 0 && this.maxConnections > driverMaxConnections) {
                this.maxConnections = driverMaxConnections;
            }
        }
        return connection;
    }


}
