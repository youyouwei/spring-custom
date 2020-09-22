package com.demo.jike.threadConcurrency.deadLockDemo;

/**
 * @Description: 账户增加序号id 根据序号来获取锁资源 破坏循环条件
 * @Author: jiahuiyang
 * @Date: Created in 11:09 2019/12/17
 */
public class NewAccount {

    private int id;
    private int balance;

    public void transfer(NewAccount target, int amount) {
        NewAccount left = this;
        NewAccount right = target;
        //左右锁 左边小右边大 判断大小是否正确 否则调换位置
        if (this.id > target.id) {
            left = target;
            right = this;
        }
        // 按从小到大的顺序锁定账户资源
        synchronized (left) {
            synchronized (right) {
                if (this.balance > amount) {
                    this.balance -= amount;
                    target.balance += amount;
                }
            }

        }

    }

}
