package com.demo.interviewdemo.assertDemo;

/**
 * @Description: 抽象工具类 不需要实现 直接调用静态方法
 * @Author: jiahuiyang
 * @Date: Created in 11:51 2020/9/22
 */
public abstract class AssertUtil {

    /**
     * 功能描述: 断言大于零<br>
     *
     * @param number
     */
    public static void greaterThenZero(Number number) {
        greaterThenZero(number,
                "[Assertion failed] - this number must be greater then zero");
    }

    /**
     * 功能描述: 断言大于零<br>
     *
     * @param number
     * @param message
     *            描述信息
     */
    public static void greaterThenZero(Number number, String message) {
        if (number == null || number.longValue() <= 0) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 功能描述: 断言非空<br>
     *
     * @param object
     */
    public static void notNull(Object object) {
        notNull(object,
                "[Assertion failed] - this argument is required; it must not be null");
    }

    /**
     * 功能描述: 断言非空<br>
     *
     * @param object
     * @param message
     */
    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 功能描述: 断言为true<br>
     *
     * @param expression
     * @param message
     */
    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 功能描述: 断言为true<br>
     *
     * @param expression
     */
    public static void isTrue(boolean expression) {
        isTrue(expression, "[Assertion failed] - this expression must be true");
    }

    /**
     * <p>
     * [概 要] 参数都不能为null.
     * <p>
     *
     * @param params
     */
    public static void notNullAll(Object... params) {
        notNull(params);
        for (Object o : params) {
            notNull(o);
        }
    }

}