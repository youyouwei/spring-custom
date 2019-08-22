package com.feiyang.interviewdemo.multiThreadDemo;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-06-25 14:27
 **/
public class VolatileFeatureExample {
    volatile long v1 = 0L;

    public void set(long l) {
        v1 = l;
    }

    public void getAndIncrement() {
        v1++;
    }

    public long get() {
        return v1;
    }

}

/**
 * //上面类等价
 */
class VolatileFeaturesExampleEqual {
    long v1 = 0L;

    public synchronized void set(long l) {
        v1 = l;
    }

    public void getAndIncrement() {
        long temp = get();
        temp += 1L;
        set(temp);
    }

    public synchronized long get() {
        return v1;
    }
}
