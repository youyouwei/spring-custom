package com.demo.interviewdemo.event.javaEvent;

import java.util.EventObject;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 15:40 2019/10/22
 */
public class DoorEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public DoorEvent(Object source) {
        super(source);
    }

    private DoorStateEnum doorState = DoorStateEnum.CLOSE;


    public DoorStateEnum getDoorState() {
        return doorState;
    }

    public void setDoorState(DoorStateEnum doorState) {
        this.doorState = doorState;
    }
}
