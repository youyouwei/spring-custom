package com.feiyang.interviewdemo.tomcat;

import java.io.IOException;
import java.io.InputStream;

/**
 * @description: 获取http的请求头所有信息并截取url地址返回
 * @author: jhyang
 * @create: 2019-04-04 14:43
 **/
public class Request {

    private InputStream is;
    private String url;

    public Request(InputStream inputStream) {
        this.is = inputStream;
    }

    public void parse() {
        StringBuffer requst = new StringBuffer(Response.BUFFER_SIZE);
        int i;
        byte[] buffer = new byte[Response.BUFFER_SIZE];
        try {
            i = is.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
            i = -1;
        }
        for (int j = 0; j < i; j++) {
            requst.append((char) buffer[j]);
        }
        System.out.println(requst.toString());

    }

    private String parseUrl(String requestString) {
        int index1, index2;
        index1 = requestString.indexOf(' ');
        if (index1 != -1) {
            index2 = requestString.indexOf(' ', index1 + 1);
            if (index2 > index1) {
                return requestString.substring(index1 + 1, index2);
            }
        }
        return null;
    }

    public String getUrl() {
        return url;
    }

}
