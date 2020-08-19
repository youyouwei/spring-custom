package com.feiyang.interviewdemo.transactionDemo.distributeTransactionDemo;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 16:21 2020/8/19
 */
public class AccountService {

    public AccountService() {
        TransactionCoordinator.register(this);
    }

    public void operate() {
    }
}
