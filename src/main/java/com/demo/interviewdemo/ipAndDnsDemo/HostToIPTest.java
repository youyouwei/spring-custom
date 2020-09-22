package com.demo.interviewdemo.ipAndDnsDemo;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @description: 域名转ip
 * @author: jhyang
 * @create: 2019-04-26 15:42
 **/
public class HostToIPTest {
    public static void main(String[] args) throws UnknownHostException {
        //获取本地IP地址
        System.out.println(InetAddress.getLocalHost().getHostAddress());
        //获取www.baidu.com的地址
        System.out.println(InetAddress.getByName("www.baidu.com"));
        //获取www.baidu.com的真实IP地址
        System.out.println(InetAddress.getByName("www.baidu.com").getHostAddress());
        //获取配置在HOST中的域名IP地址  没有配置的话会报错
        System.out.println(InetAddress.getByName("TEST").getHostAddress());
    }

}
