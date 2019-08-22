package com.feiyang.interviewdemo.socket;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * @description: 单线程server socket 简单协议适用于单线程短链接，处理快无额外开销
 * 单线程模式就一个主线程，接受和处理都是在主线程中
 * @author: jhyang
 * @create: 2019-04-04 16:25
 **/
public class SingleThreadServer {

    public final static int PORT = 5555;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            //一直轮询
            while (true) {
                //accept在没有接受到会阻塞主线程
                try (Socket socket = server.accept()) {
                    System.out.println("接收到请求" + new Date().toString() + "\r\n");
                    Writer out = new OutputStreamWriter(socket.getOutputStream(), "ASCII");
                    //处理请求所需时间
                    Thread.sleep(3*1000);
                    Date now = new Date();
                    out.write(now.toString() + "\r\n");
                    out.flush();
                    out.close();
                } catch (IOException ex) {

                }

            }

        } catch (Exception e) {

        }
    }


}
