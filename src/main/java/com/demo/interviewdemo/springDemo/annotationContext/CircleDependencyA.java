package com.demo.interviewdemo.springDemo.annotationContext;

/**
 * @Description: spring bean 循环依赖:
 * 1、属性注入依赖没问题
 * 2、setter方法注入依赖没问题
 * 3、构造器注入依赖 如果先创建的bean是先构造会造成不可解决的循环依赖 如果是后依赖则可以完成，因为非构造器注入可以预先通过构造器实例化，然后再注入属性
 * 因为创建A构造器需要C，然后创建C又需要先初始化A导致一个不可解决的循环依赖
 * Requested bean is currently in creation: Is there an unresolvable circular reference?
 * 这是因为bean在创建过程中会有inCreation的标志。构造注入循环依赖就是造成还在创建过程中的bean重复被构建，spring会直接抛出BeanIsCurrentlyInCreationException异常。
 *
 * 非构造器注入的单例bean会先通过无参构造方法构造bean然后把构造过的还没完成属性或则方法注入的bean放入beanFactory的池中缓存（prototype的bean不会缓存所以不支持循环依赖），然后再注入属性或则方法，如果遇到循环依赖可以先去beanFactory中查找对应还未完成注入的依赖bean的实例。
 *
 *
 *
 * @Author: jiahuiyang
 * @Date: Created in 17:16 2020/11/28
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CircleDependencyA {

    @Autowired
    private CircleDependencyB circleDependencyB;

    public CircleDependencyA() {
        System.out.println("create circleDependencyA");
    }


}
