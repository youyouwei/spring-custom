package com.demo.interviewdemo.innerExceptionDemo;

import java.util.function.Consumer;

/**
 * @description: 匿名内部类异常 一般不能抛出 只能自己处理掉，如果对应的方法没有throws exception 就捕获不到异常 同时ide也会提示异常
 * 匿名类中检查异常 需要看调用匿名类中是否有声明异常 否则会编译报错；如果有声明异常，匿名类中的异常是可以抛出的
 * @author: jhyang
 * @create: 2019-08-06 11:12
 **/
public class InnerExceptionDemo {

    public static void main(String[] args) throws Exception {
        //匿名内部类
        new Inner(){
            @Override
            public void drink() throws Exception {
                try {
                    int i = 0;
                    int j = 100 / i;
                    //throw new Exception();
                } catch (Exception e) {
                    throw e;
                }
            }
        }.drink();

        //new InnerNew() {
        //    @Override
        //    public void eat() {
        //        try {
        //            String s = null;
        //            int len = s.length();
        //            System.out.println(s);
        //            //ide 没有检测出未处理异常 但是异常并未被抛出来 ：结果是没有输出也没有异常
        //            //throw new Exception();
        //        } catch (Exception e) {
        //            throw e;
        //        }
        //    }
        //}.eat();

        //method(() -> {
        //    try {
        //        String s = null;
        //        int len = s.length();
        //    } catch (Exception e) {
        //        throw e;
        //    }
        //});
        //
        //method1(u->{
        //    try {
        //        int j = u;
        //    } catch (Exception e) {
        //        throw e;
        //    }
        //});
        //
        //Arrays.asList("1", "2",null).forEach(u ->{
        //    try {
        //        System.out.println(u.length());
        //        //throw new IOException();
        //    } catch (Exception e) {
        //        throw e;
        //    }
        //});


    }


    public static void method(InnerNew innerNew) {

    }

    public static void method1(Consumer<Integer> action) {

    }

    public void method2(Consumer<Integer> action) {

    }

    public void method3() {
        new InnerExceptionDemo().method2(u->{
            try {
                int j = u;
            } catch (Exception e) {
                throw e;
            }
        });

    }

}

/**
 * 声明异常
 */
interface Inner {
    void drink() throws Exception;
}

/**
 * 不声明异常
 */
interface InnerNew {
    void eat();
}
