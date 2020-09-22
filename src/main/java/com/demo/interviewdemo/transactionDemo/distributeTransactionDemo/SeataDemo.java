package com.demo.interviewdemo.transactionDemo.distributeTransactionDemo;

/**
 * @Description:  Alibaba的分布式事务中间件Seata
 * @Author: jiahuiyang
 * @Date: Created in 16:12 2020/8/19
 */
public class SeataDemo {

    public static void main(String[] args) {
        Business business = new Business();
        business.operate();
    }


}