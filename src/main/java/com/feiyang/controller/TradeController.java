package com.feiyang.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-04-02 11:35
 **/
@RestController
@RequestMapping("/trade")
public class TradeController {

    @GetMapping("/consume")
    public String consume() {
        return "consume success!";
    }

}
