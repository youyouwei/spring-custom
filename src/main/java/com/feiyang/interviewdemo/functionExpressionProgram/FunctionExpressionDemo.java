package com.feiyang.interviewdemo.functionExpressionProgram;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Optional;

/**
 * @Description: 函数式编程
 *
 * @Author: jiahuiyang
 * @Date: Created in 11:22 2019/12/2
 */
public class FunctionExpressionDemo {

    public static void main(String[] args) {

        String[] array = {"orange", "pear", "apple"};
        Arrays.sort(array,String::compareToIgnoreCase);
        Arrays.sort(array,(u,v)->u.compareTo(v));
//        如果使用 :: 进行函数式编程 就要考虑方法的调用方也是lamada 表达式的参数之一
//        使用对象引用方法进行函数式编程
        Arrays.sort(array,String::compareTo);

//        使用静态方法进行函数式编程
//        或则是使用当前参数类型的引用方法来作为函数式编程处理
        Arrays.sort(array, FunctionExpressionDemo::compare);

        Optional<String> optional = Optional.empty();


    }

    static int compare(String a, String b) {
        return a.compareTo(b);
    }


}
