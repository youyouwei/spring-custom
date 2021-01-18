package com.demo.interviewdemo.jdkSource;

/**
 * @Description: Integer jdk code source
 *
 * @Author: jiahuiyang
 * @Date: Created in 12:18 2021/1/18
 */
public class IntegerSource {

    public static void main(String[] args) {

        method();

    }


    /**
     * 通过修改vm 参数-XX:AutoBoxCacheMax=N来设置IntegerCache 中的high值，默认是127，如果vm 参数 小于127会取127
     *
     *  The cache is initialized on first usage.  The size of the cache
     *      * may be controlled by the {@code -XX:AutoBoxCacheMax=<size>} option.
     *      * During VM initialization, java.lang.Integer.IntegerCache.high property
     *      * may be set and saved in the private system properties in the
     *      * sun.misc.VM class.
     *
     *       int h = 127;
     *             String integerCacheHighPropValue =
     *                 sun.misc.VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
     *             if (integerCacheHighPropValue != null) {
     *                 try {
     *                     int i = parseInt(integerCacheHighPropValue);
     *                     i = Math.max(i, 127);
     *                     // Maximum array size is Integer.MAX_VALUE
     *                     h = Math.min(i, Integer.MAX_VALUE - (-low) -1);
     *                 } catch( NumberFormatException nfe) {
     *                     // If the property cannot be parsed into an int, ignore it.
     *                 }
     *             }
     */
    public static void method() {
        // 在 valueOf方法中加入断点 查看IntegerCache.cache数组中的值
        Integer i = Integer.valueOf(130);
        System.out.println(i);

    }




}
