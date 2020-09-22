package com.demo.interviewdemo.event.javaEvent;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 15:54 2019/10/22
 */
public class FrontDoorListener implements IDoorListener {
    @Override
    public void dealDoorEvent(DoorEvent doorEvent) {
        if (doorEvent.getDoorState() != null && doorEvent.getDoorState().getCode().equals(DoorStateEnum.OPEN.getCode())) {

            System.out.println("前门打开");

        } else {

            System.out.println("前门关闭");

        }
    }
}
