package com.demo.interviewdemo.jvmDemo;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 22:37 2020/2/21
 */
public class OnStackTest {
    public static void main(String[] args) {

        // args 是idea configuration中配置的Program arguments 中的参数
        System.out.println(args[0]);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            alloc();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        System.exit(10000);

    }

    /**
     * 运行jvm 参数
     * jvm 进行优化分析 +DoEscapeAnalysis 把局部变量在栈上分配
     * -server -Xmx10m -Xms10m -XX:+DoEscapeAnalysis -XX:+PrintGC
     * jvm 不进行优化分析 -DoEscapeAnalysis 在堆上分配 导致jvm 频繁进行GC
     * -server -Xmx10m -Xms10m -XX:-DoEscapeAnalysis -XX:+PrintGC
     */
    public static void alloc() {
        byte[] b = new byte[2];
        b[0] = 1;
    }


}
