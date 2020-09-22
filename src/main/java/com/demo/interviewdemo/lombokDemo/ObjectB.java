package com.demo.interviewdemo.lombokDemo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 10:07 2019/9/25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ObjectB extends ObjectA {

    public static void main(String[] args) {

        ObjectB objectB = new ObjectB();
        objectB.setClassId(2);
        objectB.setClassName("ggg");
        System.out.println(objectB);


    }

    private String className;
    private Integer classId;
}
