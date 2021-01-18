package com.demo.interviewdemo.byteClassModify.javassist;

import javassist.*;

import java.io.IOException;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 8:31 2021/1/4
 */
public class GeneratorClass {

    public static void main(String[] args) throws CannotCompileException, IOException {
        ClassPool pool = ClassPool.getDefault();
        //创建Programmer类
        CtClass cc= pool.makeClass("com.samples.Programmer");
        //定义code方法
        CtMethod method = CtNewMethod.make("public void code(){}", cc);
        //插入方法代码
        method.insertBefore("System.out.println(\"I'm a Programmer,Just Coding.....\");");
        cc.addMethod(method);
        //保存生成的字节码
        cc.writeFile("d://tmp");

    }
}
