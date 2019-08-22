package com.feiyang.interviewdemo.multiThreadDemo;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @description:
 * 多线程之间的管道输出
 * @author: jhyang
 * @create: 2019-06-27 15:37
 **/
public class Piped {

    public static void main(String[] args) throws IOException {
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();

        //将输入流和输出流进行连接，否则在使用时会抛出IOException

        out.connect(in);
        Thread printThread = new Thread(new Print(in),"PrintThread");
        printThread.start();
        int receive = 0;
        try {
            //按 ctrl+d 结束输入
            while ((receive = System.in.read()) != -1) {
                //写的线程
                out.write(receive);
            }
        }finally {
            out.close();
        }


    }

    static class Print implements Runnable {
        private PipedReader in;

        public Print(PipedReader in) {
            this.in = in;
        }
        @Override
        public void run() {
            int receive = 0;
            try {
                //接收的线程
                while ((receive = in.read()) != -1) {
                    System.out.print((char) receive);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }


}
