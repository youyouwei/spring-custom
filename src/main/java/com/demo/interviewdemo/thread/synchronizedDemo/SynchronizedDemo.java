package com.demo.interviewdemo.thread.synchronizedDemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-06-24 13:53
 **/
public class SynchronizedDemo {

    private int variable;

    public synchronized void method() {
        System.out.println("synchronized method");
    }

    /**
     * 如果没有 synchronized monitor 并发数据千级别和万级别会出现计算错误（发生同时写操作）
     */
    public synchronized void addVariable() {
        this.variable += 1;
    }

    public int getVariable() {
        return variable;
    }

}
