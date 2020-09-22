package com.demo.interviewdemo.testdemo;

public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        //获取Class对象 三种方式
        Class t = A.class;
        t = Class.forName("org.springfans.third.controller.ReflectTest$A");
        t = new A().getClass();

        System.out.println(t.getName());
        System.out.println(t.getSuperclass());
        System.out.println(t.newInstance());
        System.out.println(t.getFields());
        System.out.println(t.getDeclaredFields());
        System.out.println(t.getMethods());
        System.out.println(t.getDeclaredMethods());
        //如果只能访问public方法访问了非public方法会报错 该方法找不到
        //getMethod只能获取public修饰方法
        System.out.println(t.getMethod("method",String.class));
        //获取非public修饰method
        System.out.println(t.getDeclaredMethod("notPublicMethod", String.class));
        System.out.println(t.getConstructors());
        //获取非public构造方法
        System.out.println(t.getDeclaredConstructor(Integer.class, String.class));
        //获取public构造方法
        System.out.println(t.getConstructor(String.class));
        System.out.println(t.getInterfaces());
        System.out.println(t.getSimpleName());
        System.out.println(t.getAnnotatedInterfaces());
        System.out.println(t.getAnnotatedSuperclass());
        System.out.println(t.getAnnotations());
        System.out.println(t.getCanonicalName());
        System.out.println(t.getClassLoader());
        System.out.println(t.getComponentType());
        System.out.println(t.getDeclaredAnnotations());



        //创建反射对象
        A a = (A) getReflectInstance(t);



    }

    public static  <T> T getReflectInstance(Class<T> tClass) throws IllegalAccessException, InstantiationException {

        return tClass.newInstance();

    }

    static class A {

        public A() {

        }

        public A(String s) {

        }

        A(Integer id, String name) {

        }

        public String method(String s) {

            return "";
        }

        void notPublicMethod(String s) {

        }

    }


}