package com.demo.interviewdemo.socket.BIO;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: 固定数量线程池服务方式
 * @author: jhyang
 * @create: 2019-04-04 16:41
 **/
public class FixedPoolServer {
    public final static int PORT = 5555;

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(50);
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                try {
                    Socket client = server.accept();
                    Callable<Void> task = new TimeThread(client);
                    pool.submit(task);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class TimeThread implements Callable<Void> {

        private Socket client;

        public TimeThread(Socket client) {
            this.client = client;
        }

        @Override
        public Void call() throws Exception {
            try {
                Writer out = new OutputStreamWriter(client.getOutputStream());
                Date now = new Date();
                Thread.sleep(10*1000);
                out.write(now.toString() + "\r\n");
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    client.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            return null;
        }
    }
}
