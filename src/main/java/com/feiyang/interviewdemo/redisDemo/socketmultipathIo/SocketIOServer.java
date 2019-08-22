package com.feiyang.interviewdemo.redisDemo.socketmultipathIo;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description:  redis io 使用多路复用原理
 * @author: jhyang
 * @create: 2019-04-21 17:32
 **/
public class SocketIOServer {

    private static final int PORT = 8089;

    //private static final String HOST = "127.0.0.1";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);

        int point = 0;

        while (true) {
            Socket socket = server.accept();
            System.out.println("客户端连入");
            Writer out = new OutputStreamWriter(socket.getOutputStream());
            out.write("client " + point++);
            out.flush();
            out.close();

        }


    }

}
