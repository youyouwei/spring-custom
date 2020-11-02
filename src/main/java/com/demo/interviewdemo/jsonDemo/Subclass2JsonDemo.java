package com.demo.interviewdemo.jsonDemo;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:  运行时通过子类传入 json 工具进行转换 转换后的结果回事子类的全部字段
 *
 * 在编码阶段 只能通过根据定义的静态类型进行操作对象，如果对象声明类型中没有定义的方法或则属性就不能直接使用，就算实例化是通过子类也不行，因为多态是运行时实现的，就是程序在运行时对象是显示的实际实例化类型进行执行的
 *
 * 因为json工具是通过反射获取对象的实现类 然后获取实现类中的所有属性 包括父类 所以会输出所有字段
 *
 * @Author: jiahuiyang
 * @Date: Created in 15:10 2020/9/24
 */
public class Subclass2JsonDemo {


    public static void main(String[] args) {
        FruitJuice fruitJuice = new FruitJuice();
        fruitJuice.setColor("red");
        fruitJuice.setVolume("200");
        fruitJuice.setJuiceNum("10");
        fruitJuice.setType("big");

        Drink drink = fruitJuice;

        System.out.println(JSON.toJSONString(drink));

        //{"color":"red","juiceNum":"10","type":"big","volume":"200"}
        // 所以虽然是通过Drink类型传入 输出的还是子类所有的字段  这种功能可以在restApi 中自动扩充字段 但是不好的是代码看不懂，通过lombok生成的api实际字段不全
        // 这也是理赔中统一查询接口返回的不同业务类型 不同json串 的原理


    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Drink {
        private String color;
        private String volume;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class FruitJuice extends Drink {

        private String juiceNum;
        private String type;

    }
}
