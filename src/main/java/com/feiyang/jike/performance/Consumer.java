package com.feiyang.jike.performance;

import lombok.Data;

import java.util.Date;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 16:02 2019/12/13
 */
@Data
public class Consumer {

    private Integer id;
    private String name;
    private Integer age;
    private Date birthday;

    public Consumer() {

    }

    public Consumer(Integer id, String name, Integer age, Date birthday) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }



}
