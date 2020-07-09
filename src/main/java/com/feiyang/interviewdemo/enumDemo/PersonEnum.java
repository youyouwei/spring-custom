package com.feiyang.interviewdemo.enumDemo;

import com.feiyang.interviewdemo.enumDemo.enumMapper.KeyValueEnum;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 17:42 2019/10/18
 */
public enum PersonEnum implements KeyValueEnum<Integer> {

    TEACHER(1,"Teacher"),
    WORKER(2,"Worker");

    private Integer code;

    private String desc;

    PersonEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getDesc() {
        return this.desc;
    }

}
