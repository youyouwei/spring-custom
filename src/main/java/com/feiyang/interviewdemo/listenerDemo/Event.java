package com.feiyang.interviewdemo.listenerDemo;

/**
 * @description:
 * 事件对象Event
 * 事件对象封装了事件源
 * 在监听器上能够通过事件对象获取得到事件源
 *
 * @author: jhyang
 * @create: 2019-08-12 16:24
 **/
public class Event {
    private Person person;

    public Event() {

    }

    public Event(Person person) {
        this.person = person;
    }

    public Person getResource() {
        return person;
    }
}
