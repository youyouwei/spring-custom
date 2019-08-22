package com.feiyang.interviewdemo.codingDemo;

import org.springframework.util.StringUtils;

/**
 * @description: 手写字符串中子串查找
 * @author: jhyang
 * @create: 2019-08-22 15:24
 **/
public class SubStringIndexOfDemo {

    public static void main(String[] args) {
        String name = "name";
        System.out.println(name.indexOf("s"));

        int index = indexOfByString("jiahuiyang", "jaxk");
        System.out.println(index);

    }

    /**
     * 子字符串查找
     * @param str
     * @param subStr
     * @return
     */
    public static int indexOfByString(String str, String subStr) {

        if (str == null || subStr == null) {
            return -1;
        }
        // 可以判断空字符情况
        if (str == "" && subStr == "") {
            return 0;
        }

        char[] chars = str.toCharArray();
        char[] subChars = subStr.toCharArray();

        for (int i = 0; i < chars.length - subChars.length ; i++) {

            boolean flag = true;
            int x = i;
            for (int j = 0; j < subChars.length; j++) {
                if (chars[x] != subChars[j]) {
                    flag = false;
                }
                x++;
            }

            if (flag) {
                return i;
            }
        }

        return -1;

    }

}
