package com.demo.interviewdemo.time.timezoneFormatChange;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author jaywant 用于业务时区和本地时区时间的转换、计算
 */
@Slf4j
public class DateZoneUtil {
    private final static DateTimeFormatter DEFAULT_FORMATTER   = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private final static DateFormat        DEFAULT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final static String            OFFSET_ZERO         = "00";
    private final static String[]          REPEAT_ZONE_ID      = {"Etc/GMT+12", "Etc/GMT+11", "Pacific/Samoa",
            "Etc/GMT+10", "SystemV/HST10", "Etc/GMT+9", "SystemV/YST9", "Etc/GMT+8", "SystemV/PST8", "SystemV/YST9YDT",
            "Etc/GMT+7", "PST8PDT", "SystemV/MST7", "SystemV/PST8PDT", "US/Pacific-New", "Etc/GMT+6", "MST7MDT",
            "SystemV/CST6", "SystemV/MST7MDT", "CST6CDT", "Etc/GMT+5", "SystemV/CST6CDT", "SystemV/EST5", "EST5EDT",
            "Etc/GMT+4", "SystemV/AST4", "SystemV/EST5EDT", "Etc/GMT+3", "SystemV/AST4ADT", "Etc/GMT+2", "Etc/GMT+1",
            "Etc/GMT", "Etc/GMT+0", "Etc/GMT0", "Etc/GMT-0", "Etc/Greenwich", "Etc/UCT", "Etc/Universal", "Etc/UTC",
            "Etc/Zulu", "GMT", "GMT0", "UCT", "UTC", "Atlantic/Faeroe", "Etc/GMT-1", "WET", "CET", "Etc/GMT-2", "MET",
            "EET", "Etc/GMT-3", "W-SU", "Etc/GMT-4", "Etc/GMT-5", "Asia/Katmandu5", "Asia/Dacca", "Asia/Thimbu",
            "Etc/GMT-6", "Etc/GMT-7", "Asia/Macao", "Singapore", "Etc/GMT-8", "Hongkong", "Etc/GMT-9", "Etc/GMT-10",
            "Etc/GMT-11", "Pacific/Ponape", "Etc/GMT-12", "Etc/GMT-13", "Etc/GMT-14", "Egypt", "Eire", "GB", "GB-Eire",
            "Iceland", "Iran", "Israel", "Jamaica", "Japan", "Kwajalein", "Libya", "NZ", "NZ-CHAT", "Navajo", "PRC",
            "Poland", "Portugal", "ROK", "Turkey", "Zulu", "Cuba"};

