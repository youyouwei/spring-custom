package com.demo.interviewdemo.transactionDemo.distributeTransactionDemo;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 16:18 2020/8/19
 */
public class StorageService {
    public StorageService() {
        TransactionCoordinator.register(this);
    }

    public static void commit() {
    }

    public static void cancel() {
    }

    public void operate() {
    }
}
