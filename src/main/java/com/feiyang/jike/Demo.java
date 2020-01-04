package com.feiyang.jike;

import com.feiyang.jike.threadConcurrency.VolitileDemo;

import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 10:16 2019/12/10
 */
public class Demo {

    public static void main(String[] args) throws Exception {

//        demo2();

        demo3();



    }

    public static void demo1() {
        VolitileDemo volitileDemo = new VolitileDemo();
//        因为jdk版本大于等于1.5所以不能看到 x= 0 的情况，反之会出现x=0，因为1.5之前没有Happens-Before规则 所有线程B读到v=true的时候，x可能还没执行赋值，或则读到的还是cpu缓存中的内容
        for (int i = 0; i < 100; i++) {

            new Thread(volitileDemo::writer).start();

            new Thread(volitileDemo::reader).start();
            Thread.interrupted();
        }
    }

    public static void demo2() throws InterruptedException {
        VolitileDemo volitileDemo = new VolitileDemo();
        for (int i = 0; i < 100; i++) {
            new Thread(volitileDemo::addOne).start();
        }

        Thread.currentThread().join();

        System.out.println(volitileDemo.i);
    }

    public static void demo3() {

        List<Integer> nums = Arrays.asList(1, 2, 3);

        System.out.println("inner of for===============");

        nums.forEach(u->{
            try {
                if (u == 2) {
                    throw new Exception("sss");
                }
                System.out.println(u);

            } catch (Exception e) {
                System.out.println("sss" + u);
            }

        });

        System.out.println("out of for=================");

        try {
            nums.forEach(u->{
                if (u == 2) {
                    throw new RuntimeException("sss");
                }
                System.out.println(u);
            });

        } catch (Exception e) {
            System.out.println("sss");

        }

    }



}
