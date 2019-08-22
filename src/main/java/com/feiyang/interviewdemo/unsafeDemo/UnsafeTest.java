package com.feiyang.interviewdemo.unsafeDemo;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @description: unsafe类的加载和使用
 * @author: jhyang
 * @create: 2019-06-25 17:52
 **/
public class UnsafeTest {
    static final Unsafe unsafe;
    //记录state 在类UnsafeTest 中的偏移值
    static final long stateOffset;

    public volatile long result = 0;
    public int[] arr = {1, 2, 3, 4, 5};
    static{
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
            stateOffset = unsafe.objectFieldOffset(UnsafeTest.class.getDeclaredField("result"));

        } catch (Exception e) {

            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        UnsafeTest unsafeTest = new UnsafeTest();
        for (int i = 0; i < 1000; i++) {
            unsafe.getAndAddLong(unsafeTest, stateOffset, 3L);
        }
    }
}
