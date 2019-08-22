package com.feiyang.interviewdemo.redisDemo.socketmultipathIo;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.Socket;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-04-21 17:32
 **/
public class SocketIOClient {

    private static final int PORT = 8089;

    private static final String HOST = "127.0.0.1";

    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new SocketClientThread(new Socket(HOST, PORT)));
            thread.start();
        }

    }


    public static class SocketClientThread implements Runnable {

        private Socket client;

        public SocketClientThread(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try(Reader in = new InputStreamReader(client.getInputStream());) {
                //表示io处理时间
                Thread.sleep(3 * 1000);
                char[] chars = new char[1000];
                in.read(chars);
                System.out.println(chars);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


}
