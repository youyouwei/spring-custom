package com.feiyang.interviewdemo.dynamicproxy;

import com.sun.javafx.iio.gif.GIFImageLoader2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.rmi.server.RemoteObjectInvocationHandler;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @description: 使用类
 * @author: jhyang
 * @create: 2019-04-04 09:42
 **/
public class GirlDate {

    public static void main(String[] args) {

        // 在调用测试代理方法前加（此方法通知虚拟保存产生的代理文件），运行后会在项目的根目录下生成class文件

        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

       /* //约会
        //创建代理中介类，并传入实际类
        BeautyWangProxy proxy = new BeautyWangProxy(new BeautyWang());

        System.getProperties().put("sun.misc.ProxyGeneratedFiles", "true");

        //通过动态代理获取对象  使用被代理对象实现接口进行实际调用处理
//        Girl girl = (Girl) Proxy.newProxyInstance(Girl.class.getClassLoader(), new Class[]{Girl.class}, proxy);
        Girl girl = (Girl) proxy.wrap(new BeautyWang());

        girl.eat();
        System.out.println("-------------------------------------");
        girl.watchMovie();*/

//        date(new BeautyWang());

        Girl girl = getObjectProxy(BeautyWang.class);

        girl.eat();
//        girl.watchMovie();

//        System.out.println(Girl.class.getMethods()[0].getName());

//        Girl girl = getObjectMethodProxy(BeautyWang.class, new String[]{"eat"});
//
//        girl.eat();
//        girl.watchMovie();

    }


    public static void date(Girl girl) {

        Girl girlProxy = (Girl) new BeautyWangProxy().wrap(girl);

        girlProxy.eat();
        System.out.println("----------------------------------");
        girlProxy.watchMovie();
    }


    /**
     * 通过 Class 获取代理对象，模拟Spring 容器和Spring 通过JDK动态代理实现切面AOP
     * 验证一个道理 想要通过动态代理实现AOP，必须要通过容器化来控制代理类的生成
     * 也可以通过传入method Name来定位某个方法的额外处理，其他方法维持原样
     * @param cl
     * @return
     */
    public static <T> T getObjectProxy(Class<? extends T> cl) {

        /**
         * 方法中的内部类必须在 调用之前定义
         * 由于方法内部类不能在该方法以外的地方使用，因此方法内部类不能使用访问控制符和 static 修饰符。
         */
        class ObjectInvocationHandler implements InvocationHandler {

            Object object;

            public ObjectInvocationHandler() { }

            public Object wrap(Object object) {
                this.object = object;
                return Proxy.newProxyInstance(cl.getClassLoader(), cl.getInterfaces(), this);
            }


            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //在debug模式下 只调用一个方法时也会 触发invoke方法中的内容重复执行。

                System.out.println("before do something........");

                Object obj = method.invoke(object, args);

                System.out.println("after do something.........");

                return obj;
            }

        }

        try {
            return (T) new ObjectInvocationHandler().wrap(cl.newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }


    /**
     * 通过 Class 获取代理对象，模拟Spring 容器和Spring 通过JDK动态代理实现切面AOP
     * 验证一个道理 想要通过动态代理实现AOP，必须要通过容器化来控制代理类的生成
     * 也可以通过传入method Name来定位某个方法的额外处理，其他方法维持原样 实际spring中是通过注解来处理的。
     *
     * @param cl
     * @return
     */
    public static <T> T getObjectMethodProxy(Class<? extends T> cl, String[] methodNames) {
        /**
         * 方法中的内部类必须在 调用之前定义
         * 由于方法内部类不能在该方法以外的地方使用，因此方法内部类不能使用访问控制符和 static 修饰符。
         */
        class ObjectInvocationHandler implements InvocationHandler {

            Object object;

            public ObjectInvocationHandler() {
            }

            public Object wrap(Object object) {
                this.object = object;
                return Proxy.newProxyInstance(cl.getClassLoader(), cl.getInterfaces(), this);
            }


            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (Arrays.asList(methodNames).contains(method.getName())) {

                    System.out.println("before do something........");

                    Object obj = method.invoke(object, args);

                    System.out.println("after do something.........");
                    return obj;
                } else {
                    Object obj = method.invoke(object, args);
                    return obj;
                }

            }

        }

        try {
            return (T) new ObjectInvocationHandler().wrap(cl.newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }



    public static void method() {

    }


}
