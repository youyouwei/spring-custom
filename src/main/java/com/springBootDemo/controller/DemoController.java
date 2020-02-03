package com.springBootDemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 10:47 2020/1/2
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping
    public String demo() {
        return "check demo";
    }

}
