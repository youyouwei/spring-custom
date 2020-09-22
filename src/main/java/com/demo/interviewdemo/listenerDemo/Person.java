package com.demo.interviewdemo.listenerDemo;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-08-12 16:23
 **/
public class Person {
    private PersonListener personListener;

    public void eat() {
        personListener.doEat(new Event(this));
    }

    public void sleep() {
        personListener.doSleep(new Event(this));
    }

    public void registerLister(PersonListener personListener) {
        this.personListener = personListener;
    }
}
