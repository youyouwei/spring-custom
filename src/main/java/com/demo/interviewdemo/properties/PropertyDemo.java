package com.demo.interviewdemo.properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @Description: Property 配置文件操作
 * @Author: jiahuiyang
 * @Date: Created in 18:52 2020/9/10
 */
public class PropertyDemo {


    public static void main(String[] args) {
        method();
    }

    public static void method() {

//        File file = new File("D:\\code\\spring-custom\\src\\main\\resources\\app.properties");
        File file = new File(" src//main//resources//app.properties");

//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");

        try( FileInputStream inputStream = new FileInputStream(file);) {
            Properties properties = new Properties();
            properties.load(inputStream);
            properties.list(System.out);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }


    }




}
