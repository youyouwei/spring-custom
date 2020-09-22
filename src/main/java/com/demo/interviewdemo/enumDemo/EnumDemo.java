package com.demo.interviewdemo.enumDemo;

import com.alibaba.fastjson.JSON;
import com.demo.interviewdemo.enumDemo.enumMapper.KeyValueEnumMapper;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 17:41 2019/10/18
 */
public class EnumDemo {

    public static void main(String[] args) {
        new EnumDemo().method();
        method1();
    }

    /**
     * 测试enum和code之间转换
     */
    public void method() {
        PersonEnum personEnum = PersonEnum.TEACHER;
        System.out.println(KeyValueEnumMapper.INSTANCE.getCodeAsInt(personEnum));
        Integer code = 2;
        System.out.println(KeyValueEnumMapper.INSTANCE.getKeyValueEnum(PersonEnum.class, code));
    }

    /**
     * 两种获取枚举数组的方式
     */
    public static void method1() {
        PersonEnum[] personEnums = PersonEnum.values();

        System.out.println(JSON.toJSONString(personEnums));

        personEnums = PersonEnum.class.getEnumConstants();

        System.out.println(JSON.toJSONString(personEnums));


    }


}
