package com.demo.interviewdemo.enumDemo.enumMapper;

import java.io.Serializable;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 14:15 2020/7/8
 */
public interface KeyValueEnum<CODE> extends Serializable {
    CODE getCode();

    String getDesc();
}
