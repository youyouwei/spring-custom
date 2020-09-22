package com.demo.interviewdemo.thread;

import lombok.Data;
import org.springframework.core.NamedInheritableThreadLocal;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Description:  ThreadLocal 作为一个多线程共享变量可以避免变量值被不同线程间覆盖，可以作为一个当前线程处理的变量
 *
 * ThreadLocal只能在每个线程内进行重新赋值才能取值线程间不相互影响，其原理就是在每个线程中传入一个新的对象引用放入当前ThreadLocalMap中 key值为共享的ThreadLocal Value为传入的对象引用
 *
 * @Author: jiahuiyang
 * @Date: Created in 12:11 2020/4/21
 */
public class ThreadLocalDemo {

    public static void main(String[] args) throws InterruptedException {
//        method();
//        method1();
        method2();
    }

    public static void method() throws InterruptedException {
        System.out.println("main thread ----");
        System.out.println(ThreadId.get());
        System.out.println(ThreadId.get());

        new Thread(()->{
            System.out.println("thread1-------");
            System.out.println(ThreadId.get());
            System.out.println(ThreadId.get());
        }).start();

        TimeUnit.SECONDS.sleep(1);

        System.out.println(ThreadId.get());


    }

    public static void method1() throws InterruptedException {
        Person person = new Person("Jack", 1);
        ThreadPerson.set(person);
        System.out.println(ThreadPerson.get());
        person.setId(2);
        System.out.println(ThreadPerson.get());

        new Thread(()->{
            System.out.println(ThreadPerson.get());
            Person person1 = new Person("Tom", 3
            );
            ThreadPerson.set(person1);
            System.out.println(ThreadPerson.get());

        }).start();

        TimeUnit.SECONDS.sleep(1);
        System.out.println(ThreadPerson.get());
    }

    /**
     *
     */
    public static void method2() throws InterruptedException {
        //ThreadLocal不能由主线程自动继承到在当前主线程中创建的线程中
        ThreadLocal<String> threadLocal = new ThreadLocal();
        threadLocal.set("ThreadLocal");
        System.out.println(threadLocal.get());
        new Thread(()->{
            System.out.println(threadLocal.get());
        }).start();


        TimeUnit.SECONDS.sleep(1);

        ThreadLocal<String> threadLocal1 = new InheritableThreadLocal();
        threadLocal1.set("InheritableThreadLocal");
        System.out.println(threadLocal1.get());
        new Thread(() -> {
            System.out.println(threadLocal1.get());
        }).start();




    }


    static class ThreadId {
        static final AtomicLong nextId = new AtomicLong(0);

        static final ThreadLocal<Long> THREAD_LOCAL = ThreadLocal.withInitial(() -> nextId.getAndIncrement());

        static long get() {
            return THREAD_LOCAL.get();
        }

    }

    static class ThreadPerson {
        static final ThreadLocal<Person> THREAD_LOCAL = new NamedInheritableThreadLocal<>("ThreadPerson");

        public static Person get() {
            return THREAD_LOCAL.get();
        }

        public static void set(Person person) {
            THREAD_LOCAL.set(person);
        }

    }

    @Data
    static class Person {
        private String name;
        private Integer id;

        public Person(String name, Integer id) {
            this.name = name;
            this.id = id;
        }
    }

}

