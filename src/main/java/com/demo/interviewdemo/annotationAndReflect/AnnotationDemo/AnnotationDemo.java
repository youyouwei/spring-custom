package com.demo.interviewdemo.annotationAndReflect.AnnotationDemo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @Description: java注解 可以通过反射获取类、属性、方法等修饰的注解
 * 反射获取的class method 等都实现 AnnotatedElement 元素
 *
 * @Author: jiahuiyang
 * @Date: Created in 16:25 2019/11/11
 */
@Data
@Component
public class AnnotationDemo {
    public static void main(String[] args) {
        Class c = AnnotationDemo.class;
        // getDeclaredAnnotations 只是获取生效期在运行期的注解
        Annotation[] annotations = c.getDeclaredAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation.toString());
        }

        Field[] fields = c.getFields();
        for (Field field : fields) {
            Annotation[] annotations1 = field.getDeclaredAnnotations();
            Annotation[] annotations2 = field.getAnnotations();
            for (Annotation annotation : annotations1) {
                System.out.println(annotation.toString());
            }
            for (Annotation annotation : annotations2) {
                System.out.println(annotation.toString());
            }
        }

    }

    @Override
    public String toString() {
        return "annotation demo";
    }
}
