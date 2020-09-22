package com.demo.interviewdemo.time;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @Description: time zone operate change or show
 * 转时区 通常是在前后端 或则服务间 通过时间字符串交互时需要 如果是之间传递时间戳则不需要转时区
 * @Author: jiahuiyang
 * @Date: Created in 14:43 2020/4/22
 */
public class TimeZoneDemo {
    public static void main(String[] args) {
        System.out.println(ZoneId.getAvailableZoneIds());
//        method();
//        method1();

//        method2();

        method3();
    }

    public static void method() {

        Date date = new Date();

        //time zone change
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.of("Asia/Aden"));
        System.out.println(localDateTime);

        // LocalDateTime显示的当前默认时区
        System.out.println(LocalDateTime.now());

        // 只有LocalDateTime可以指定时区并且改变时间内容 只针对时区的修改
        System.out.println(LocalDateTime.now().atZone(ZoneId.of("Asia/Aden")));

        // ZonedDateTime显示的是指定的时区ZonedDateTime对象不能指定时区，只能在创建时指定时区
        System.out.println(ZonedDateTime.now());

        // Instant显示时间是UTC0时区
        System.out.println(Instant.now());

        // Instant 指定时区会自动转换时间
        System.out.println(Instant.now().atZone(ZoneId.of("Asia/Aden")));

        //Date也是带当前时区
        System.out.println(new Date());

        System.out.println(Calendar.getInstance());

        // Calendar修改时区并不能修改时间 还是同一个时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("Asia/Aden"));
        System.out.println(calendar.getTime());


    }

    public static void method1() {
        Date date = new Date();
        System.out.println(LocalDateTime.ofInstant(date.toInstant(), ZoneId.of("Asia/Aden")));
//        LocalDateTime和ZonedDateTime之间转换是舍去时间的时区实际时间转换，只有单纯的时区加和去
        System.out.println(ZonedDateTime.ofInstant(date.toInstant(),ZoneId.of("Asia/Aden")).toLocalDateTime());
        System.out.println(Date.from(LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).atZone(ZoneId.of("Asia/Aden")).toInstant()));


        System.out.println(ZonedDateTime.ofInstant(date.toInstant(),ZoneId.systemDefault()).toLocalDateTime().atZone(ZoneId.of("Asia/Aden")));



    }

    public static void method2() {
//        System.out.println(convertTargetTimeZoneDate("Asia/Aden", null, new Date()));
        System.out.println(convertTargetTimeZoneDateOld("Asia/Aden", "Asia/Urumqi", new Date()));
    }

    public static void method3() {
        String sourceZoneId = "Asia/Aden", targetZoneId = "Asia/Urumqi";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        TemporalAccessor temporalAccessor = dateTimeFormatter.parse("2020-04-22 17:22:30");

        System.out.println(LocalDateTime.from(temporalAccessor).atZone(ZoneId.of(sourceZoneId)));

        // ZoneDateTime本身自带时区转换函数withZoneSameInstant 表示同使用Instant时区转换，时间会同等转换
        System.out.println(LocalDateTime.from(temporalAccessor).atZone(ZoneId.of(sourceZoneId)).withZoneSameInstant(ZoneId.of(targetZoneId)));
        // ZoneDateTime本身自带时区转换函数withZoneSameLocal 表示同使用Local时区转换，时间不会同等转换，只会变化时区
        System.out.println(LocalDateTime.from(temporalAccessor).atZone(ZoneId.of(sourceZoneId)).withZoneSameLocal(ZoneId.of(targetZoneId)));
        // 时区转换
        System.out.println(LocalDateTime.from(temporalAccessor).atZone(ZoneId.of(sourceZoneId)).toInstant().atZone(ZoneId.of(targetZoneId)).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

//        如果时区转换后最后输出是Date其实相当于没转 因为Date本身就是带时区 所以从源头经过任何转换结果都是一样 Date时区固定JDK时区
        System.out.println(Date.from(LocalDateTime.from(temporalAccessor).atZone(ZoneId.of(sourceZoneId)).toInstant().atZone(ZoneId.of(targetZoneId)).toInstant()));

        // 时间字符串转ZoneDateTime 和 Instant失败 原因是这种格式不能转
//        System.out.println(ZonedDateTime.from(temporalAccessor));

//        System.out.println(Instant.from(temporalAccessor));

        System.out.println(convertTargetTimeZoneDate(sourceZoneId,targetZoneId,"2020-04-22 17:22:30"));
    }



    /**
     * 如果使用Date作为转换的时间入参和出参 会存在date本身自带时区的问题
     * @param sourceZoneId
     * @param targetZoneId
     * @param sourceDate
     * @return
     */
    public static Date convertTargetTimeZoneDate(String sourceZoneId, String targetZoneId, String sourceDate){

        return Date.from(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse(sourceDate)).atZone(ZoneId.of(sourceZoneId)).withZoneSameInstant(ZoneId.of(sourceZoneId)).toInstant());

    }

    public static Date convertTargetTimeZoneDateOld(String sourceZoneId, String targetZoneId, Date sourceDate){
        ////sourceZoneId = "Asia/Harbin";
        ////targetZoneId = "Asia/Tokyo";//Asia/Urumqi
        ZoneId sourceZone;
        if(sourceZoneId == null) {
            sourceZone = ZoneId.systemDefault();
        } else {
            sourceZone = ZoneId.of(sourceZoneId);
        }
        ZoneId targetZone;
        if(targetZoneId == null) {
            targetZone = ZoneId.systemDefault();
        } else {
            targetZone = ZoneId.of(targetZoneId);
        }
        if(sourceDate == null) {
            return null;
        }
        ZonedDateTime sourceZonedDateTime = ZonedDateTime.ofInstant(sourceDate.toInstant(), sourceZone);
        ZonedDateTime targetZonedDateTime = sourceZonedDateTime.withZoneSameInstant(targetZone);
        return Date.from(targetZonedDateTime.toLocalDateTime().atZone(sourceZone).toInstant());
    }


}
