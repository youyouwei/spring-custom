package com.demo.interviewdemo.ExceptionHandlerDemo;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 17:32 2020/11/2
 */
public enum BusinessExceptionEnum {

    PARAM_IS_NULL("param is null", "501");


    private String message;

    private String code;

    // 枚举类的构造器 默认就是private 不需要显式声明
    BusinessExceptionEnum(String message, String code) {
        this.message = message;
        this.code = code;
    }


    //枚举基类Enum中定义了valueOf方法，所以不能重复定义，valueOf是通过name来获取枚举项的
    public BusinessExceptionEnum valueOfByMessage(String message) {
        BusinessExceptionEnum[] businessExceptionEnums = BusinessExceptionEnum.values();
        for (int i = 0; i < businessExceptionEnums.length; i++) {
            if (businessExceptionEnums[i].message.equals(message)) {
                return businessExceptionEnums[i];
            }
        }
        return null;
    }

    public String getMessage() {
        return this.message;
    }

    public String getCode() {
        return this.code;
    }



}
