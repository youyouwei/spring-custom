package com.demo.interviewdemo.ExceptionHandlerDemo;

import lombok.Data;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 17:23 2020/11/2
 */
@Data
public class BusinessException extends RuntimeException{

    private static final long serialVersionUID = 5432112049869876747L;

    //如果需要通过切面截取异常信息返回前端或则调用者，就自定义message和code，可以通过aspect切面获取异常信息封装成统一格式返回给前端
    private String message;

    private String code;


    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        //需要声明 调用父类构造器，否则都默认调用父类无参构造器
        super(message);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(BusinessExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.message = exceptionEnum.getMessage();
        this.code = exceptionEnum.getCode();
    }


    public BusinessException(BusinessExceptionEnum exceptionEnum, Throwable cause) {
        super(exceptionEnum.getMessage(), cause);
        this.message = exceptionEnum.getMessage();
        this.code = exceptionEnum.getCode();
    }






}
