package com.demo.interviewdemo.factoryBean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-05-30 10:17
 **/
@Component
public class DemoServiceProxy implements FactoryBean<DemoService> {


    @Autowired
    private DemoServiceImpl demoService;

    @Override
    public DemoService getObject() throws Exception {
        return (DemoService) Proxy.newProxyInstance(demoService.getClass().getClassLoader(), demoService.getClass().getInterfaces(), new DemoServiceHandler(demoService));
    }

    @Override
    public Class<?> getObjectType() {
        return DemoServiceImpl.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public static void main(String[] args) {
        DemoServiceImpl demoService = new DemoServiceImpl();
        DemoService demoServiceProxy = (DemoService) Proxy.newProxyInstance(demoService.getClass().getClassLoader(), demoService.getClass().getInterfaces(), new DemoServiceHandler(demoService));
        demoServiceProxy.doST();




    }

    static class DemoServiceHandler implements InvocationHandler {

        private DemoServiceImpl object;
        public DemoServiceHandler() {

        }

        public DemoServiceHandler(DemoServiceImpl object) {
            this.object = object;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("before invoke...");
            Object invoke = method.invoke(object, args);
            System.out.println("after invoke...");
            return invoke;
        }
    }


}
