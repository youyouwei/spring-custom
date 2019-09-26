package com.feiyang.interviewdemo.url;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 10:17 2019/9/18
 */
public class UrlEncodeDemo {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String encode = URLEncoder.encode("@", "GBK");

        System.out.println(encode);


        String decode = URLDecoder.decode(encode, "GBK");
        System.out.println(decode);

    }



}
