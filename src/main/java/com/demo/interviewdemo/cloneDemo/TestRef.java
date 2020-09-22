package com.demo.interviewdemo.cloneDemo;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-08-12 10:59
 **/
public class TestRef {
    public static void main(String[] args) throws CloneNotSupportedException {
        //Obj a = new Obj();
        //Obj b = (Obj) a.clone();
        //b.changeDate();
        ////判断克隆的对象是否影响被克隆的对象  存在引用成员并且不影响 深克隆
        //System.out.println(a.getBirth());
        //System.out.println(b.getBirth());

        ObjShallowClone c = new ObjShallowClone(10, "tom");
        ObjShallowClone d = (ObjShallowClone) c.clone();

        d.setAge(11);
        d.setName("jack");

        System.out.println(c);
        System.out.println(d);

    }
}
