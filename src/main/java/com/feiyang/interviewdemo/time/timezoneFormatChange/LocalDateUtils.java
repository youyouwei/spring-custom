package com.feiyang.interviewdemo.time.timezoneFormatChange;


import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class LocalDateUtils {
    private static ZoneId zone = ZoneId.systemDefault();

    public LocalDateUtils() {
    }

    public static Date convertToDate(String date) throws Exception {
        LocalDate localDate = null;
        if (null == date) {
            throw new NullPointerException("date isn't null");
        } else {
            localDate = LocalDate.parse(date);
            return convertToDate(localDate);
        }
    }

    public static LocalDateTime convertToLocalDateTime(String date) {
        LocalDateTime localDateTime = null;
        if (null == date) {
            throw new NullPointerException("date isn't null");
        } else {
            localDateTime = LocalDateTime.parse(date);
            return localDateTime;
        }
    }

    public static Date convertToDate(LocalDate localDate) {
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        return Date.from(instant);
    }

    public static Date convertToDate(LocalDateTime localDateTime) {
        Instant instant = localDateTime.atZone(zone).toInstant();
        return Date.from(instant);
    }

    public static LocalDate convertToLocalDate(Date date) {
        Instant instant = date.toInstant();
        return convertToLocalDateTime(instant).toLocalDate();
    }

    public static LocalTime convertToLocalTime(Date date) {
        Instant instant = date.toInstant();
        return convertToLocalDateTime(instant).toLocalTime();
    }

    public static LocalDateTime convertToLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        return convertToLocalDateTime(instant);
    }

    public static LocalDateTime convertToLocalDateTime(Instant instant) {
        return LocalDateTime.ofInstant(instant, zone);
    }

    public static Instant convertToInstant(LocalDateTime localDateTime) {
        return localDateTime.atZone(zone).toInstant();
    }

    public static Instant convertToInstant(LocalDate localDate) {
        return localDate.atStartOfDay(zone).toInstant();
    }

    public static LocalDateTime convertToLocalDateTime(LocalDate localDate) {
        return localDate.atStartOfDay();
    }

    public static String formatter(LocalDateTime localDateTime, String formatStyle) {
        return DateTimeFormatter.ofPattern(formatStyle).format(localDateTime);
    }

    public static LocalDateTime setYear(LocalDateTime sourceDate, Integer year) {
        return sourceDate.withYear(year);
    }

    public static LocalDateTime setMonth(LocalDateTime sourceDate, Integer month) {
        return sourceDate.withMonth(month);
    }

    public static LocalDateTime setDayOfMonth(LocalDateTime sourceDate, Integer dayOfMonth) {
        return sourceDate.withDayOfMonth(dayOfMonth);
    }

    public static LocalDateTime setHour(LocalDateTime sourceDate, Integer hour) {
        return sourceDate.withHour(hour);
    }

    public static LocalDateTime setMinute(LocalDateTime sourceDate, Integer minute) {
        return sourceDate.withMinute(minute);
    }

    public static LocalDateTime setSecond(LocalDateTime sourceDate, Integer second) {
        return sourceDate.withSecond(second);
    }

    public static LocalDateTime setYMD(LocalDateTime sourceDate, Integer year, Integer month, Integer dayOfMonth) {
        return sourceDate.withYear(year).withMonth(month).withDayOfMonth(dayOfMonth);
    }

    public static LocalDateTime setHMS(LocalDateTime sourceDate, Integer hour, Integer minute, Integer second) {
        return sourceDate.withHour(hour).withMinute(minute).withSecond(second);
    }

    public static int getInteverDays(LocalDate beginDate, LocalDate endDate) {
        Period period = Period.between(beginDate, endDate);
        return period.getDays();
    }

    public static LocalDate addLocalDate(long num, ChronoUnit unit, LocalDate localDate) {
        LocalDate resultDate;
        if (num > 0L) {
            resultDate = LocalDate.now().plus(num, unit);
        } else {
            resultDate = LocalDate.now().minus(Math.abs(num), unit);
        }

        return resultDate;
    }

    public static LocalDateTime addLocalDateTime(long num, ChronoUnit unit, LocalDateTime localDateTime) {
        LocalDateTime resultDateTime;
        if (num > 0L) {
            resultDateTime = LocalDateTime.now().plus(num, unit);
        } else {
            resultDateTime = LocalDateTime.now().minus(Math.abs(num), unit);
        }

        return resultDateTime;
    }

    public static LocalTime addLocalTime(long num, ChronoUnit unit, LocalTime localTime) {
        LocalTime resultTime;
        if (num > 0L) {
            resultTime = LocalTime.now().plus(num, unit);
        } else {
            resultTime = LocalTime.now().minus(Math.abs(num), unit);
        }

        return resultTime;
    }

    public static void main(String[] args) {
        LocalDateTime localDateTime = convertToLocalDateTime(new Date());
        String date = formatter(localDateTime, "yyyy-MM-dd HH:mm:ss");
        System.out.println(date);
    }
}
