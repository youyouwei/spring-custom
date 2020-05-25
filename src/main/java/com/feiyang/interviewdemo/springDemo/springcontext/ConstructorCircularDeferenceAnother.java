package com.feiyang.interviewdemo.springDemo.springcontext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 16:24 2020/5/15
 */
@Component
public class ConstructorCircularDeferenceAnother {

    private ConstructorCircularDeference constructorCircularDeference;

    @Autowired
    public ConstructorCircularDeferenceAnother(ConstructorCircularDeference constructorCircularDeference) {
        this.constructorCircularDeference = constructorCircularDeference;
    }
}
