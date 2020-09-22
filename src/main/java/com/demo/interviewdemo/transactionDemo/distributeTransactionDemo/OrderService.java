package com.demo.interviewdemo.transactionDemo.distributeTransactionDemo;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 16:19 2020/8/19
 */
public class OrderService {

    public OrderService() {
        TransactionCoordinator.register(this);
    }
    public static void commit() {
    }

    public static void cancel() {
    }

    public void operate() {
        AccountService accountService = new AccountService();
        accountService.operate();
    }
}
