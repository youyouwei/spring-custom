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
            //try 下单
            tryPlaceOrder();
            //lock产品数量  product rpc
            lockProductAmount();
            //lock账户金额  account rpc
            lockAccountAmount();

            //确认提交
            commit();

        } catch (Exception e) {
            //异常回滚
            cancel();
        }
    }

    /**
     * 订单服务下单后发送订单消息
     */
    public static void orderService() {
        try {
            tryPlaceOrder();
            sendOrderMessage();
        } catch (Exception e) {
        }
    }

    /**
     * 产品服务 监听订单消息
     */
    public static void productService() {
        try {
            getOrderMessage();
        } catch (Exception e) {

        }
    }

    /**
     * 账户服务 监听订单服务
     */
    public static void accountService() {
        try {
            getOrderMessage();
        } catch (Exception e) {

        }
    }

    private static void getOrderMessage() {
    }

    private static void sendOrderMessage() {
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
