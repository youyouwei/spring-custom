package com.feiyang.interviewdemo.jvmIssueDemo;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

/**
 * @description: 获取系统内存信息
 * @author: jhyang
 * @create: 2019-07-04 14:06
 **/
public class SystemMemoryDemo {
    public static void main(String[] args) {
        //Runtime.getRuntime() 获取运行时系统的一些属性
        System.out.println(Runtime.getRuntime().availableProcessors());

        System.out.println(Runtime.getRuntime().maxMemory()/(1024.0*1024*1024)); //初始单位是B，所以除1024 2次返回的是 M

        MemoryMXBean m = ManagementFactory.getMemoryMXBean();


    }

}
