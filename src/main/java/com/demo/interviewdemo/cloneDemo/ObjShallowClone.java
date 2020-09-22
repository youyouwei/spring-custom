package com.demo.interviewdemo.cloneDemo;

/**
 * @description:
 * 类中只包含 基本类型成员
 * @author: jhyang
 * @create: 2019-08-12 11:03
 **/
public class ObjShallowClone implements Cloneable {

    int age;
    String name;

    public ObjShallowClone(int age, String name) {
        this.age = age;
        this.name = name;
    }

    /**
     * 克隆类全是基本类型成员 无引用类型成员 可以直接调用 super.clone()
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "[age=" + age + ",name=" + name + "]";
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
