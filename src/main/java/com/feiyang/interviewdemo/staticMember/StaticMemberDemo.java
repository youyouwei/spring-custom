package com.feiyang.interviewdemo.staticMember;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-07-02 10:58
 **/
public class StaticMemberDemo {

    public static void main(String[] args) {
        System.out.println(StaticMemberDemoClass.name);
        StaticMemberDemoClass staticMemberDemoClass = new StaticMemberDemoClass();
        //对象直接访问静态成员 ide 会提示错误，但是编译器和jvm会运行通过
        //访问静态成员一般要使用类名直接访问 避免对象访问增加编译器解析成本
        System.out.println(StaticMemberDemoClass.name);

        Integer i1 = 10;
        Integer i2 = 10;

        System.out.println(i1.equals(i2));

        ArrayList<String> list = new ArrayList<>();
        list.add("111");
        list.add("222");
        list.add("333");
        //不包含最后一个索引值
        List<String> list1 = list.subList(1, 2);
        list1.forEach(System.out::println);




    }

}
