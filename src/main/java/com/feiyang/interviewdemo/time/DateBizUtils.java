/*
 * Copyright By ZATI
 * Copyright By 3a3c88295d37870dfd3b25056092d1a9209824b256c341f2cdc296437f671617
 * All rights reserved.
 *
 * If you are not the intended user, you are hereby notified that any use, disclosure, copying, printing, forwarding or
 * dissemination of this property is strictly prohibited. If you have got this file in error, delete it from your system.
 */
package com.feiyang.interviewdemo.time;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

/**
 * @ClassName DateBizUtils
 * @Descpription TODO
 * @Author zawb_zhaodaolin
 * @Date 2019/12/6 16:45
 **/
@Slf4j
public class DateBizUtils {

    private static final String PATTERN = "yyyy-MM-dd HH:mm:ss";

    private static final String PATTERN_DATE = "yyyy-MM-dd";

    /**
     * 时区转换支持字符串时间
     * @return
     */
    public static Date convertZoneTimeByString(String sourceDate, String sourceZoneId, String targetZoneId,String pattern) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(sourceZoneId));
        Date date = simpleDateFormat.parse(sourceDate);
        return Date.from(ZonedDateTime.ofInstant(date.toInstant(), ZoneId.of(targetZoneId)).toInstant());

    }

    /**
     * 时区转换支持字符串时间
     * 缺省格式 "yyyy-MM-dd HH:mm:ss"
     * 这种转换时间值不会改变 返回的date也就是实际按照系统时区该显示的值
     * @param sourceDate
     * @param sourceZoneId
     * @param targetZoneId
     * @return
     * @throws ParseException
     */
    public static Date convertZoneTimeByString(String sourceDate, String sourceZoneId, String targetZoneId)  {
        try {
            if (sourceDate == null) {
                return null;
            }

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(PATTERN);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(sourceZoneId));
            Date date = simpleDateFormat.parse(sourceDate);
            return Date.from(ZonedDateTime.ofInstant(date.toInstant(), ZoneId.of(targetZoneId)).toInstant());

        } catch (ParseException e) {
            log.warn("DateBizUtils convertZoneTimeByString parse date error:{}", sourceDate);
            throw new RuntimeException("DateBizUtils convertZoneTimeByString parse date error", e);
        }
    }

    /**
     * 时区转换
     * 返回时间字符串
     * @param sourceDate
     * @param targetZoneId
     * @return
     * @throws ParseException
     */
    public static String convertZoneTimeToString(Date sourceDate, String targetZoneId)  {
        if (sourceDate == null) {
            return null;
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(PATTERN);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(targetZoneId));
        return simpleDateFormat.format(sourceDate);

    }

    /**
     * date类型时区转换
     *
     * 注意：这种方法返回值Date toString值就是目标时区的显示值 所以这个转换只能为了显示 不能当作时间计算 因为date默认系统时区已经没有意义
     *
     * @param sourceZoneId
     * @param targetZoneId
     * @param sourceDate
     * @return
     */
    public static Date convertTargetTimeZoneDate(String sourceZoneId, String targetZoneId, Date sourceDate){
        if(sourceDate == null) {
            return null;
        }
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
        return Date.from(LocalDateTime.ofInstant(sourceDate.toInstant(), targetZone).atZone(sourceZone).toInstant());
    }

    /**
     * patten date without time
     * @param date
     * @return
     */
    public static String convertPattenDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(PATTERN_DATE);
        return simpleDateFormat.format(date) + " 00:00:00";
    }

    public static void main(String[] args) {
        // Asia/Tokyo Asia/Shanghai
//        Arrays.asList(TimeZone.getAvailableIDs()).forEach(System.out::println);
//        System.out.println(convertTargetTimeZoneDate("Asia/Shanghai", "Asia/Tokyo", new Date()));
//        System.out.println(convertZoneTimeByString("2020-05-21 11:45:00", "Asia/Shanghai", "Asia/Tokyo"));
//        System.out.println(convertZoneTimeByString("2020-05-21 11:45:00", "Asia/Tokyo", "Asia/Shanghai"));
//        注意：UTC+9 这种格式的时区通过format转换有bug
        System.out.println(convertZoneTimeByString("2020-05-21 11:45:00", "UTC9", "UTC8"));
//        System.out.println(convertZoneTimeByString("2020-05-21 11:45:00", "GMT+9", "GMT+8"));

    }

}
