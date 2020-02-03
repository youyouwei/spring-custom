package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.redis.RedisAutoConfiguration;


/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 10:37 2019/12/26
 */
//引用的redis 排除springboot 自动配制
@SpringBootApplication(exclude = {RedisAutoConfiguration.class})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