    /**
     * localDate转Date，按业务时区，
     */
    public static Date localDate2Date(LocalDate localDate, String partnerZone) {
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.of(partnerZone));
        return Date.from(zonedDateTime.toInstant());
    }

    /**
     * Date 转 localDate，按业务时区，
     */
    public static LocalDate date2LocalDate(Date date, String partnerZone) {
        ZonedDateTime zdt = date.toInstant().atZone(ZoneId.of(partnerZone));
        return zdt.toLocalDate();
    }

    /**
     * 按业务时区， LocalDateTime转Date
     */
    public static Date localDateTime2Date(LocalDateTime localDateTime, String partnerZone) {
        return Date.from(localDateTime.atZone(ZoneId.of(partnerZone)).toInstant());
    }

    /**
     * 按业务时区， Date 转LocalDateTime
     */
    public static LocalDateTime date2LocalDateTime(Date date, String partnerZone) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.of(partnerZone)).toLocalDateTime();
    }

    /**
     * yyyy-MM-dd HH:mm:ss 按业务时区转Date 举例生产上是新加坡utc+8 Date dd =
     * datetimeStr2Date("2020-02-01 00:00:00","Asia/Jakarta"); //
     * Asia/Jakarta为雅加达时间utc+7 System.out.println(dd); //会打印 2020-02-01 01:00:00
     * 对应时间 // utc+8
     */
    public static Date datetimeStr2Date(String datetimeStr, String partnerZone) {
        LocalDateTime localDateTime = LocalDateTime.parse(datetimeStr, DEFAULT_FORMATTER);
        return localDateTime2Date(localDateTime, partnerZone);
    }

    /**
     * yyyy-MM-dd HH:mm:ss 按业务时区转Date 举例生产上是新加坡utc+8 Date dd =
     * datetimeStr2Date("2020-02-01 00:00:00","Asia/Jakarta"); //
     * Asia/Jakarta为雅加达时间utc+7 System.out.println(dd); //会打印 2020-02-01 01:00:00
     * 对应时间 // utc+8
     */
    public static Date datetimeStr2Date(String datetimeStr, String partnerZone, String format) {
        LocalDateTime localDateTime = LocalDateTime.parse(datetimeStr, DateTimeFormatter.ofPattern(format));
        return localDateTime2Date(localDateTime, partnerZone);
    }

    /**
     * Date按照业务时区，转成yyyy-MM-dd HH:mm:ss 举例生产上是新加坡utc+8, 假如new Date()为2020-01-07
     * 21:00:00 String dd = date2DatetimeStr(new Date(),"Asia/Jakarta"); //
     * Asia/Jakarta为雅加达时间utc+7 System.out.println(dd); //会打印 2020-01-07 20:00:00
     * 对应时间 // utc+7
     */
    public static String date2DatetimeStr(Date date, String partnerZone) {
        LocalDateTime localDateTime = date2LocalDateTime(date, partnerZone);
        return localDateTime.format(DEFAULT_FORMATTER);
    }

    /**
     * Date按照业务时区，转成yyyy-MM-dd HH:mm:ss 举例生产上是新加坡utc+8, 假如new Date()为2020-01-07
     * 21:00:00 String dd = date2DatetimeStr(new Date(),"Asia/Jakarta"); //
     * Asia/Jakarta为雅加达时间utc+7 System.out.println(dd); //会打印 2020-01-07 20:00:00
     * 对应时间 // utc+7
     */
    public static String date2DatetimeStr(Date date, String partnerZone, String format) {
        LocalDateTime localDateTime = date2LocalDateTime(date, partnerZone);
        return localDateTime.toLocalDate().format(DateTimeFormatter.ofPattern(format));
    }

    /**
     * Date按照业务时区，转成yyyy-MM-dd HH:mm:ss 举例生产上是新加坡utc+8, 假如new Date()为2020-01-07
     * 21:00:00 String dd = date2DayStart(new Date(),"Asia/Jakarta"); //
     * Asia/Jakarta为雅加达时间utc+7 System.out.println(dd); //会打印 2020-01-07 20:00:00
     * 对应时间 // utc+7
     */
    public static String date2DayStart(Date date, String partnerZone, String format) {
        LocalDateTime localDateTime = date2LocalDateTime(date, partnerZone);
        return localDateTime.format(DateTimeFormatter.ofPattern(format));
    }

    /**
     * 返回date对应的当前时区的时间的下一个月的开始时间 举例生产上是新加坡utc+8, 假如new Date()为 2020-01-07
     * 21:00:00 Date dd = nextMonthStart(new Date(),"Asia/Jakarta"); //
     * Asia/Jakarta为雅加达时间utc+7 System.out.println(dd); //会打印 2020-02-01 01:00:00
     * 对应时间 //utc+8时间，对应 utc+7时间为 2020-02-01 00:00:00
     */
    public static Date nextMonthStart(Date date, String partnerZone) {
        LocalDateTime nextMonthFirstDay = date2LocalDateTime(date, partnerZone)
                .with(TemporalAdjusters.firstDayOfNextMonth());
        return localDateTime2Date(nextMonthFirstDay.withHour(0).withMinute(0).withSecond(0).withNano(0), partnerZone);
    }

    /**
     * 返回date对应的当前时区的时间的当天的00点时间 举例生产上是新加坡utc+8, 假如new Date()为 2020-01-07
     * 21:00:00 Date dd = thisDayStart(new Date(),"Asia/Jakarta"); //
     * Asia/Jakarta为雅加达时间utc+7 System.out.println(dd); //会打印 2020-01-07 01:00:00
     * 对应时间 //utc+8时间，对应 utc+7时间为 2020-01-07 00:00:00
     */
    public static Date thisDayStart(Date date, String partnerZone) {
        LocalDateTime thisDay = date2LocalDateTime(date, partnerZone);
        return localDateTime2Date(thisDay.withHour(0).withMinute(0).withSecond(0).withNano(0), partnerZone);
    }

    /**
     * 返回date对应的当前时区的本月最后一天23:59:59 举例生产上是新加坡utc+8, 假如new Date()为 2020-01-07
     * 21:00:00 Date dd = thisMonthEnd(new Date(),"Asia/Jakarta"); //
     * Asia/Jakarta为雅加达时间utc+7 System.out.println(dd); //会打印 2020-02-01 00:59:59
     * 对应时间 //utc+8时间，对应 utc+7时间为 2020-01-31 23:59:59
     */
    public static Date thisMonthEnd(Date date, String partnerZone) {
        LocalDateTime thisMonthEndDay = date2LocalDateTime(date, partnerZone).with(TemporalAdjusters.lastDayOfMonth());
        return localDateTime2Date(thisMonthEndDay.withHour(23).withMinute(59).withSecond(59).withNano(0), partnerZone);
    }

    /**
     * 返回date对应的当前时区的本年最后一天23:59:59 举例生产上是新加坡utc+8, 假如new Date()为 2020-01-07
     * 21:00:00 Date dd = thisYearEnd(new Date(),"Asia/Jakarta"); //
     * Asia/Jakarta为雅加达时间utc+7 System.out.println(dd); //会打印 2021-01-01 00:59:59
     * 对应时间 //utc+8时间，对应 utc+7时间为 2020-12-31 23:59:59
     */
    public static Date thisYearEnd(Date date, String partnerZone) {
        LocalDateTime thisYearEndDay = date2LocalDateTime(date, partnerZone).with(TemporalAdjusters.lastDayOfYear());
        return localDateTime2Date(thisYearEndDay.withHour(23).withMinute(59).withSecond(59).withNano(0), partnerZone);
    }

    /**
     * 返回date对应的当前时区的昨天的当天的00点时间 举例生产上是新加坡utc+8, 假如new Date()为 2020-01-07
     * 00:00:00，对应utc+7的时间实际为 2020-01-06 23:00:00 Date dd = thisDayStart(new
     * Date(),"Asia/Jakarta"); // Asia/Jakarta为雅加达时间utc+7
     * System.out.println(dd); //会打印 2020-01-05 01:00:00 对应时间 //utc+8时间，对应
     * utc+7时间为 2020-01-05 00:00:00
     */
    public static Date previousDayStart(Date date, String partnerZone) {
        LocalDateTime thisDay = date2LocalDateTime(date, partnerZone);
        return localDateTime2Date(thisDay.minusDays(1).withHour(0).withMinute(0).withSecond(0).withNano(0),
                partnerZone);
    }

    /**
     * 返回date对应的当前时区的昨天的当天的00点时间 举例生产上是新加坡utc+8, 假如new Date()为 2020-01-07
     * 00:00:00，对应utc+7的时间实际为 2020-01-06 23:00:00 Date dd = thisDayStart(new
     * Date(),"Asia/Jakarta"); // Asia/Jakarta为雅加达时间utc+7
     * System.out.println(dd); //会打印 2020-01-06 00:59:59 对应时间 //utc+8时间，对应
     * utc+7时间为 2020-01-05 23:59:59
     */
    public static Date previousDayEnd(Date date, String partnerZone) {
        LocalDateTime thisDay = date2LocalDateTime(date, partnerZone);
        return localDateTime2Date(thisDay.minusDays(1).withHour(23).withMinute(59).withSecond(59).withNano(0),
                partnerZone);
    }

    /**
     * 返回date对应的当前时区的上个月第一天1号的00点时间 举例生产上是新加坡utc+8, 假如new Date()为 2020-01-07
     * 00:00:00，对应utc+7的时间实际为 2020-01-06 23:00:00 Date dd = thisDayStart(new
     * Date(),"Asia/Jakarta"); // Asia/Jakarta为雅加达时间utc+7
     * System.out.println(dd); //会打印 2020-12-01 01:00:00 对应时间 //utc+8时间，对应
     * utc+7时间为 2019-12-01 00:00:00
     */
    public static Date previousMonthStart(Date date, String partnerZone) {
        LocalDateTime thisDay = date2LocalDateTime(date, partnerZone);
        return localDateTime2Date(thisDay.minusMonths(1).with(TemporalAdjusters.firstDayOfMonth()).withHour(0)
                .withMinute(0).withSecond(0).withNano(0), partnerZone);
    }

    /**
     * 返回date对应的当前时区的上个月最后一天的23:59:59的时间 举例生产上是新加坡utc+8, 假如new Date()为
     * 2020-01-07 00:00:00，对应utc+7的时间实际为 2020-01-06 23:00:00 Date dd =
     * thisDayStart(new Date(),"Asia/Jakarta"); // Asia/Jakarta为雅加达时间utc+7
     * System.out.println(dd); //会打印 2020-01-01 00:59:59 对应时间 //utc+8时间，对应
     * utc+7时间为 2019-12-31 23:59:59
     */
    public static Date previousMonthEnd(Date date, String partnerZone) {
        LocalDateTime thisDay = date2LocalDateTime(date, partnerZone);
        return localDateTime2Date(thisDay.minusMonths(1).with(TemporalAdjusters.lastDayOfMonth()).withHour(23)
                .withMinute(59).withSecond(59).withNano(0), partnerZone);
    }

    /**
     * 返回 Date, 其按照partnerZone时区，年月日为willUseMonthLastDayYmd的月底的年月日,
     * 十分秒为willUseHms的时分秒 比如： willUseMonthLastDayYmd对应utc+8为 2020-01-01
     * 00:10:00，其实对应utc+7为2019-12-31 23:10:00 willUseHms对应utc+8为 2020-2-1
     * 00:59:59，其实对应utc+7为2020-01-31 23:59:59 则返回Date对应的时间为(utc+8)为 2020-1-1
     * 00:59:59 ,其实对应utc+7为 2019-12-31 23:59:59
     */
    public static Date getMonthLastDayTime(Date willUseMonthLastDayYmd, Date willUseHms, String partnerZone) {
        LocalDateTime monthEndDay = date2LocalDateTime(willUseMonthLastDayYmd, partnerZone)
                .with(TemporalAdjusters.lastDayOfMonth());
        LocalDateTime willUseHmsLocalDateTime = date2LocalDateTime(willUseHms, partnerZone);
        return localDateTime2Date(
                monthEndDay.withHour(willUseHmsLocalDateTime.getHour()).withMinute(willUseHmsLocalDateTime.getMinute())
                        .withSecond(willUseHmsLocalDateTime.getSecond()).withNano(0),
                partnerZone);
    }

    /**
     * 按业务时区返回间隔天数 举例： date1对应utc+8为 2020-02-02 00:10:00，其实对应utc+7为2020-02-01
     * 23:10:00 date2对应utc+8为 2020-01-30 01:59:59，其实对应utc+7为2020-01-30 00:59:59
     * 返回-2天
     */
    public static Long betweenDays(Date date1, Date date2, String partnerZone) {
        LocalDateTime d1 = date2LocalDateTime(date1, partnerZone);
        LocalDateTime d2 = date2LocalDateTime(date2, partnerZone);
        return d1.toLocalDate().until(d2.toLocalDate(), ChronoUnit.DAYS);
    }

    /**
     * 实岁：出生日期满1年算1岁，满1年到2年也算1岁，依此类推 比如出生日期 2019-1-9，"现在"为2019-10-1,则算1岁
     */
    public static Long getAge(LocalDate birthday, Date tillDate, String partnerZone) {
        LocalDate tillLocalDate = date2LocalDate(tillDate, partnerZone);
        return ChronoUnit.YEARS.between(birthday, tillLocalDate);
    }

    /**
     * 获取所有的zoneId列表
     *
     * @return ZoneId+offset MAP列表
     */
    public static Map<String, String> getZoneIdList() {
        LocalDateTime localDateTime = LocalDateTime.now();
        Map<String, String> zoneMap = ZoneId.getAvailableZoneIds().stream().map(ZoneId::of).map(zoneId -> {
            String offset = localDateTime.atZone(zoneId).getOffset().getId().replaceAll("Z", "+00:00");
            String suffixOffset = handleOffsetSuffix(offset);
            if (null != suffixOffset) {
                offset = String
                        .format("UTC %s",
                                offset.substring(0, 1).concat(Integer.valueOf(offset.substring(1, 3)).toString()))
                        .concat(calculateMinutePercent(suffixOffset));
            } else {
                offset = String.format("UTC %s",
                        offset.substring(0, 1).concat(Integer.valueOf(offset.substring(1, 3)).toString()));
            }
            return new AbstractMap.SimpleEntry<>(zoneId.toString(), offset);
        }).sorted(true ? Map.Entry.comparingByKey() : Map.Entry.<String, String> comparingByValue().reversed())
                .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        zoneMap.entrySet().stream().forEach(x -> x.setValue("(".concat(x.getValue()).concat(")")));
        MapUtil.removeEntries(zoneMap, REPEAT_ZONE_ID);
        return zoneMap;
    }

    public static Map<String, String> testgetZoneIdList() {
        LocalDateTime localDateTime = LocalDateTime.now();
        Map<String, String> zoneMap = ZoneId.getAvailableZoneIds().stream().map(ZoneId::of).map(zoneId -> {
            String offset = localDateTime.atZone(zoneId).getOffset().getId().replaceAll("Z", "+00:00");
            return new AbstractMap.SimpleEntry<>(zoneId.toString(), offset);
        }).sorted(false ? Map.Entry.comparingByKey() : Map.Entry.<String, String> comparingByValue().reversed())
                .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        return zoneMap;
    }

    /**
     * 获取默认时区
     *
     * @return 默认时区
     */
    public static Map<String, String> getDefaultZoneId() {
        Map<String, String> defaultZoneMap = new HashMap<>();
        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneId zoneId = ZoneId.systemDefault();
        String offset = localDateTime.atZone(zoneId).getOffset().getId().replaceAll("Z", "+00:00");
        String suffixOffset = handleOffsetSuffix(offset);
        if (null != suffixOffset) {
            offset = String
                    .format("UTC %s", offset.substring(0, 1).concat(Integer.valueOf(offset.substring(1, 3)).toString()))
                    .concat(calculateMinutePercent(suffixOffset));
        } else {
            offset = String.format("UTC %s",
                    offset.substring(0, 1).concat(Integer.valueOf(offset.substring(1, 3)).toString()));
        }
        defaultZoneMap.put(zoneId.toString(), offset);
        return defaultZoneMap;
    }

    /**
     * 获取时区信息,中心化API,供外部系统集成调用
     *
     * @return TimeZoneResponseDTO 时区信息
     */
    public static TimeZoneResponseDTO getZoneInfo() {
        TimeZoneResponseDTO timeZoneResponseDTO = new TimeZoneResponseDTO();
        timeZoneResponseDTO.setZoneInfoList(DateZoneUtil.getZoneIdList());
        timeZoneResponseDTO.setDefaultZoneInfo(DateZoneUtil.getDefaultZoneId());
        timeZoneResponseDTO.setDefaultTimeStamp(Instant.now().toEpochMilli());
        return timeZoneResponseDTO;
    }

    /**
     * 转换时区时间
     *
     * @param sourceZoneId 源时区zoneId
     * @param targetZoneId 目标时区zoneId
     * @param sourceDate 源时区时间
     * @return 目标时区时间
     * @throws ParseException
     */
    public static Date convertTargetTimeZoneDate(String sourceZoneId, String targetZoneId, Date sourceDate)
            throws ParseException {
        if (null == sourceDate || StringUtils.isEmpty(sourceZoneId) || StringUtils.isEmpty(targetZoneId)) {
            return null;
        }
        if (sourceZoneId.equals(targetZoneId)) {
            return sourceDate;
        }
        LocalDateTime sourceLocalDateTime = LocalDateUtils.convertToLocalDateTime(sourceDate);
        ZoneId sourceZone = ZoneId.of(sourceZoneId);
        ZoneId targetZone = ZoneId.of(targetZoneId);
        ZonedDateTime sourceZonedDateTime = sourceLocalDateTime.atZone(sourceZone);
        ZonedDateTime targetZonedDateTime = sourceZonedDateTime.withZoneSameInstant(targetZone);
        long hours = Duration.between(targetZonedDateTime.withEarlierOffsetAtOverlap(),
                targetZonedDateTime.withLaterOffsetAtOverlap()).toHours();
        targetZonedDateTime = targetZonedDateTime.plusHours(hours);
        return DEFAULT_DATE_FORMAT.parse(targetZonedDateTime.format(DEFAULT_FORMATTER));
    }

    private static String calculateMinutePercent(String minuteOffset) {
        if (null == minuteOffset) {
            return null;
        }
        double fullMinute = 60d;
        double doubleMinuteOffset = Double.valueOf(minuteOffset);
        String result = String.valueOf(doubleMinuteOffset / fullMinute);
        return result.equals("0.0")?null:result.substring(1,result.length());
    }

    private static String handleOffsetSuffix(String offset) {
        if (null == offset) {
            return null;
        }
        return offset.substring(4, offset.length()).equals(OFFSET_ZERO) ? null : offset.substring(4, offset.length());
    }

    public static int getAge(int year, int month, int day) {

        // 生日
        LocalDate birthday = LocalDate.of(year, month, day);

        // 当前日期
        LocalDate today = LocalDate.now();

        long duration = ChronoUnit.YEARS.between(birthday, today);

        return (int)duration;
    }

    public static void main(String[] args) throws ParseException {
        System.out.println(datetimeStr2Date("2020-02-01 00:00:00", "Asia/Jakarta"));
        System.out.println(date2DatetimeStr(new Date(), "Asia/Jakarta"));
        System.out.println(nextMonthStart(new Date(), "Asia/Jakarta"));
        System.out.println(thisDayStart(new Date(), "Asia/Jakarta"));
        System.out.println(thisMonthEnd(new Date(), "Asia/Jakarta"));
        System.out.println(thisYearEnd(new Date(), "Asia/Jakarta"));

        System.out.println(getMonthLastDayTime(datetimeStr2Date("2019-12-31 23:10:00", "Asia/Jakarta"),
                datetimeStr2Date("2020-01-31 23:59:59", "Asia/Jakarta"), "Asia/Jakarta"));

        System.out.println(betweenDays(datetimeStr2Date("2020-02-01 23:10:00", "Asia/Jakarta"),
                datetimeStr2Date("2020-01-30 00:59:59", "Asia/Jakarta"), "Asia/Jakarta"));
        System.out.println(previousDayStart(datetimeStr2Date("2020-03-01 00:00:00", "Asia/Jakarta"), "Asia/Jakarta"));
        System.out.println(previousDayEnd(datetimeStr2Date("2020-03-01 23:00:00", "Asia/Jakarta"), "Asia/Jakarta"));

        System.out.println(previousMonthStart(datetimeStr2Date("2020-02-29 00:00:00", "Asia/Jakarta"), "Asia/Jakarta"));
        System.out.println(previousMonthEnd(datetimeStr2Date("2020-02-29 00:00:00", "Asia/Jakarta"), "Asia/Jakarta"));
        System.out.println(getAge(LocalDate.of(2018, 1, 9), new Date(), "Asia/Shanghai"));
        Map<String, String> zoneIdList = getZoneIdList();
        System.out.println(zoneIdList);
        System.out.println("\nTotal Zone IDs " + zoneIdList.size());
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(ZoneId.systemDefault().getId());
        System.out.println(localDateTime.atZone(zoneId).getOffset().getId());
        System.out.println(getZoneIdList());
        System.out.println(convertTargetTimeZoneDate("Asia/Shanghai", "Asia/Tokyo", new Date()));
        System.out.println(testgetZoneIdList());
        System.out.println(Instant.now().toEpochMilli());
        System.out.println(System.currentTimeMillis());
        System.out.println(getZoneInfo());
        System.out.println(LocalDate.now().toString());
    }
}
