package com.demo.interviewdemo.collectionOperDemo;

import lombok.*;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotNull;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * list 复制 分为浅复制（如果是引用类型，元素指向地址一样，即元素还是使用同一个对象）
 * 和深复制（引用类型元素指向新的地址，相当于新的对象）
 * @author: jhyang
 * @create: 2019-06-25 10:21
 **/
public class ListCopyDemo {

    static List<Person> srcList = new ArrayList<>();

    static {
        Person p1 = new Person(1,"tom","china");
        Person p2 = new Person(2,"jin","japan");
        Person p3 = new Person(3,"jack","england");
        srcList.add(p1);
        srcList.add(p2);
        srcList.add(p3);
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //shallowCopy();
        deepCopy();
    }


    /**
     * 浅复制
     */
    public static void shallowCopy() {
        //遍历循环复制
        List<Person> destList = new ArrayList<>(srcList.size());
        for (Person p : srcList) {
            //深复制
            //Person person = new Person();
            //BeanUtils.copyProperties(p, person);
            //destList.add(person);

            //浅复制
            destList.add(p);
        }

        destList.get(0).setAddress("chinese");

        System.out.println(srcList);
        System.out.println(destList);

        //使用list实现类的构造方法 也是浅复制
        destList = new ArrayList<>(srcList);

        //使用list.addAll() 也是浅复制
        destList.addAll(srcList);

    }

    /**
     * 深复制
     */
    public static void deepCopy() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(srcList);

        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        List<Person> destList = (List<Person>) in.readObject();

        destList.get(0).setAddress("chinese");
        System.out.println(srcList);
        System.out.println(destList);

    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Person implements Serializable {
        //直接使用jdk 序列化需要使用实现serializable 接口
        private static final long serialVersionUID = -2353531817768776222L;
        @NotNull
        private Integer id;
        private String name;
        private String address;
    }

}

