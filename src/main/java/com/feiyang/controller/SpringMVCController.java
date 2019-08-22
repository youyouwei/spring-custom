package com.feiyang.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-04-11 15:16
 **/
@RestController
@RequestMapping("/springmvc")
public class SpringMVCController {

    @GetMapping("/test")
    public String method() {
        return "spring mvc test";
    }

}
