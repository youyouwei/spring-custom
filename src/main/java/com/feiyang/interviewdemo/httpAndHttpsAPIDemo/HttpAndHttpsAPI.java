package com.feiyang.interviewdemo.httpAndHttpsAPIDemo;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Map;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-04-25 15:16
 **/
public class HttpAndHttpsAPI {

    public static void main(String[] args) {

        try {
            //System.out.println(post("http://www.baidu.com", null));

            System.out.println(post("https://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=17760765541", null));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String post(String path, Map<String, String> parameters) throws IOException {
        String resStr = "";
        URL url = new URL(path);
        if (parameters != null) {
            url = new URL(url.toString() + buildGetParameterString(parameters));
        }
        InputStream inputStream = url.openStream();
        StringBuilder apiResponse = new StringBuilder();

        byte[] bytes = new byte[1000];
        while (inputStream.read(bytes)!=-1) {
            apiResponse.append(new String(bytes));
        }

        //字节转字符 汉字会出现乱码
        //int nextByteOfData = 0;
        //while ((nextByteOfData = inputStream.read()) != -1) {
        //    apiResponse.append((char) nextByteOfData);
        //}

        resStr = apiResponse.toString();
        return resStr;
    }

    private static String buildGetParameterString(Map<String, String> parameters) {
        String getParameterString = "";
        for (Map.Entry<String, String> param : parameters.entrySet()) {
            if (param.getValue() == null) {
                continue;
            }
            getParameterString += (getParameterString.length() < 1) ? "?" : "&";
            getParameterString += param.getKey() + "=" + param.getValue();
        }
        return getParameterString;
    }


}
