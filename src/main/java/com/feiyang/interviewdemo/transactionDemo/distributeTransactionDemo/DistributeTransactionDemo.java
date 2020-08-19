package com.feiyang.interviewdemo.transactionDemo.distributeTransactionDemo;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 15:34 2020/8/19
 */
public class DistributeTransactionDemo {

    public static void main(String[] args) {
        try {
            //自顶向下编程方式，先在顶层编写具体功能方法，然后在具体实现每个方法的功能，这样会全面实现需求，方便你整理大型需求的实现方式。
            //
            tryPlaceOrder();
            lockProductAmount();
            lockAccountAmount();

            commit();

        } catch (Exception e) {
            cancel();
        }
    }

    private static void commit() {
    }

    private static void cancel() {
    }

    private static void lockProductAmount() {
    }

    private static void lockAccountAmount() {
    }

    private static void tryPlaceOrder() {
    }
}
