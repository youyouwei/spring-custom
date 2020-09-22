package com.demo.interviewdemo.resourceLoadDemo;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 11:38 2020/9/15
 */
public class ResourceLoadDemo {


    public static void main(String[] args) {

        System.out.println(ClassLoader.getSystemResource(""));

        readResourceUrl();

        resourceLoadByClassLoader();

    }

    /**
     * 读取资源文件路径
     * 在本地工程和服务器中读取文件路径有所不同
     * JavaWeb项目部署服务器中，会将项目打包成Jar包或者war包，此时就不会存在 src/main/resources 目录，JVM会在编译项目时，主动将 java文件编译成 class文件 和 resources 下的静态文件放在 target/classes目录下；
     *
     * 　当工程部署到Tomcat中时，按照上边方式，则会抛出异常：FileNotFoundException。原因：Java工程打包部署到Tomcat中时，properties的路径变到顶层（classes下），这是由Maven工程结构决定的。由Maven构建的web工程，主代码放在src/main/java路径下，资源放在src/main/resources路径下，当构建jar包 或 war包时，JVM虚拟机会自动编译java文件为class文件存放在 target/classes目录下，resource资源下的文件会原封不动的拷贝一份到 target/classes 目录下
     */
    private static void readResourceUrl() {



    }

    /**
     * ClassLoader加载包内资源
     * ClassLoader可以把jar包、war包内的class文件加载到JVM中，也可以读取包内的资源文件，并加载到jvm内存。
     *
     * ClassLoader可以把包（jar包，war包）内的class文件加载到JVM中，第一步就是将class文件以stream的方式读取出来。ClassLoader也将这个加载资源的方法getResourceAsStream暴露了出来。编程时可以使用这个方法来加载包内的任何资源，比如properties文件，图片等。
     */
    private static void resourceLoadByClassLoader() {






    }

}
