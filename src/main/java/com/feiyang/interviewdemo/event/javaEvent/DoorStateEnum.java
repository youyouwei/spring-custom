package com.feiyang.interviewdemo.event.javaEvent;

import com.feiyang.common.KeyValueEnum;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 15:41 2019/10/22
 */
public enum DoorStateEnum implements KeyValueEnum {

    OPEN(1, "open"),
    CLOSE(0, "close");

    private DoorStateEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    private Integer code;
    private String desc;


    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getDesc() {
        return desc;
    }
}
