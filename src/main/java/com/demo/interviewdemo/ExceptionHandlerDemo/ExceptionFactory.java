package com.demo.interviewdemo.ExceptionHandlerDemo;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 17:32 2020/11/2
 */
public class ExceptionFactory {

    private ExceptionFactory() {

    }

    public ExceptionFactory getInstance() {
        return new ExceptionFactory();
    }


    public BusinessException exception(BusinessExceptionEnum exceptionEnum) {

        return new BusinessException(exceptionEnum);



    }

}
