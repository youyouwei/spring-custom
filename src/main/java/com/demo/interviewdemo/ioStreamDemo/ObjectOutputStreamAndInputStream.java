package com.demo.interviewdemo.ioStreamDemo;

import java.io.*;
import java.text.MessageFormat;

/**
 * @description: 对象序列化和反序列化
 * @author: jhyang
 * @create: 2019-08-12 15:42
 **/
public class ObjectOutputStreamAndInputStream {

    public static void main(String[] args) throws Exception {
        //序列化 并把对象存储固定文件中
        serializePerson();
        //反序列化 把固定文件中的序列化对象反序列化出来
        Person p = deserializePerson();
        System.out.println(MessageFormat.format("name={0},age={1},sex={2}", p.getName(), p.getAge(), p.getSex()));
    }

    private static void serializePerson() throws IOException {
        Person person = new Person();
        person.setAge(20);
        person.setName("gg");
        person.setSex("男");

        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(new File("c:/1.txt")));

        oo.writeObject(person);
        System.out.println("Person对象序列化成功！");
        oo.close();
    }

    private static Person deserializePerson() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("c:/1.txt")));
        Person person = (Person) ois.readObject();
        System.out.println("person对象反序列化成功！");
        return person;
    }

}
