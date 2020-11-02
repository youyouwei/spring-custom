package com.demo.interviewdemo.ExceptionHandlerDemo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 17:54 2020/11/2
 */
@ControllerAdvice
public class ExceptionAspect {

    //也可以直接写@ExceptionHandler，不指明异常类，会自动映射
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResultBase customizeExceptionHandler(BusinessException exception) {
        ResultBase resultBase = new ResultBase();
        resultBase.setMessage(exception.getMessage());
        resultBase.setCode(exception.getCode());
        return resultBase;
    }


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public ResultBase allExceptionHandler(Exception exception) {
        ResultBase resultBase = new ResultBase();
        resultBase.setMessage("exception");
        resultBase.setCode("EXCEPTION");

        return resultBase;
    }

}
