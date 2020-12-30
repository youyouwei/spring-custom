package com.demo.interviewdemo.springDemo.springELDemo;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @Description: spring expression parser demo operate
 * @Author: jiahuiyang
 * @Date: Created in 17:00 2020/12/26
 */
public class ExpressionParserDemo {

    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();

        Expression expression = parser.parseExpression("'T' eq 'T'");
        System.out.println(expression.getValue(Boolean.class));

    }

    public static void method() {

    }

}
