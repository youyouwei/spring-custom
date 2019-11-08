package com.feiyang.interviewdemo.springDemo.anntation;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 11:39 2019/11/5
 */
@Data
@Component
@ComponentScan("com.feiyang.interviewdemo.springDemo.anntation")
public class Phone {

    private String name;
    private String type;
    private String productor;

    @Bean
    public DemoConfig demoConfig() {
        return new DemoConfig();
    }


}
