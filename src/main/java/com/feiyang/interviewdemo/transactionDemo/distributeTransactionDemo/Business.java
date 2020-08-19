package com.feiyang.interviewdemo.transactionDemo.distributeTransactionDemo;

/**
 * @Description: Transaction Manager (TM)
 * @Author: jiahuiyang
 * @Date: Created in 16:14 2020/8/19
 */
public class Business {
    public void operate() {
        StorageService storage = new StorageService();
        OrderService order = new OrderService();

        try {
            storage.operate();
            order.operate();

            commit();
        } catch (Exception e) {
            cancel();
        }

    }

    private void cancel() {
        StorageService.cancel();
        OrderService.cancel();


    }

    private void commit() {
        StorageService.commit();
        OrderService.commit();
    }
}
