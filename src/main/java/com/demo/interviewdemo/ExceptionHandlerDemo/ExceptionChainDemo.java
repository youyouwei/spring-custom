package com.demo.interviewdemo.ExceptionHandlerDemo;

/**
 * @description: 异常链处理
 * @author: jhyang
 * @create: 2019-08-06 14:08
 **/
public class ExceptionChainDemo {

    public static void main(String[] args) {
        try {
            String str = null;
            System.out.println(str.length());
        } catch (Exception e) {
            //异常链会通过一个cause by来展示上传传入异常
            throw new RuntimeException("main error", e);
        }
    }

}
