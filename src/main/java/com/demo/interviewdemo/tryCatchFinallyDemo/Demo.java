package com.demo.interviewdemo.tryCatchFinallyDemo;

import java.io.IOException;
import java.net.Socket;

/**
 * @Description: try-catch-finally实验  执行流程
 *
 * @Author: jiahuiyang
 * @Date: Created in 20:52 2020/8/15
 */
public class Demo {

    public static void main(String[] args) {

        method2();
    }


    /**
     * try-catch-finally
     */
    public static void method() {
        try {

        } catch (Exception e) {

        }finally {

        }
    }

    /**
     * try-finally
     * 执行流程正常会执行finally 中的代码，如果try代码块有异常抛出也会执行finally块的代码
     */
    public static void method2() {
        try {
            throw new RuntimeException("Throw some runtime exceptions");

        }finally {

            System.out.println("execute finally code block");

        }
    }

    /**
     * try-catch
     */
    public static void method3() {
        try {


        } catch (Exception e) {

        }
    }

    /**
     * try() 释放资源
     */
    public static void method4() {
        try (Socket socket = new Socket()){

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
