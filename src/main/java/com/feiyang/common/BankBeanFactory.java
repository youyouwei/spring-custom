package com.feiyang.common;

import com.feiyang.service.Bank;
import org.springframework.cglib.beans.BeanMap;

/**
 * @description: 工厂类
 * @author: jhyang
 * @create: 2019-04-02 10:23
 **/
public class BankBeanFactory {
    /**
     * 单例
     */
    private static BankBeanFactory factory = new BankBeanFactory();

    /**
     * 私有构造
     */
    private BankBeanFactory() {}

    /**
     * 获取静态实例
     * @return
     */
    public static BankBeanFactory getInstance() {
        if (factory != null) {
            return factory;
        }
        return null;
    }

    /**
     * 创建对象
     * @param type
     * @return
     */
    public Bank create(String type) {
        //TODO 获取带有注解的类，使用反射实例化




        return null;
    }

}
