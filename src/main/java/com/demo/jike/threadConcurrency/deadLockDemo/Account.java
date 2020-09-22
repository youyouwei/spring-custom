package com.demo.jike.threadConcurrency.deadLockDemo;

/**
 * @Description: 银行账户
 * @Author: jiahuiyang
 * @Date: Created in 11:43 2019/12/16
 */
public class Account {

    /**
     * 余额
     */
    private int balance;

    /**
     * 分配器
     */
    private Allocator allocator = Allocator.getInstance();


    /**
     * 转账  这种可以避免使用粗粒度锁来锁定资源 但是这种细粒度锁会导致死锁的现象
     * 如果A->B B->A  每个用户的账户只能有一个实例化
     *
     * @param target
     * @param amount
     */
    public void transfer(Account target, int amount) {

        synchronized (this) {
            synchronized (target) {
                if (this.balance > amount) {
                    this.balance -= amount;
                    target.balance += amount;
                }
            }
        }

    }

    /**
     * 通过allocator 改进后的转账操作
     * @param target
     * @param amount
     */
    public void newTransfer(Account target, int amount) {
        //一次性申请转入账户和转出账户资源 申请到之后锁定资源 （一般说获取资源也要加上锁 避免一个线程同时获取资源，即对获取资源进行锁定）
        //所以获取资源也会产生竞争 但是对至少不会发生死锁
        while (allocator.apply(this,target));

        try {
            synchronized (this) {
                synchronized (target) {
                    if (this.balance > amount) {
                        this.balance -= amount;
                        target.balance += amount;
                    }
                }
            }

        }finally {
            //释放资源
            allocator.free(this, target);
        }

    }



}
