package com.feiyang.interviewdemo.cloneDemo;

import java.util.Date;

/**
 * @description: 使用clone()方法克隆一个对象的步骤
 * 1.被克隆的类要实现Cloneable接口
 * 2.被克隆的类要重写clone()方法
 * @author: jhyang
 * @create: 2019-08-12 10:43
 **/
public class Obj implements Cloneable {
    private Date birth = new Date();

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    /**
     * 判断克隆对象是否影响原对象
     */
    public void changeDate() {
        this.birth.setMonth(4);
    }

    /**
     * 重写Object 基类中的clone方法
     * @return
     */
    @Override
    public Object clone() {
        Obj o = null;
        try {
            //克隆类 先复制clone()
            o = (Obj) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        //实现深克隆  克隆类中引用成员也要使用clone 完成深克隆 否则只是克隆引用
        o.birth = (Date) this.getBirth().clone();
        return o;
    }

}
