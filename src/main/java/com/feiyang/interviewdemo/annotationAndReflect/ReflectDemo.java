package com.feiyang.interviewdemo.annotationAndReflect;

import com.feiyang.interviewdemo.annotationAndReflect.fruitDemo.Apple;
import com.feiyang.interviewdemo.annotationAndReflect.fruitDemo.FruitColor;
import com.feiyang.interviewdemo.annotationAndReflect.fruitDemo.FruitName;
import com.feiyang.interviewdemo.annotationAndReflect.fruitDemo.FruitProvider;

import java.lang.reflect.Field;

/**
 * @description: 通过反射处理注解
 * @author: jhyang
 * @create: 2019-04-22 11:38
 **/
public class ReflectDemo {

    public static void main(String[] args) {

        getFruitInfo(Apple.class);

    }

    /**
     * 获取水果信息
     * @param clazz
     */
    public static void getFruitInfo(Class<?> clazz) {
        String strFruitName;
        String strFruitColor;
        String strFruitProvider;

        //获取该类对象包含的所有属性对象
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            //设置私有成员的可访问性 可以获取实例中的私有成员的值
            field.setAccessible(true);
            System.out.println("字段名称：" + field.getName());

            if (field.isAnnotationPresent(FruitName.class)) {
                FruitName fruitName = field.getAnnotation(FruitName.class);
                strFruitName = "水果名称：" + fruitName.value();
                System.out.println(strFruitName);
            } else if (field.isAnnotationPresent(FruitColor.class)) {
                FruitColor fruitColor = field.getAnnotation(FruitColor.class);
                strFruitColor = "水果颜色：" + fruitColor.fruitColor().toString();
                System.out.println(strFruitColor);
            } else if (field.isAnnotationPresent(FruitProvider.class)) {
                FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
                strFruitProvider = "供应商编号：" + fruitProvider.id() + "\n供应商名称：" + fruitProvider.name() + "\n供应商地址：" + fruitProvider.address();
                System.out.println(strFruitProvider);
            }
        }
    }


}
