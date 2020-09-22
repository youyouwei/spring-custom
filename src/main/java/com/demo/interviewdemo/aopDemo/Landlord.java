package com.demo.interviewdemo.aopDemo;

import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-05-24 11:36
 **/
@Component
public class Landlord {
    public void service() {
        System.out.println("签合同");
        System.out.println("收房租");
    }
}
