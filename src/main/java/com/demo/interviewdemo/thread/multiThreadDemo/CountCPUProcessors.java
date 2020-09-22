package com.demo.interviewdemo.thread.multiThreadDemo;

/**
 * @description: 获取当前设备的CPU个数
 * @author: jhyang
 * @create: 2019-07-01 14:10
 **/
public class CountCPUProcessors {
    public static void main(String[] args) {
        int cpus = Runtime.getRuntime().availableProcessors();
        System.out.println("cup num:" + cpus);
    }
}
