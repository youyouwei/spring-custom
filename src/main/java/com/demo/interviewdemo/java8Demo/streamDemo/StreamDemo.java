package com.demo.interviewdemo.java8Demo.streamDemo;

import com.demo.interviewdemo.annotationAndReflect.RuntimeAnnotation;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description: 集合stream操作
 * @author: jhyang
 * @create: 2019-07-23 16:34
 **/
public class StreamDemo {

    private String name = "";

    public static void main(String[] args) {


//        reduceMethod();
//        streamBuild();
//        flatMap();

//        mapReduce();

        chainOperate();
    }


    /**
     * toMap使用方法
     */
    public static void toMap() {

    }

    /**
     * map转list
     */
    public static void mapToList() {



    }

    /**
     * list转map
     */
    public static void listToMap() {

    }

    /**
     * 元素合并操作
     * stream api的reduce方法用于对stream中元素进行聚合求值，最常见的用法就是将stream中一连串的值合成为单个值，比如为一个包含一系列数值的数组求和。
     */
    public static void reduceMethod() {

        List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5);
        //累加求和
        //lambada表达式的a参数是表达式的执行结果的缓存，也就是表达式这一次的执行结果会被作为下一次执行的参数，
        // 而第二个参数b则是依次为stream中每个元素。如果表达式是第一次被执行，a则是stream中的第一个元素。
        int result = numList.stream().reduce((a, b) -> a + b).get();
        System.out.println(result);

        //如果为空返回第一个参数默认值
        result = numList.stream().reduce(0, (a, b) -> a + b);
        System.out.println(result);
        //第三个参数表示 类型转换 int->long
        long resultNew = numList.stream().reduce(0L, (a, b) -> a + b, (a, b) -> 0L);
        System.out.println(resultNew);

    }

    public static void method() {
        List<String> list = Arrays.asList("a", "b", "c", "c");
        //toList
        List<String> listNew = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(listNew);
        // toMap 第三个参数是key重复处理方式
        Map<String, String> map = list.stream().map(String::toUpperCase).collect(Collectors.toMap(String::toString, String::toString, (oldValue, newValue) -> oldValue, HashMap::new));
        System.out.println(map);
    }

    /**
     * 基本类数组转包装类
     */
    public static void method1() {
        int[] nums = {1, 3, 6, 4};
//        Integer[] integers = Arrays. ;
        Assert.notNull(null, null);



    }


    /**
     * java8 stream 中map 和 reduce操作
     * map是映射函数 可以把入参转成另外一个类型
     * reduce 是执行一个函数
     */
    public static void mapReduce() {

        // 通过 map(u->1) 来计算 元素个数  reduce 的 identity 参数是 初始值 就是和第一个元素进行reduce的值
        System.out.println(Stream.of(1, 2, 3, 4).map(u -> 1).reduce(0, (x, y) -> x + y));

        System.out.println(Stream.of(1,2,3).count());


    }

    /**
     * if else 判断
     */
    public static void check() {

        boolean check = false;
        if (check) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        // 如果

        Optional.of(check).filter(x -> x).orElseThrow(() -> new RuntimeException(""));

    }

    /**
     * stream build by multi type
     */
    public static void streamBuild() {

        Stream.builder().add(1).add("string").add(new Object()).build().forEach(System.out::println);


        Stream.Builder builder = Stream.builder();
        builder.accept(2);

        Stream stream = builder.build();

        stream.forEach(System.out::println);
    }


    public static void flatMap() {

        // 可以通过 flatMap 操作 合并多个List 集合
        Stream.of(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(4, 5, 6))
                .flatMap(Collection::stream)
                .forEach(System.out::println);

    }


    /**
     *
     *
     *  stream 遍历所有元素取值 可以使用函数式编程 如 BinaryOperator.maxBy 方法
     * @Override
     *     public final Optional<P_OUT> max(Comparator<? super P_OUT> comparator) {
     *         return reduce(BinaryOperator.maxBy(comparator));
     *     }
     *
     *     @Override
     *     public final Optional<P_OUT> min(Comparator<? super P_OUT> comparator) {
     *         return reduce(BinaryOperator.minBy(comparator));
     *
     *     }
     *
     *
     */
    public static void chainOperate() {


        Function<Integer, Integer> fun1 = x -> x * 2;

        Function<Integer, Integer> fun2 = x -> x + 2;

        System.out.println(fun1.apply(1));

        // compose 是before当前调用者执行  fun2 -> fun1
        System.out.println(fun1.compose(fun2).apply(1));

        // andThen 是after当前调用者执行   fun2 -> fun1 -> fun2
        System.out.println(fun1.compose(fun2).andThen(fun2).apply(1));

        // fun2 -> fun2 -> fun1
        System.out.println(fun1.compose(fun2).compose(fun2).apply(1));

        System.out.println();


    }


    abstract static class Christmas {

        public static void method() {
            System.out.println("merry ");
        }

    }







}
