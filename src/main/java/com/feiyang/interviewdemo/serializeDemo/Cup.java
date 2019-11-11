package com.feiyang.interviewdemo.serializeDemo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 杯子
 * @Author: jiahuiyang
 * @Date: Created in 11:59 2019/11/11
 */
@Data
public class Cup implements Serializable {
    /**型号*/
    private String type;
    /**用途*/
    private String use;
    /**制造商*/
    private String maker;
}
