package com.feiyang.interviewdemo.multiThreadDemo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @description: Fork/Join 任务分割计算 1+2+3+4
 * 任务分割需要找到任务分割的规律使用递归进行分割
 * 先一个分两个，然后针对子任务进行递归分割
 * @author: jhyang
 * @create: 2019-06-30 22:15
 **/
public class CountTask extends RecursiveTask<Integer> {

    private static final int THRESHOLD = 2;
    private int start;
    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        //判断是否能分割任务
        boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        }else {
            int middle = (start + end) / 2;
            //任务分割
            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask = new CountTask(middle + 1, end);
            //执行子任务
            leftTask.fork();
            rightTask.fork();
            //等待子任务执行完，并得到其结果
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();
            sum = leftResult + rightResult;

        }
        return sum;
    }

    public static void main(String[] args) {
        //創建线程池
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        //创建任务
        CountTask countTask = new CountTask(1, 1000);
        //执行任务并返回结果
        Future<Integer> result = forkJoinPool.submit(countTask);
        //task中的任务不会抛出到主线程中 只能task通过判断来获取
        if (countTask.isCompletedAbnormally()) {
            System.out.println(countTask.getException());
        }
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
