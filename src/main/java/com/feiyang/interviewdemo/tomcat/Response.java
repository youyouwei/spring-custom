package com.feiyang.interviewdemo.tomcat;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @description: 响应请求读取文件并写回到浏览器
 * @author: jhyang
 * @create: 2019-04-04 14:43
 **/
public class Response {

    public static final int BUFFER_SIZE = 2048;

    private static final String WEB_ROOT = "C:";
    private Request request;
    private OutputStream outputStream;

    public Response(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public void sendStaticResource() throws IOException {
        byte[] bytes = new byte[BUFFER_SIZE];
        FileInputStream fis = null;
        try {
            File file = new File(WEB_ROOT, request.getUrl());
            if (file.exists() && !file.isDirectory()) {
                fis = new FileInputStream(file);
                int ch = fis.read(bytes, 0, BUFFER_SIZE);
                while (ch != -1) {
                    outputStream.write(bytes, 0, ch);
                    ch = fis.read(bytes, 0, BUFFER_SIZE);
                }
            } else {
                String retMessage = "<h1>" + file.getName() + " file or directory not exists</h1>";
                String returnMessage = "HTTP/1.1 404 File Not Found\r\n" +
                        "Content-Type: text/html\r\n" +
                        "Content-Length: " + retMessage.length() + "\r\n\r\n" + retMessage;
                outputStream.write(returnMessage.getBytes());
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }finally {
            if (fis != null) {
                fis.close();
            }
        }
    }


}
