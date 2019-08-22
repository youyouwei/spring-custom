package com.feiyang.common;

import java.awt.image.VolatileImage;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-04-02 10:25
 **/
public class Test {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InterruptedException {

        /*Map<String, String> map = new HashMap<>();
        map.put("sss", "ddd");
        String key = "sss";

        if (map.containsKey(key)) {
            System.out.println(map.get(key));
        } else {
            System.out.println("map不存在该值");
        }

        Context context = new Context();
        System.out.println(context.getClass().getName());
        System.out.println(Context.class.getName());

        Class t =Context.class;
        System.out.println(t.newInstance());*/

        //testVolatile();

        testAtomic();

    }

    public static void testVolatile() throws InterruptedException {
        RunThread thread = new RunThread();
        thread.start();
        Thread.sleep(1000);
        //isRunning已经设置为false，但是线程并未读到，循环并未中止；因为isRunning变量虽然被修改但是没有被写到主存中
        thread.setRunning(false);
        System.out.println("已经赋值为false");
    }

    public static void testAtomic() {
        AtomicThread[] atomicThreads = new AtomicThread[100];
        for (int i = 0; i < 100; i++) {
            atomicThreads[i] = new AtomicThread();
        }

        for (int i = 0; i < 100; i++) {
            atomicThreads[i].start();
        }
    }

}

class RunThread extends Thread {
    private boolean isRunning = true;
    int m;

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    @Override
    public void run() {
        System.out.println("进入run");
        while (isRunning) {
            int a = 2;
            int b = 3;
            int c = a + b;
            m = c;
            //如果给cpu一定时间，jvm也会尽力去保证内存的可见性，即便这个变量没有加同步关键字
            //System.out.println(m);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(m);
        System.out.println("线程被停止了");
    }
}

/**
 * 判断volatile是否能保证多线程执行的原子性
 * 不能保证原子性
 * 可以使用synchronized lock atomicInteger 等来加锁处理保证原子性
 * 总的来说 volatile 是线程同步的轻量级的实现，synchronized 是线程同步的重量级实现
 */
class AtomicThread extends Thread {
    //volatile public static int count;
    public static int count;

    synchronized private static void addCount() {
        for (int i = 0; i < 100; i++) {
            count = i;
        }
        System.out.println("count=" + count);
    }

    @Override
    public void run() {
        addCount();
    }
}


