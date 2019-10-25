package com.feiyang.interviewdemo.stringOperDemo;

/**
 * @Description: 字符串截取
 * @Author: jiahuiyang
 * @Date: Created in 10:56 2019/10/23
 */
public class SubstringDemo {

    public static void main(String[] args) {



    }

    public static String getColor(String color) {
        if (color == null || "".equals(color.trim()))
            return "";

        else if (color.startsWith("#")) {
            int r = tranHex(color.substring(1, 3));
            int g = tranHex(color.substring(3, 5));
            int b = tranHex(color.substring(5, 7));
            return "";
        }

        return "";

    }

    private static int tranHex(String hex)
    {
        int[] r1 = new int[2];
        for (int i=0;i<2;i++)
        {
            char c1 = hex.charAt(i);
            if (c1 >= '0' && c1 <= '9')
                r1[i] = c1 - '0';
            else if (c1 >= 'A' && c1 <= 'F')
                r1[i] = c1 - 'A' + 10;
            else if (c1 >= 'a' && c1 <= 'f')
                r1[i] = c1 - 'a' + 10;
        }

        return r1[0] * 16 + r1[1];
    }

}
