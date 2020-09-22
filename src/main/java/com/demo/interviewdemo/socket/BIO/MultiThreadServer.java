package com.demo.interviewdemo.socket.BIO;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * @description: 无限制数量多线程服务方式
 * 每个客户连接请求都生成一个处理线程，可以防止慢客户端阻塞所有其他客户端
 * 这种服务方式实现是不可能采用的，容易遭受DOS攻击
 * 多线程模式是接收在主线程，处理在多线程中，处理请求是异步的
 * 不会发生阻塞
 * @author: jhyang
 * @create: 2019-04-04 16:30
 **/
public class MultiThreadServer {
    public final static int PORT = 5555;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                try {
                    //socket 只能在处理线程中关闭，不能自动关闭，不然多线程异步执行额时候主线程会继续执行自动关闭资源
                    Socket socket = server.accept();
                    System.out.println("接收请求---"+new Date().toString()+"\r\n");
                    //每次跟客户端建立连接都会创建一个线程来处理
                    Thread task = new TimeThread(socket);
                    task.start();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static class TimeThread extends Thread {
        private Socket client;

        public TimeThread(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                Writer out = new OutputStreamWriter(client.getOutputStream());
                Thread.sleep(3*1000);
                Date now = new Date();
                out.write(now.toString() + "\r\n");
                out.flush();
                out.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
