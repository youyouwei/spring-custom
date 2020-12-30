package com.demo.interviewdemo.springDemo.annotationContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @description:  Java配置使用注解@ComponentScan，默认扫描本包路径下的所有注解bean
 * proxyTargetClass如果设置true默认false，所有需要代理的bean（如被切面）都是通过cglib代理生成
 * @author: jhyang
 * @create: 2019-04-17 14:07
 **/
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = false)
@ComponentScan
public class ServiceConfig {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ServiceConfig.class);
        DemoService service = context.getBean(DemoService.class);
        service.method();
//        GoodsService goodsService = context.getBean(GoodsService.class);
//        goodsService.sell();


        PrototypeBean prototypeBean = context.getBean(PrototypeBean.class);

        PrototypeBean prototypeBean1 = context.getBean(PrototypeBean.class);



    }


}
