package com.feiyang.interviewdemo.ioStreamDemo;

import java.io.Serializable;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-08-12 15:40
 **/
public class Person implements Serializable {
    private static final long serialVersionUID = 1356276356109310776L;

    private int age;
    private String name;
    private String sex;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
