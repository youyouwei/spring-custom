package com.feiyang.interviewdemo.reflectDemo;

import com.feiyang.interviewdemo.multiThreadDemo.SubThread;

import javax.print.attribute.standard.PrinterURI;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @description: 静态对象反射调用
 * @author: jhyang
 * @create: 2019-07-04 17:42
 **/
public class StaticReflectDemo {

    private String id = "1";
    protected String name = "2";
    String addr = "3";
    static public String god = "4";

    private StaticReflectDemo() {

    }

    public StaticReflectDemo(String name) {

    }

    public StaticReflectDemo(String name, String id) {

    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        //Class threadClazz = Class.forName("java.lang.Math");
        //Method method = threadClazz.getMethod("abs", long.class);
        //System.out.println(method.invoke(null, -10000L)); //静态方法不需要 使用对象来调用静态方法，所以使用null

        Class clazz = Class.forName("com.feiyang.interviewdemo.reflectDemo.StaticReflectDemo");

        //使用newInstance() 要求class对象对应的类默认的空构造器
        StaticReflectDemo staticReflectDemo = (StaticReflectDemo) clazz.newInstance();


        System.out.println(staticReflectDemo.addr);




        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.toString());
            //System.out.println(field.get(null));
        }

        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor.toString());
            constructor.setAccessible(true);
        }

        Constructor constructor = clazz.getDeclaredConstructor(String.class, String.class);
        StaticReflectDemo staticReflectDemo1 = (StaticReflectDemo) constructor.newInstance();


        System.out.println(staticReflectDemo1.name);






    }
}
