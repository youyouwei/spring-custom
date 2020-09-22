package com.demo.interviewdemo.event.javaEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 15:57 2019/10/22
 */
public class DoorManager {
    private List<IDoorListener> listeners = new ArrayList();

    public void addDoorListener(IDoorListener listener)
    {
        synchronized (this)
        {
            if (listener != null && !(listeners.contains(listener)))
            {
                listeners.add(listener);
            }
        }
    }

    public void removeDoorListener(IDoorListener listener)
    {
        synchronized (this)
        {
            if (listeners.contains(listener))
            {
                listeners.remove(listener);
            }
        }
    }

    public void notifyDoors(DoorEvent event)
    {
        for (IDoorListener iDoorListener : listeners)
        {
            iDoorListener.dealDoorEvent(event);
        }
    }

    /**
     * 模拟开门事件
     */
    public void fireOpend()
    {
        if (listeners == null)
        {
            return;
        }
        DoorEvent event = new DoorEvent(this);
        event.setDoorState(DoorStateEnum.OPEN);

        notifyDoors(event);
    }
}
