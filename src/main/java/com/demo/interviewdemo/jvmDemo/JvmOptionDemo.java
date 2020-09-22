package com.demo.interviewdemo.jvmDemo;

import com.alibaba.fastjson.JSON;
import com.demo.interviewdemo.springDemo.ConfigDemo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * @Description: jvm 命令参数
 * 大部分命令都是jvm自带命令，其中-Dproperty=value是用户自定义设置的jvm系统变量
 * @Author: jiahuiyang
 * @Date: Created in 15:52 2020/6/3
 */
public class JvmOptionDemo {

    public static void main(String[] args) {
//        System.out.println("name");

        method();
    }

    /**
     * 获取环境变量或则系统变量
     *
     * spring context中通过getEnvironment获取设置参数是 系统环境变量和JVM系统变量双重的
     * System environment property source name: {@value}
     * public static final String SYSTEM_ENVIRONMENT_PROPERTY_SOURCE_NAME = "systemEnvironment";
     *
     * JVM system properties property source name: {@value}
     * public static final String SYSTEM_PROPERTIES_PROPERTY_SOURCE_NAME = "systemProperties";
     */
    public static void method() {

        String key = "name";

        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigDemo.class);
        context.getEnvironment();
        //获取环境变量
        Map map = System.getenv();

        System.out.println(JSON.toJSONString(map));
//        if (map.get(key) != null) {
//            System.out.println(map.get(key));
//        }

        //获取系统变量
        Map map1 = System.getProperties();
        System.out.println(JSON.toJSONString(map1));
//        if (map1.get(key) != null) {
//            System.out.println(map1.get(key));
//        }

    }

    private static String getValue(Map<String,String> map, String key) {
        return map.get(key);
    }




}
