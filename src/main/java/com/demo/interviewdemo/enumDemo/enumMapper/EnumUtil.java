package com.demo.interviewdemo.enumDemo.enumMapper;

import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 14:20 2020/7/8
 */
public class EnumUtil {

    private final static String BIZ_CODE_METHOD_NAME = "getCode";

    public EnumUtil() {

    }

    /**
     * 通过Code 返回枚举 针对那些不需要实现KeyValueEnum，但是有定义getCode方法的枚举 可以通过反射调用获取code进行比较
     * @param clazz
     * @param code
     * @param <T>
     * @return 如果找打对应枚举值返回否则返回空null
     */
    public static <T extends Enum<T>> T getEnumByCode(Class<T> clazz, Object code) {
        Method method = null;
        try {
            method = clazz.getMethod(BIZ_CODE_METHOD_NAME);

        } catch (NoSuchMethodException e) {
            return null;
        }
        //获取枚举类型中定义的常量值
        Enum[] enums = clazz.getEnumConstants();
        int length = enums.length;
        for (int i = 0; i < length; i++) {
            T t = (T) enums[i];
            Object codeTemp = null;
            try {
                codeTemp = method.invoke(t);
            } catch (Exception e) {
                return null;
            }
            if (codeTemp != null && codeTemp.equals(code)) {
                return t;
            }
        }
        return null;
    }


    /**
     * 通过code获取枚举的desc
     * @param clazz
     * @param code
     * @param <T>
     * @return
     */
    public static <T extends Enum<T> & KeyValueEnum> String getEnumDesc(Class<T> clazz, Object code) {
        T[] enums = clazz.getEnumConstants();
        int length = enums.length;
        for (int i = 0; i < length; i++) {
            T t = enums[i];
            //clazz 类型需要是实现KeyValueEnum接口 然后进行强转 获取对应的code 和 desc
            if (((KeyValueEnum) t).getCode() != null && ((KeyValueEnum) t).getCode().equals(code)) {
                return ((KeyValueEnum) t).getDesc();
            }
        }
        return null;
    }

    /**
     * 通过code获取 实现KeyValueEnum接口的枚举
     * @param clazz
     * @param code
     * @param <T>
     * @return
     */
    public static <T extends Enum<T> & KeyValueEnum> T getEnum(Class<T> clazz, Object code) {

        if (clazz == null || code == null) {
            return null;
        } else {
            T[] enums = clazz.getEnumConstants();
            int length = enums.length;
            for (int i = 0; i < length; i++) {
                T t = enums[i];
                if (((KeyValueEnum) t).getCode() != null && ((KeyValueEnum) t).getCode().equals(code)) {
                    return t;
                }
            }
        }
        return null;
    }

    /**
     * 通过desc 获取枚举的 code
     * @param clazz
     * @param desc
     * @param <T>
     * @return
     */
    public static <T extends Enum<T> & KeyValueEnum> String getEnumCode(Class<T> clazz, Object desc) {
        T[] enums = clazz.getEnumConstants();
        int length = enums.length;
        for (int i = 0; i < length; i++) {
            T t = enums[i];
            //clazz 类型需要是实现KeyValueEnum接口 然后进行强转 获取对应的code 和 desc
            if (((KeyValueEnum) t).getDesc() != null && ((KeyValueEnum) t).getDesc().equals(desc)) {
                return String.valueOf(((KeyValueEnum) t).getCode());
            }

        }
        return null;
    }


}
