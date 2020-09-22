package com.demo.interviewdemo.designMode.prototypeMode;

/**
 * @description: 曲奇饼
 * @author: jhyang
 * @create: 2019-08-12 14:46
 **/
public class Cookie implements Cloneable {

    @Override
    public Object clone() throws CloneNotSupportedException {
        return (Cookie)super.clone();
    }

}
