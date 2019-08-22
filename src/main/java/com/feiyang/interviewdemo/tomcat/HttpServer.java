package com.feiyang.interviewdemo.tomcat;

import javax.naming.ldap.SortKey;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @description: tomcat核心处理类，用于接受用户请求，传递http请求信息，关闭容器
 * @author: jhyang
 * @create: 2019-04-04 14:43
 **/
public class HttpServer {
    private boolean shutDown = false;

    public void acceptWait() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8080, 1, InetAddress.getByName("127.0.0.1"));
        } catch (UnknownHostException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        while (!shutDown) {
            try {
                Socket socket = serverSocket.accept();
                InputStream is = socket.getInputStream();
                OutputStream os = socket.getOutputStream();

                Request request = new Request(is);
                request.parse();

                Response response = new Response(os);
                response.setRequest(request);
                response.sendStaticResource();
                socket.close();
                if (null != request) {
                    shutDown = request.getUrl().equals("/shutdown");
                }
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    public static void main(String[] args) {
        HttpServer server = new HttpServer();
        server.acceptWait();
    }

}
