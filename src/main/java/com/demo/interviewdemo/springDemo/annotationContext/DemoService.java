package com.demo.interviewdemo.springDemo.annotationContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-04-17 14:09
 **/
@Service
public class DemoService {

//    @Resource("chinaGoodsServiceImpl")
    private GoodsService goodsService;


    public void method() {
        System.out.println("annotation context");
    }
}
