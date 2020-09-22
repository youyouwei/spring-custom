package com.demo.interviewdemo.designMode.templeteMethodMode;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * jdbc 的模板类
 * @author: jhyang
 * @create: 2019-06-28 17:49
 **/
public class JdbcTemplete {
    private DataSource dataSource;

    public JdbcTemplete(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private Connection getConnection() throws SQLException {
        return this.dataSource.getConnection();
    }

    private PreparedStatement getPreparedStatement(String sql, Connection connection) throws SQLException {
        return connection.prepareStatement(sql);
    }

    private ResultSet getResultSet(PreparedStatement preparedStatement, Object[] values) throws SQLException {
        int i = 0;
        for (Object value : values) {
            preparedStatement.setObject(i++, value);
        }
        return preparedStatement.getResultSet();
    }

    private List<?> parseResultSet(ResultSet resultSet, RowMapper<?> rowMapper) throws Exception {
        int rowNumber = 1;
        List<Object> list = new ArrayList<>();
        while (resultSet.next()) {
            list.add(rowMapper.mapRow(resultSet, rowNumber++));
        }
        return list;
    }

    private void closeResultSet(ResultSet rs) throws SQLException {
        rs.close();
    }

    private void closePrepareStatement(PreparedStatement statement) throws SQLException {
        statement.close();
    }

    private void closeConnect(Connection connection) throws SQLException {
        connection.close();
    }

    /**
     * 把模板算法中的 RowMapper 接口实现放在子类实现中或则调用类中
     * @param sql
     * @param mapper
     * @param values
     * @return
     */
    public List<?> executeQuery(String sql, RowMapper<?> mapper, Object[] values) {
        try {
            //1、获得数据库连接
            Connection connection = this.getConnection();
            //2、获取语句集
            PreparedStatement pstm = this.getPreparedStatement(sql, connection);
            //3、执行语句集，获得结果集
            ResultSet rs = this.getResultSet(pstm, values);
            //4、解析结果集
            List<?> list = this.parseResultSet(rs, mapper);
            //5、关闭结果集
            this.closeResultSet(rs);
            //6、关闭语句集
            this.closePrepareStatement(pstm);
            //7、关闭连接
            this.closeConnect(connection);
            //返回list结果
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
