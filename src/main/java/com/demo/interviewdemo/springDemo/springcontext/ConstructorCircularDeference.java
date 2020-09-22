package com.demo.interviewdemo.springDemo.springcontext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 16:22 2020/5/15
 */
@Component
public class ConstructorCircularDeference {

    private ConstructorCircularDeferenceAnother constructorCircularDeferenceAnother;


    @Autowired
    @Lazy
    public ConstructorCircularDeference(ConstructorCircularDeferenceAnother constructorCircularDeferenceAnother) {
        this.constructorCircularDeferenceAnother = constructorCircularDeferenceAnother;
    }


}
