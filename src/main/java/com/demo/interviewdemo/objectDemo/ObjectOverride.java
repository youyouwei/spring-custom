package com.demo.interviewdemo.objectDemo;

/**
 * @description: 重写object 中的方法
 * @author: jhyang
 * @create: 2019-08-12 11:35
 **/
public class ObjectOverride implements Comparable<ObjectOverride> {

    private Long id;
    private Integer age;
    private String name;

    public ObjectOverride(Long id, Integer age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "[id=" + id + ",age=" + age + ",name=" + name + "]";
    }

    /**
     * 开始判断对象引用是否相等 对象是否为空 是否是同一类型
     * @param otherObject
     * @return
     */
    @Override
    public boolean equals(Object otherObject) {
        //对象引用相等
        if (this == otherObject) {
            return true;
        }
        //比较对象为空
        if (otherObject == null) {
            return false;
        }
        //不是同一类型
        if (getClass() != otherObject.getClass()) {
            return false;
        }
        ObjectOverride other = (ObjectOverride) otherObject;
        //定义实际相等的逻辑  必须年龄和名字相等才是 对象相等
        return age.equals(other.age) && name.equals(other.name);
    }

    /**
     * 计算hash code 如果是引用类型直接使用其hashcode
     * @return
     */
    @Override
    public int hashCode() {
        return 13 * age + 17 * name.hashCode();
    }

    @Override
    public int compareTo(ObjectOverride o) {
        return age - o.age;
    }


}
