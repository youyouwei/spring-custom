package com.demo.interviewdemo.concurrentDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 21:58 2020/11/7
 */
public class Demo {

    private static final Logger LOGGER = LoggerFactory.getLogger(Demo.class);

    static {
        System.setProperty("Xms", "1024");
        System.setProperty("Xmx", "1024");
    }

    public static void main(String[] args) throws InterruptedException {
        String str = "a,b,c,1,,,,,";

        // status 非0
//        Runtime.getRuntime().exit(1);
        String[] ary = str.split(",");
        System.out.println(ary.length);


        LOGGER.info("log info ...");


        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(Runtime.getRuntime().freeMemory()/1024/1024);
        System.out.println(Runtime.getRuntime().totalMemory()/1024/1024);
        System.out.println(Runtime.getRuntime().maxMemory()/1024/1024);

        TimeUnit.SECONDS.sleep(3);

        String[] strings = new String[10000000];

        strings = null;

        Runtime.getRuntime().gc();

        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(Runtime.getRuntime().freeMemory()/1024/1024);
        System.out.println(Runtime.getRuntime().totalMemory()/1024/1024);
        System.out.println(Runtime.getRuntime().maxMemory()/1024/1024);

        TimeUnit.SECONDS.sleep(3);

        Runtime.getRuntime().addShutdownHook(new Thread(()-> System.out.println("JVM shutdown hook")));


        //输出的所有的环境变量 注意不是JVM变量
        System.getenv().entrySet().forEach(System.out::println);

        System.out.println("=======================MemoryPoolMXBean============================ ");
        List<GarbageCollectorMXBean> gcmList= ManagementFactory.getGarbageCollectorMXBeans();
        for(GarbageCollectorMXBean gcm:gcmList){
            System.out.println("getName "+gcm.getName());
            System.out.println("getMemoryPoolNames "+gcm.getMemoryPoolNames());
        }

        Thread thread = new Thread(() -> {

        });


    }
}
