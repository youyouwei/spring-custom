package com.demo.interviewdemo.concurrentDemo.atomic;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 11:26 2021/1/18
 */
public class AtomicCountDemo {

    public static void main(String[] args) {

        System.out.println(new Counter().increase());
        System.out.println(new Counter().increase());
        System.out.println(new CompactCounter().increase());
        System.out.println(new CompactCounter().increase());


    }


    static class Counter {
        private final AtomicLong counter = new AtomicLong();

        public long increase() {
            return counter.incrementAndGet();
        }
    }



    static class CompactCounter{
        private volatile long counter;

        private static final AtomicLongFieldUpdater<CompactCounter> UPDATER = AtomicLongFieldUpdater.newUpdater(CompactCounter.class, "counter");

        public long increase() {
            return UPDATER.incrementAndGet(this);
        }

    }



}