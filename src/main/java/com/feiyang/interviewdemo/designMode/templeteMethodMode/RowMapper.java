package com.feiyang.interviewdemo.designMode.templeteMethodMode;

import java.sql.ResultSet;

/**
 * @description:
 *
 *
 *
 * 行映射接口，把数据库一行映射为一个对象
 * @author: jhyang
 * @create: 2019-06-28 17:46
 **/
public interface RowMapper<T> {
    T mapRow(ResultSet rs, int rowNum) throws Exception;
}
