package com.demo.interviewdemo.byteClassModify.javassist;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.util.HotSwapper;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 8:15 2021/1/4
 */
public class HelloModify {

    public static void run() {
        try {
            String className = Hello.class.getName();

            ClassPool cp = ClassPool.getDefault();
            CtClass cc = cp.get(className);
            CtMethod m = cc.getDeclaredMethod("say");

            m.setBody("{ System.out.println(\"Hello World\"); }");

//            HotSwapper swap = new HotSwapper(8000);
//            swap.reload(className, cc.toBytecode());
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(-1);

        }
    }
}
