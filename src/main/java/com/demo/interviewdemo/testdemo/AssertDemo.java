package com.demo.interviewdemo.testdemo;

import org.springframework.util.StringUtils;

/**
 * @Description: assert断言判断 如果assert关键字修饰的表达式返回结果为true 就继续向下执行 否则抛出AssertionError异常
 *
 * 启动断言需要在vm参数配置中配置-ea 或则-enableasstions
 *
 * @Author: jiahuiyang
 * @Date: Created in 14:45 2020/5/20
 */
public class AssertDemo {
    public static void main(String[] args) {
        method();
    }

    /**
     *  如果assert 返回为false会报AssertionError异常
     *  assert 修饰的表达式必须返回boolean类型值 否则编辑器提示语法错误
     *
     *  java的assert关键字和Junit测试工具类似，但是Junit功能更完善和强大
     */
    public static void method() {
        String content = "";
//        assert content == null;
//        assert content = "tom";
        assert StringUtils.isEmpty(content);
        System.out.println("content=" + content);
    }


}
