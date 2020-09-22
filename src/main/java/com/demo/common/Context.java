package com.demo.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 程序的上下文，bean的一个集合环境，或则是整个程序使用对象实例的一个集合环境
 * @author: jhyang
 * @create: 2019-04-02 10:22
 **/
public class Context {

    /**
     * bean存放集合
     */
    public static Map<String, Object> beanMap = new HashMap<>();

    /**
     * 静态方法块，存放bean
     */
    static{
        beanMap.put("", null);
    }

    /**
     * 获取某个bean
     * @param type
     * @return
     */
    public <T> T getBean(String type) {
        if (beanMap.containsKey(type)) {
            return (T) beanMap.get(type);
        }
        return null;
    }

    public <T> void setBean(T t) {
        beanMap.put(t.getClass().getName(), t);
    }

}
