package com.demo.interviewdemo.designMode.templeteMethodMode;

import java.sql.ResultSet;
import java.util.List;

/**
 * @description:
 * 模拟Merber的dao层
 * @author: jhyang
 * @create: 2019-06-28 18:12
 * @ModificationHistory  who   when    what
 **/
public class MerberDao {
    //为什么不继承JdbcTemplate ，主要是为了解耦
    //这里没有传直接的数据源，这里可以是mysql或者oracle的数据源都可以
    private JdbcTemplete jdbcTemplete = new JdbcTemplete(null);

    public List<?> query() {
        String sql = "select * from t_member";
        return jdbcTemplete.executeQuery(sql, new RowMapper<Merber>() {
            @Override
            public Merber mapRow(ResultSet rs, int rowNum) throws Exception {
                Merber merber = new Merber();
                merber.setUserName(rs.getString("username"));
                merber.setPassword(rs.getString("password"));
                merber.setNickName(rs.getString("nickname"));
                merber.setAddr(rs.getString("addr"));
                merber.setAge(rs.getInt("age"));
                return merber;
            }
        }, null);
    }
}
