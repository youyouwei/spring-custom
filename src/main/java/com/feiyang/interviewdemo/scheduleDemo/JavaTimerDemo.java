package com.feiyang.interviewdemo.scheduleDemo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @description: 使用Java 原生 timer
 * @author: jhyang
 * @create: 2019-06-19 15:48
 **/
public class JavaTimerDemo {

    public static void main(String[] args) {
        Timer timer = new Timer();
        //System.out.println(new Date());

        /*timer.schedule(new TimerTask() {
            @Override
            public void run() {

                System.out.println("123123");
                System.out.println(new Date());

            }
        }, 5000, 1000);   //5000是多少时间后执行任务 1000每次间隔周期时间

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("只执行一次");
            }
        }, 5000);   //如果没有执行周期时间 任务就执行一次
*/

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                System.out.println("当前系统时间：" + new Date() + "---任务执行时间：" + new Date(scheduledExecutionTime()));

                System.out.println("123123");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }, 5000, 2000);

        /*timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(new Date());

                System.out.println("123123");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }, 5000, 2000);*/

        //System.out.println(new Date());


       /* //timer.scheduleAtFixedRate(new TimerTask() {
        timer.schedule(new TimerTask() {//分别注释这行和上面这行试一试效果
            int count = 1;

            @Override
            public void run() {
                count++;
                if (count  == 10) {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        System.out.println("延迟5s");
                        e.printStackTrace();
                    }
                }
                SimpleDateFormat sf = new SimpleDateFormat(
                        "yyyy MM dd hh:mm:ss");
                System.out.println("当前时间："
                        + sf.format(System.currentTimeMillis()) + "计划时间："
                        + sf.format(scheduledExecutionTime()));
            }
        }, 1000, 1000);*/



    }



}
