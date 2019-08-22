package com.feiyang.interviewdemo.reflectDemo;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-08-12 15:02
 **/
public class ObjectByReflect {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ObjectByReflect objectByReflect = (ObjectByReflect) Class.forName("com.feiyang.interviewdemo.reflectDemo.ObjectByReflect").newInstance();
        objectByReflect.method();
        Class c = objectByReflect.getClass();

    }

    public void method() {
        System.out.println("Class.forName() 反射获取对象");


    }

}
