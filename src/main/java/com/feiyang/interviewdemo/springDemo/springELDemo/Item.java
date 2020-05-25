package com.feiyang.interviewdemo.springDemo.springELDemo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-06-27 11:00
 **/
@Getter
@Setter
@ToString
@Component("itemBean")
public class Item {
    @Value("itemA")
    private String name;

    @Value("10")
    private int total;
}
