package com.feiyang.interviewdemo.enumDemo;

import com.alibaba.fastjson.JSON;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 17:41 2019/10/18
 */
public class EnumDemo {

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(PersonEnum.values()));

    }


}
