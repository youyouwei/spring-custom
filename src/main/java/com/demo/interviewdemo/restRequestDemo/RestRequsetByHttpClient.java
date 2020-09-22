package com.demo.interviewdemo.restRequestDemo;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Description:  httpClient 完成 rest 请求
 * @Author: jiahuiyang
 * @Date: Created in 17:04 2019/11/13
 */
public class RestRequsetByHttpClient {
    public static void main(String[] args) throws IOException {

        httpClientMethod();


    }

    /**
     * 使用okhttp3 http请求
     */
    public static void httpClientMethod() throws IOException {
        OkHttpClient httpClient = new OkHttpClient();

        // 自定义httpClient参数 如链接超时时长
        httpClient = httpClient.newBuilder().connectTimeout(3000L, TimeUnit.MILLISECONDS).build();

        httpClient = new OkHttpClient.Builder().build();

        Request request = new Request.Builder()
                .url("https://www.google.com")
                .get()
                .build();
        Call call = httpClient.newCall(request);

        //超时时间默认是10000 ms
        try (Response response = call.execute();) {

            System.out.println(response);

        }





    }
}
