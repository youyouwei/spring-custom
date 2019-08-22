package com.feiyang.interviewdemo.constantPoolDemo;

/**
 * @description:
 * 同String pool 类似的，Java中存在整数（Integer 对象，而非基本类型）pool。
 * 在Java中1字节大小以内的Integer（0-127）都是存在一个常量池中的，不包含new Integer(xx)初始化），所以他们的引用也是相同的。
 * @author: jhyang
 * @create: 2019-07-19 15:07
 **/
public class IntegerConstantPoolDemo {
    public static void main(String[] args) {
        Integer integer1, integer2;
        boolean result = true;
        for (int i = 0; i < 200; i++) {
            integer1 = i;
            integer2 = i;
            integer2 = new Integer(i); //从构造函数初始化
            if (integer1 != integer2 && result) {
                System.out.println("############################################");
                result = false;
            }
            System.out.println(i + ": " + (integer1 == integer2));
        }
    }

}
