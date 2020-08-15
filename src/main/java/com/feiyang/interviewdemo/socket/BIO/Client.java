package com.feiyang.interviewdemo.socket.BIO;

import com.feiyang.interviewdemo.thread.Run;

import javax.sql.PooledConnection;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.Socket;

/**
 * @description: 客户端请求
 * @author: jhyang
 * @create: 2019-04-04 16:49
 **/
public class Client {

    public final static String HOST = "localhost";
    public final static int PORT = 5555;

    public static void main(String[] args) throws IOException {

        while (true) {
            Socket socket = new Socket(HOST, PORT);
            Thread thread = new TimeThread(socket);
            thread.start();
        }


    }

    private static class TimeThread extends Thread {

        private Socket socket;

        public TimeThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {

            try (Socket client = this.socket) {
                Reader in = new InputStreamReader(socket.getInputStream());
                int c;
                StringBuilder builder = new StringBuilder();
                while ((c = in.read()) != -1) {
                    builder.append((char) c);
                }
                System.out.println(builder.toString());
                in.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }

}
