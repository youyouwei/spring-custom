package com.feiyang.interviewdemo.httpAndHttpsBySocket;


import org.springframework.util.StringUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description:  使用socket实现http
 * @author: jhyang
 * @create: 2019-04-26 11:44
 **/
public class HttpBySocket {
    public static void main(String[] args) {

        upgradeHttpServer();
    }

    /**
     * 简易版Http server更新
     */
    public static void simpleHttpServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(80);
            System.out.println("启动http默认端口80监听");
            Socket socket = serverSocket.accept();
            System.out.println("收到客户端信息，我要开始解析！");
            String line = "";
            InputStream in = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            while ((line = reader.readLine()) != null) {
                if (StringUtils.isEmpty(line)) {
                    System.out.println("接收完毕");
                } else {
                    System.out.println(line);
                }
            }
            reader.close();
            in.close();
            socket.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println("结束");
        }
    }

    /**
     * 升级版http server
     * 注：chrome访问http://127.0.0.1/html/index.html 会出现一次跳转 http://127.0.0.1/favicon.ico
     * 所以会出现两次请求
     */
    public static void upgradeHttpServer() {
        String baseUrl = "C:/";
        try {

            ServerSocket serverSocket = new ServerSocket(80);
            System.out.println("开启监听80");
            while (true) {

                Socket socket = serverSocket.accept();
                System.out.println("客户端连入");
                //获取访问的文件路径
                InputStream in = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                //在第一行获取访问文件路径
                String line = reader.readLine();
                String url = line.substring(5, line.indexOf("HTTP") - 1);

                //生成输出流
                FileInputStream fileInputStream = null;
                try {
                    fileInputStream = new FileInputStream(baseUrl + url);
                } catch (Exception e) {
                    fileInputStream = new FileInputStream("C:/html/error404.html");
                }

                OutputStream outputStream = socket.getOutputStream();
                byte[] buffer = new byte[4 * 1024];
                int len = 0;
                while ((len = fileInputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, len);
                }
                outputStream.flush();
                fileInputStream.close();
                in.close();
                outputStream.close();
                socket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println("结束");
        }

    }




}
