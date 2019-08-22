package com.feiyang.interviewdemo.httpAndHttpsAPIDemo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description: http client demo
 * @author: jhyang
 * @create: 2019-08-15 14:22
 **/
public class HttpClientDemo {
    public static void main(String[] args) {
        try(CloseableHttpClient httpClient = HttpClients.createDefault()) {
            //创建httpGet
            HttpGet httpGet = new HttpGet("http://www.baidu.com");
            System.out.println("executing request " + httpGet.getURI());
            //执行get请求

            try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
                HttpEntity entity = response.getEntity();
                System.out.println(response.getStatusLine());
                if (entity != null) {
                    // 打印响应内容长度
                    System.out.println("Response content length: " + entity.getContentLength());
                    // 打印响应内容
                    System.out.println("Response content: " + EntityUtils.toString(entity));
                }
            }

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String httpPost(String host, int port, byte[] buf) {
        StringBuffer stringBuffer = new StringBuffer();
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {

            String url = "http://" + host + ":" + port;
            HttpPost httpPost = new HttpPost(url);
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(6000).setConnectTimeout(6000).build();

            httpPost.setConfig(requestConfig);
            httpPost.addHeader("User-Agent", "Mozilla/5.0");

            ByteArrayEntity entity = new ByteArrayEntity(buf);
            httpPost.setEntity(entity);

            try (CloseableHttpResponse response = httpClient.execute(httpPost); BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()))) {
                String inputLine;
                while ((inputLine = reader.readLine()) != null) {
                    stringBuffer.append(inputLine);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuffer.toString();
    }

}
