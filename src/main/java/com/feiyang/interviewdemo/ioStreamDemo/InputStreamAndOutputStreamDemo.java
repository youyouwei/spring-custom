package com.feiyang.interviewdemo.ioStreamDemo;

import java.io.*;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-04-25 15:57
 **/
public class InputStreamAndOutputStreamDemo {
    public static void main(String[] args) throws IOException, InterruptedException {

        //String file = "C:\\test\\test.txt";
        //String outFile = "C:\\test\\outFile.txt";
        //
        //readFileByBytes(file, file);

        //readByData();
        // readAndWrite();


    }

    /**
     * byte io stream
     * ByteArrayInputStream ByteArrayOutputStream
     * @throws IOException
     */
    static void readByBytes() throws IOException {
        InputStream in = null;
        OutputStream out = new ByteArrayOutputStream();
        byte[] bytes = new byte[1000];
        in = new ByteArrayInputStream("ByteArrayInputStream".getBytes());
        int byteRead = 0;
        while ((byteRead = in.read(bytes)) != -1) {
            System.out.println(new String(bytes));

            out.write(bytes, 0, byteRead);

        }
        //out 内容输出
        System.out.println("-------------------");
        System.out.println(out.toString());
        //清空缓存区
        out.flush();
        out.close();
        in.close();

    }

    /**
     * file io stream
     * FileInputStream OutputStream
     * @param inFile
     * @param outFile
     * @throws IOException
     */
    static void readFileByBytes(String inFile, String outFile) throws IOException, InterruptedException {
        try (InputStream in = new FileInputStream(inFile); OutputStream out = new FileOutputStream(outFile,true)) {
            byte[] tempBytes = new byte[1000];
            int byteRead = 0;
            if (!inFile.equals(outFile)) {
                while ((byteRead = in.read(tempBytes)) != -1) {
                    out.write(tempBytes, 0, byteRead);
                }
            } else {
                //如果in 和 out file 一样会出现无限复制，应为每次读的时候会重新查看文件的内容并且，所以会造成不断的写不断的读
                while ((byteRead = in.read(tempBytes)) != -1) {
                    //如果没有线程睡眠的控制，会导致文件急剧增大，导致磁盘崩溃
                    Thread.sleep(1 * 1000);
                    out.write(tempBytes, 0, byteRead);
                }
            }
        }
    }

    /**
     * data stream 数据类型处理
     * @throws IOException
     */
    static void readByData() throws IOException {
        DataInputStream in = new DataInputStream(new ByteArrayInputStream("DataInputStream".getBytes()));

        //if (in.available() > 0) {
        //    String s = in.readUTF();
        //    System.out.println(s);
        //}

        StringBuilder sb = new StringBuilder();
        String readStr;
        while ((readStr = in.readLine()) != null) {
            sb.append(readStr);
        }
        System.out.println(sb);
        in.close();
    }

    /**
     * buffer stream 字节流
     * @throws IOException
     */
    static void readAndWriteByBuffer() throws IOException {

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:\\test\\test.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("C:\\test\\outFile.txt",true));

        byte[] b = new byte[1024];
        int len = 0;
        while (-1 != (len = bis.read(b, 0, b.length))) {
            bos.write(b, 0, len);
        }

        bos.close();
        bis.close();


    }

    /**
     * 字节流转字符流
     * @param fileName
     */
    static void readFileByteToChars(String fileName) {

        File file = new File(fileName);
        Reader reader = null;
        System.out.println("以字母为单位读取文件内容，一次读一个");
    }


}
