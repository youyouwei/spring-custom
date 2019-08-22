package com.feiyang.interviewdemo.number;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description: 测试浮点数的精度
 * @author: jhyang
 * @create: 2019-04-03 10:15
 **/
public class DoubleTest {

    public static void main(String[] args) {
        //浮点型数据会丢失数据精度，不能用于计算，特别是金额相关的计算，浮点型计算的原理是通过二进制来处理，会出现除不尽的现象
        System.out.println(0.05);
        System.out.println(0.05 + 0.01);
        //如果只是toString输出不会出现精度缺失
        System.out.println(0.06);

        System.out.println(1.0 - 0.42);
        System.out.println(4.015 * 100);
        System.out.println(123.3 / 100);
        System.out.println(-1.0 / 0.0);

        //这种没有计算结果的值不是一个数字，note a number；但是能够预知结果的不是NaN，如无限大值 1.0/0.0
        Double nan = 0.0 / 0.0;
        System.out.println(nan.isNaN());


        //BigDecimal
        BigDecimal bigDecimal = new BigDecimal("0.05");

        System.out.println(bigDecimal.add(new BigDecimal("0.01")));

        System.out.println(bigDecimal.add(BigDecimal.valueOf(0.01)));


        //如果使用 浮点型传参初始化 会造成精度对丢失的情况；使用string传参可以解决
        System.out.println(new BigDecimal(12.35).setScale(1,BigDecimal.ROUND_HALF_UP));
        System.out.println(new BigDecimal("12.35").setScale(1,BigDecimal.ROUND_HALF_UP));

        System.out.println(new BigDecimal("0.01").equals(new BigDecimal("0.01")));
        //字符串数字如果数值相等但是表示不同 使用BigDecimal的equals方法是false；可以使用compareTo来比较避免这个问题
        System.out.println(new BigDecimal("0.01").equals(new BigDecimal("0.010")));
        System.out.println(new BigDecimal("0.01").compareTo(new BigDecimal("0.010"))==0);

        //new BigDecimal("o,1");
        System.out.println(isNumeric("0.1"));
        System.out.println(isNumeric("1.2E2"));

        //BigDecimal可以使用科学计数法
        System.out.println(new BigDecimal("1.2E2"));
        System.out.println(new BigDecimal("1.2E2").intValue());

        //BigDecimal直接转int，直接取整数位不提供四舍五入
        System.out.println(new BigDecimal(1.4).intValue());
        System.out.println(new BigDecimal(1.5).intValue());

        //BigDecimal 对精度的解决方案是，不使用二进制，而是使用十进制(BigInteger)+小数点位置(scale)来表示小数
        //计算如：X*0.1n0.1n + Y*0.1m0.1m == X*0.1n0.1n + (Y*0.1m−n0.1m−n) * 0.1n0.1n == (X+Y*0.1m−n0.1m−n) * 0.1n0.1n，其中n>m
        //所以BigDecimal 是使用BigInteger作为基础来进行精度运算的
        BigDecimal bd = new BigDecimal("100.001");
        System.out.println(bd.scale());
        System.out.println(bd.unscaledValue());

        //BigInteger 的无限精度是如何保证的 是通过数组来表示，数组的长度可以无限
        //通过byte[]来当作底层的二进制表示，[2, 1]，也就是[00000010B, 00000001B]，就是表示二进制的10 00000001B这个数，也就是513了
        byte[] mag = {2, 1};
        System.out.println(new BigInteger(mag));












    }

    /**
     * 只能判断纯数字，不能判断其他格式数据如小数、负数等
     * @param str
     * @return
     */
    public static boolean isNumericByDigit(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;

    }

    /**
     * 使用正则表达式不能判断浮点型的科学计数法的表达方式，非字符的科学计数，只能是Double的
     * @param str
     * @return
     */
    public static boolean isNumericByPattern(String str) {
        Pattern pattern = Pattern.compile("-?[0-9]+\\.?[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    /**
     * 把数字转换成BigDecimal,可以兼容科学计数法
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        // 该正则表达式可以匹配所有的数字 包括负数
        Pattern pattern = Pattern.compile("-?[0-9]+(\\.[0-9]+)?");
        String bigStr;
        try {
            bigStr = new BigDecimal(str).toString();
        } catch (Exception e) {
            return false;//异常 说明包含非数字。
        }

        Matcher isNum = pattern.matcher(bigStr); // matcher是全匹配
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }







}
