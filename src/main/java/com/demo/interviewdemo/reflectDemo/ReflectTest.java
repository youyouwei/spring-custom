package com.demo.interviewdemo.reflectDemo;

import java.lang.reflect.*;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-04-22 13:54
 **/
public class ReflectTest {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, NoSuchFieldException {

        //反射获取public 和调用
        //reflectByPublic();

        //反射获取所有成员包括private
        //reflectByAll();

        /*int i = 1;
        String s = "tom";
        Class clazz = s.getClass();
        System.out.println(clazz.getName());
        clazz.getSuperclass();
        System.out.println(clazz.getSuperclass().getName());
        clazz = Sex.FEMALE.getClass();
        System.out.println(clazz.getName());
        //数组类型也是引用类，并且类型为[B  左中括号加上该类型第一个字母大写,如果是多维数组类型就是多个左中括号 如[[B
        byte[] bytes = new byte[1024];
        clazz = bytes.getClass();
        System.out.println(clazz.getName());
        int[] amount = new int[103];
        System.out.println(amount.getClass().getName());
        System.out.println(amount.getClass().getTypeParameters());
        int[][] names = new int[100][];
        System.out.println(names.getClass().getName());

        //int 和 Integer 返回的结果不一样
        System.out.println(int.class.getName());
        System.out.println(Integer.class.getName());

        //Class.forName("完整类路径") 通过完整的类路径获取类
        clazz = Class.forName("java.lang.Integer");
        System.out.println(clazz.getName());
        System.out.println(clazz.getTypeName());
        clazz.getSuperclass();
        System.out.println(clazz.getSuperclass().getName());
        System.out.println(clazz.getClass());
        System.out.println(clazz.getClasses());
        System.out.println(clazz.getDeclaringClass());

        clazz = Integer.TYPE;
        System.out.println(clazz.getName());

        System.out.println("get super class!");

        System.out.println(ReflectTest.class.getClasses());

        //返回修饰符的二进制
        System.out.println(ReflectTest.class.getModifiers());
        //返回修饰符二进制对应的字符
        System.out.println(Modifier.toString(ReflectTest.class.getModifiers()));*/

        //反射调用单个成员
        Exam exam = new Exam();
        Method method = exam.getClass().getMethod("fun1");
        method.invoke(exam);

        Field field = exam.getClass().getField("field2");
        System.out.println(field.get(exam));

        //反射调用访问单个私有成员
        Method privateMethod = exam.getClass().getDeclaredMethod("fun2");
        privateMethod.setAccessible(true);
        privateMethod.invoke(exam);

        Method privateMethodByArgument = exam.getClass().getDeclaredMethod("fun3", String.class);
        privateMethodByArgument.setAccessible(true);
        privateMethodByArgument.invoke(exam, "333");

        Field privateField = exam.getClass().getDeclaredField("field1");
        privateField.setAccessible(true);
        System.out.println(privateField.get(exam));



    }

    enum Sex {
        FEMALE,
        MALE
    }


    /**
     * 反射获取public成员
     */
    public static void reflectByPublic() throws IllegalAccessException, InvocationTargetException {
        Exam exam = new Exam();
        System.out.println("获取类中所有的属性");
        //获取所有的public 属性字段
        Field[] fields = exam.getClass().getFields();
        for (Field field : fields) {
            System.out.println(field.getName()+":"+field.get(exam));
        }
        System.out.println("获取类中所有的方法");
        //获取的是public 修饰方法 会获取Object类的方法
        Method[] methods = exam.getClass().getMethods();
        for (Method method : methods) {
            if (method.getName().contains("fun")) {
                //invoke是方法调用 先执行然后返回方法输出结果，如果是void 返回null
                System.out.println(method + ":" + method.invoke(exam));
            } else {
                System.out.println(method);
            }
        }
    }

    /**
     * 获取所有的成员，包括私有private
     */
    public static void reflectByAll() throws IllegalAccessException, InvocationTargetException {
        Exam exam = new Exam();
        Class clazz = exam.getClass();

        //获取所有字段包括 私有成员private
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println(field.getName()+":"+field.get(exam));
        }

        //获取该类声明的所有成员包括private 不会获取Object类的方法
        Method[] methods = clazz.getDeclaredMethods();

        //遍历出来的成员的顺序不一定是定义时候的顺序
        for (Method method : methods) {
            method.setAccessible(true);
            if (method.getName().contains("fun")) {
                if (method.getName().equals("fun3")) {
                    System.out.println(method.getName() + ":" + method.invoke(exam,"sss"));
                } else {
                    System.out.println(method.getName() + ":" + method.invoke(exam));
                }
            } else {
                System.out.println(method.getName());
            }

        }

    }


    /**
     * 反射 调用静态方法
     */
    public static void method(Class type) {


    }



    static class Great{
        public static void say() {
            System.out.println("great");
        }
    }





}
