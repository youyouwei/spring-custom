package com.demo.interviewdemo.springDemo.annotationContext;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 11:54 2020/11/28
 */
@Service
@Order(100)
public class GoodsServiceImpl implements GoodsService {

    @Override
    public void sell() {
        System.out.println("this good for sell");
    }

}
