package com.demo.interviewdemo.reflectDemo.reflectAnnotationDemo;

/**
 * @description: 使用注解
 * @author: jhyang
 * @create: 2019-07-04 20:00
 **/
public class Apple {

    @FruitProvider(id = 1,name = "陕西红富士集团",address = "陕西省西安市延安路")
    private String appleProvide;

    public void setAppleProvide(String appleProvide) {
        this.appleProvide = appleProvide;
    }

    public String getAppleProvide() {
        return appleProvide;
    }

}
