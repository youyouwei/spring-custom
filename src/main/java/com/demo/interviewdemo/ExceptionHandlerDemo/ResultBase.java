package com.demo.interviewdemo.ExceptionHandlerDemo;

import lombok.Data;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 18:02 2020/11/2
 */
@Data
public class ResultBase<E> {
    private E data;

    private String message;

    private String code;
}
