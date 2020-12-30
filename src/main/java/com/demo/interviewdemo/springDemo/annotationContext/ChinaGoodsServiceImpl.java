package com.demo.interviewdemo.springDemo.annotationContext;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 20:05 2020/12/24
 */
@Component
@Order(10)
public class ChinaGoodsServiceImpl implements GoodsService {
    @Override
    public void sell() {

    }
}
