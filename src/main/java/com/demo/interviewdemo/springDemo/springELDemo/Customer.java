package com.demo.interviewdemo.springDemo.springELDemo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @description:
 * 使用 spring EL 表达式
 * @author: jhyang
 * @create: 2019-06-27 11:01
 **/
@Component("customerBean")
@Getter
@Setter
@ToString
public class Customer {

    @Value("#{itemBean}")
    private Item item;

    @Value("#{itemBean.name}")
    private String itemName;

    @Value("${app.name}")
    private String appName;

    @Value("${person.name:jack}")  //如果没有默认值 又没有找到对应的配置 会输出变量名称 value 中的值
    private String personName;

}
