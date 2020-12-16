package com.demo.interviewdemo.designMode;

import java.util.Objects;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: 使用 -verbose:gc jvm参数显示gc日志到控制台
 * 另外jvm参数一般都是带-
 * @author: jhyang
 * @create: 2019-06-28 17:43
 **/
public class ModeDemo {

    /*public static void main(String[] args) throws InterruptedException {

//        System.out.println("gc");
//
//        String[] strings = new String[1];

//        strings = null;
        //手动执行gc()前  由于上面数组对象申请空间较大并且是连续空间，置空后虚拟机先触发进行young gc，然后触发full gc
//        System.gc();

        ExecutorService executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), Runtime.getRuntime().availableProcessors() * 10, 5, TimeUnit.MINUTES, new LinkedBlockingDeque<>(500));

        for (int i = 0; i < 3; i++) {
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " to do something");

                //任务中有子任务
                //线程池中的线程又创建子线程（任务）会有什么影响
                //答：线程池正常关闭时不会等待嵌套中的子任务。线程池关闭时会等待现有的任务执行完成，但是不会接受新任务，因为子任务也是调用线程池是异步，所以主任务不会等待子任务执行完成就返回，会导致正在执行中的子任务执行报错。主要原因是线程关闭时判断现有任务不包括加入的子任务，会导致子任务执行报错。
                executor.execute(()->{
                    System.out.println(Thread.currentThread().getName() + " child task to do something");
                });

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

//        TimeUnit.SECONDS.sleep(2);

        executor.shutdown();

        //停止所有正在执行的任务，并且停止所有等待的任务将等待执行的任务通过List列表返回。
//        executor.shutdownNow();


    }*/


    public static void main(String[] args) {
        method();
    }


    public static void method() {

        // ThreadLocal一般在类属性中使用  这样对应同一个对象的字段设置值并做修改不会影响其他线程的赋值和使用，能达到共享同一对象但是相互不影响的效果。

        //如果在父线程中 定义ThreadLocal要用InheritableThreadLocal 这样子线程才能访问到local中的变量。
        InheritableThreadLocal threadLocal = new InheritableThreadLocal();

        // 父线程 InheritThreadLocal
        Runnable target = ()->{
            threadLocal.set(new AtomicInteger());
            AtomicInteger i = (AtomicInteger) threadLocal.get();
            System.out.println(Thread.currentThread().getName() + (i.incrementAndGet()));
        };
        Thread thread = new Thread(target, "thread");

        Runnable target1 =  ()->{
            threadLocal.set(new AtomicInteger());
            AtomicInteger i = (AtomicInteger) threadLocal.get();
            System.out.println(Thread.currentThread().getName() + "" + (i.incrementAndGet()));
        };
        Thread thread1 = new Thread(target1, "thread1");


        thread1.start();
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());


    }



}
