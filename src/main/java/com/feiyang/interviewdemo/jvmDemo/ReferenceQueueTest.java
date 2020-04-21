package com.feiyang.interviewdemo.jvmDemo;

import com.sun.org.apache.regexp.internal.RE;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 22:12 2020/3/19
 */
public class ReferenceQueueTest {
    private static ReferenceQueue<byte[]> rq = new ReferenceQueue<>();
    private static int _1M = 1024 * 1024;

    public static void main(String[] args) throws InterruptedException {
        Object value = new Object();
        Map<Object, Object> map = new HashMap<>();
        Thread thread = new Thread(()->{
            try {
                int count = 0;
                WeakReference<byte[]> weakReference;
                while ((weakReference = (WeakReference) rq.remove()) != null) {
                    System.out.println(count++ + "回收了" + weakReference);
                }
            } catch (InterruptedException e) {

            }
        });

        //守护线程一直执行到主线程中断
        thread.setDaemon(true);

        TimeUnit.SECONDS.sleep(1);
        TimeUnit.SECONDS.toDays(1000);



        thread.start();
        for (int i = 0; i < 10000; i++) {
            byte[] bytes = new byte[_1M];

            WeakReference<byte[]> weakReference = new WeakReference<>(bytes, rq);
            map.put(weakReference, value);
        }

        System.out.println("map.size()->" + map.size());
    }


}
