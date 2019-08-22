package com.feiyang.interviewdemo.listenerDemo;

import javax.servlet.ServletContextListener;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-08-12 16:31
 **/
public class ListenerDemo {
    public static void main(String[] args) throws InterruptedException {

        Thread.sleep(200 * 1000);

        Person person = new Person();
        person.registerLister(new PersonListener() {
            @Override
            public void doEat(Event event) {
                Person person1 = event.getResource();
                System.out.println(person1 + "正在吃饭呢！");
            }

            @Override
            public void doSleep(Event event) {
                Person person1 = event.getResource();
                System.out.println(person1 + "正在睡觉呢！");
            }
        });
        person.eat();



    }
}
