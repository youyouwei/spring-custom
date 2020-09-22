package com.demo.interviewdemo.event.javaEvent;

import java.util.EventListener;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 15:51 2019/10/22
 */
public interface IDoorListener extends EventListener {
    public void dealDoorEvent(DoorEvent doorEvent);
}
