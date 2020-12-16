package com.demo.interviewdemo.designMode.event.javaEvent;

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

    public static void main(String[] args) {
        DoorManager doorManager = new DoorManager();
        //声明事件监听者
        doorManager.addDoorListener(new FrontDoorListener());

        //声明事件
        DoorEvent doorEvent = new DoorEvent(new Object());
        //修改事件状态
        doorEvent.setDoorState(DoorStateEnum.OPEN);

        //发布事件 本质就是把事件传递给监听者 监听者通过事件类型或则事件状态选择不同的处理
        for (IDoorListener listener : doorManager.listeners) {
            listener.dealDoorEvent(doorEvent);
        }


        //DoorManager 有封装好的事件处理方法
        doorManager.fireOpend();
    }
}
