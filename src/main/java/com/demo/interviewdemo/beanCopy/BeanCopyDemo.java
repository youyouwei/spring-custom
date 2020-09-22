package com.demo.interviewdemo.beanCopy;

import org.springframework.beans.BeanUtils;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-07-11 20:59
 **/
public class BeanCopyDemo {

    public static void main(String[] args) {
        Cat cat = new Cat("kitty", "ja");

        Cat cat1 = new Cat();

        BeanUtils.copyProperties(cat, cat1);
        System.out.println(cat1);
        cat1.setName("brooker");

        System.out.println(cat1);

    }

}
