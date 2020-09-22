package com.demo.interviewdemo.springDemo.springStrategy;

/**
 * @Description: 客户更新策略顶级接口
 * @Author: jiahuiyang
 * @Date: Created in 16:19 2020/5/21
 */
public interface ICustomerChangeProcessor<T, R> {

    R process(T t);

    /**
     * 比较字段是否等
     *
     * @param original
     * @param target
     * @param <U>
     * @return
     */
    default <U> boolean checkEquals(U original, U target) {

        if (original != null && original.equals(target)) {
            return true;
        }
        if (original == null && target == null) {
            return true;
        }
        return false;
    }

    String getProcessName();

}
