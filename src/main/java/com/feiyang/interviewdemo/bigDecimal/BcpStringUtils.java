package com.feiyang.interviewdemo.bigDecimal;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.regex.Pattern;

/**
 * @author mosonglin 2019/6/30 4:00 PM
 * @description
 */
public class BcpStringUtils {

    /**
     * 金额
     */
    private static Pattern bigdecimal = Pattern.compile("^([-]|[0-9])\\d{0,18}(\\.\\d{0,10})?$");

    /**
     * 比较两个值是否相等
     *
     * @param var1
     * @param var2
     * @return
     */
    public static boolean valueCompare(Object var1, Object var2) {
        if (var1 == null || var2 == null) {
            return false;
        }
        return var1.equals(var2);
    }

    /**
     * 比较金额是否相等
     * 
     * @param decimal1
     * @param decimal2
     * @return
     */
    public static boolean decimalCompare(String decimal1, String decimal2) {
        if (decimal1 == null || decimal2 == null || !bigdecimal.matcher(decimal1).find()
                || !bigdecimal.matcher(decimal2).find()) {
            return false;
        }
        return new BigDecimal(decimal1).compareTo(new BigDecimal(decimal2)) == 0;
    }

    /**
     * 两个费用相加
     *
     * @param var1
     * @param var2
     * @return
     */
    public static String addBigdecimal(String var1, String var2) {
        if (var1 == null || !bigdecimal.matcher(var1).find()) {
            var1 = "0";
        }
        if (var2 == null || !bigdecimal.matcher(var2).find()) {
            var2 = "0";
        }
        BigDecimal b = new BigDecimal(var1).add(new BigDecimal(var2));
        return b.toString();
    }

    /**
     * 两个费用相减
     *
     * @param var1
     * @param var2
     * @return
     */
    public static String subtractBigdecimal(String var1, String var2) {
        if (var1 == null || !bigdecimal.matcher(var1).find()) {
            var1 = "0";
        }
        if (var2 == null || !bigdecimal.matcher(var2).find()) {
            var2 = "0";
        }
        BigDecimal b = new BigDecimal(var1).add(new BigDecimal(var2).negate());
        return b.toString();
    }


    /**
     * 金额中间加上逗号 +
     * 
     * @return
     */
    public static String formatDecimal(Object amount) {
        BigDecimal a = null;
        if (amount instanceof BigDecimal) {
            a = (BigDecimal) amount;
        } else if (amount instanceof String) {
            if (!bigdecimal.matcher((String) amount).find()) {
                return "0";
            }
            a = new BigDecimal((String) amount);
        } else {
            throw new RuntimeException("不合法的类型.");
        }

        DecimalFormat df = new DecimalFormat(",###.00");
        String b = df.format(a);
        if (a.compareTo(new BigDecimal(1)) == -1 && a.compareTo(new BigDecimal(-1)) == 1) {
            b = b.replace(".", "0.");
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(subtractBigdecimal("0.5", "0.50"));
        System.out.println(formatDecimal(BigDecimal.valueOf(0).negate()));
        System.out.println(formatDecimal(new BigDecimal("-1").multiply(BigDecimal.valueOf(2))));
        System.out.println(formatDecimal(new BigDecimal("-0").negate()));

    }
}
