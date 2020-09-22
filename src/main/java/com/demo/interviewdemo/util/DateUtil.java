package com.demo.interviewdemo.util;

import java.time.*;
import java.util.Date;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-07-16 10:01
 **/
public class DateUtil {
    public static void main(String[] args) {

        int num = 0;
        int result = ++num * 2;
        System.out.println(result);

        int resultNew = num++ * 2;
        System.out.println(resultNew);

        LocalDateTime.now();
        LocalDate.now().atTime(0, 0, 0, 000);
        //一天开始
        System.out.println(LocalDate.now().atTime(0, 0, 0, 000));
        System.out.println(LocalDate.now().atTime(23, 59, 59, 999).atZone(ZoneId.systemDefault()).toInstant());

        LocalDateTime.now().atZone(ZoneId.systemDefault());

        LocalDateTime.now();

        ZonedDateTime.now();



        System.out.println(LocalDate.now().toEpochDay());

        Instant.now().atZone(ZoneId.systemDefault());



    //    java8 Time 转 Date 主要是 LocalDate -> ZonedDateTime LocalDateTime -> ZonedDateTime -> Instant -> Date

    //    反之 Date 转 java8 Time 主要是 Date -> Instant -> ZonedDateTime LocalDateTime LocalDate LocalTime OffsetDateTime -> LocalDateTime LocalDate



    }

    /**
     * 开始时间和结束时间相差天数
     * @param from
     * @param to
     * @return
     */
    public static int differentDaysByMillisecond(Date from, Date to) {
        //转毫秒数
        int days = (int) ((to.getTime()) - (from.getTime())) / (1000 * 3600 * 24);
        return days;
    }

    /**
     * 获取一天的开始时间
     * 有多种获取方式
     * @param date
     * @return
     */
    public static LocalDateTime atStartOfDay(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).toLocalDate().atStartOfDay();
    }

    /**
     * 获取一天的结束时间
     * @param date
     * @return
     */
    public static int atEndOfDay(Date date) {
        return 0;

    }














}
