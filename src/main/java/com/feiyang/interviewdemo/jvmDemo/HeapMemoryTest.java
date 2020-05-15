package com.feiyang.interviewdemo.jvmDemo;

import lombok.Data;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

/**
 * @Description:
 *
 * 设置jvm 堆内存 -Xmx20m -Xms5m
 * @Author: jiahuiyang
 * @Date: Created in 9:31 2020/2/22
 */
public class HeapMemoryTest {
    public static void main(String[] args) {

        method1();

    }

    public static void method() {
        byte[] b = new byte[1 * 1024 * 1024];
        System.out.println("分配了1M空间给数组");

        System.out.print("Xmx=");
        System.out.println(Runtime.getRuntime().maxMemory() / 1024.0 / 1024 + "M");

//        空闲内存
        System.out.print("free mem=");
        System.out.println(Runtime.getRuntime().freeMemory() / 1024.0 / 1024 + "M");

//        总内存 正常是Xms jvm尽可能在最小堆内存大小运行，如果GC后还不能满足，会进行扩容直至Xmx
        System.out.print("total mem=");
        System.out.println(Runtime.getRuntime().totalMemory() / 1024.0 / 1024 + "M");
    }

    /**
     * 使用 org.openjdk.jol 包打印对象占用堆内存大小
     */
    public static void method1() {

        Object obj = new Object();
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());

        User user = new User();
        user.setId(1);
        user.setName("jack");
        System.out.println(ClassLayout.parseInstance(user).toPrintable());
        System.out.println(GraphLayout.parseInstance(user).toPrintable());
        System.out.println(GraphLayout.parseInstance(user).totalSize());

        System.out.println(ClassLayout.parseInstance("string").toPrintable());
        System.out.println(GraphLayout.parseInstance("string").totalSize());

    }

    @Data
    static class User{
        private long id;
        private String name;

    }
}
