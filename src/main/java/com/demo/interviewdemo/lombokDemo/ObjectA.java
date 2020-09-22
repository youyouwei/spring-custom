package com.demo.interviewdemo.lombokDemo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 10:02 2019/9/25
 */
@Data
@EqualsAndHashCode(callSuper = false)

public class ObjectA {

    public static void main(String[] args) {
        ObjectA objectA = new ObjectA();
        objectA.setAddress("sss");
        objectA.setName("ddd");
        objectA.setId(1);


        System.out.println(objectA);
    }



    private String name;
    private String address;
    private Integer id;

}

