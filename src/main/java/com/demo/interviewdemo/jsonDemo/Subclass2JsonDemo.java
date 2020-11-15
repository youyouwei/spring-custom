package com.demo.interviewdemo.jsonDemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

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


        method1(FruitJuice.class);

    }

    /**
     * 反序列化  子类的json字符串转父类
     */
    @SuppressWarnings("unchecked")
    public static <T extends Drink> void method1(Class<T> tClass) {
        String json = " ";
        T t = (T) JSON.parseObject("{\"color\":\"red\",\"juiceNum\":\"10\",\"type\":\"big\",\"volume\":\"200\"}", tClass);


        System.out.println(JSON.toJSONString(t));
    }


    /**
     * 根据父类接受json 串，进行反序列化，然后再转成子类
     */
    public static void method2(Drink drink, String type) {



    }




    /**
     * 序列化 中 子类转成父类后，序列化后还是显示所有子类字段和值
     */
    public void method() {
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



    static class Drink {
        private String color;
        private String volume;

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getVolume() {
            return volume;
        }

        public void setVolume(String volume) {
            this.volume = volume;
        }
    }


    static class FruitJuice extends Drink {

        private String juiceNum;
        private String type;

        public String getJuiceNum() {
            return juiceNum;
        }

        public void setJuiceNum(String juiceNum) {
            this.juiceNum = juiceNum;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}


interface Person {
    void drink(Subclass2JsonDemo.Drink drink);

}

class Child implements Person {

    /**
     * 参数子类代替父类不能算重写
     * @param drink
     */
    public void drink(Subclass2JsonDemo.FruitJuice drink) {

    }

    @Override
    public void drink(Subclass2JsonDemo.Drink drink) {

    }
}
