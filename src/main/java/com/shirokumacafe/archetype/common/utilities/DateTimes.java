package com.shirokumacafe.archetype.common.utilities;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

/**
 * JodaTime辅助类
 *
 * @author lim
 */
public class DateTimes {
    private final static String FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 将日期转换为指定格式的字符串
     *
     * @param date
     * @param format
     * @return
     */
    public static String convertToString(Date date, String format) {
        DateTime dateTime = new DateTime(date);
        DateTimeFormatter fmt = DateTimeFormat.forPattern(format);
        return fmt.print(dateTime);
    }

    /**
     * 将日期转换为默认设置的字符串
     *
     * @param date
     * @return
     */
    public static String convertToString(Date date) {
        DateTime dateTime = new DateTime(date);
        DateTimeFormatter fmt = DateTimeFormat.forPattern(FORMAT);
        return fmt.print(dateTime);
    }

    /**
     * 将字符串按指定的格式转换为日期
     *
     * @param str
     * @param format
     * @return
     */
    public static Date convertFromString(String str, String format) {
        DateTimeFormatter fmt = DateTimeFormat.forPattern(format);
        DateTime dateTime = fmt.parseDateTime(str);
        return dateTime.toDate();
    }

    /**
     * 将字符串按默认的格式转换为日期
     *
     * @param str
     * @return
     */
    public static Date convertFromString(String str) {
        Date date = convertFromString(str, FORMAT);
        return date;
    }

    /**
     * 取得月份的头一天
     *
     * @param date
     * @return
     */
    public static Date startOfMonth(Date date) {
        DateTime dateTime = new DateTime(date);
        DateTime startOfMonth = dateTime.dayOfMonth().withMinimumValue();
        return startOfMonth.toDate();
    }

    /**
     * 取得月份的最后一天
     *
     * @param date
     * @return
     */
    public static Date endOfMonth(Date date) {
        DateTime dateTime = new DateTime(date);
        DateTime endOfMonth = dateTime.dayOfMonth().withMaximumValue();
        return endOfMonth.toDate();
    }

    /**
     * 取得时间一天的0:00
     *
     * @param date
     * @return
     */
    public static Date startOfDate(Date date) {
        DateTime dateTime = new DateTime(date);
        return dateTime.millisOfDay().withMinimumValue().toDate();
    }

    /**
     * 取得时间一天的23:59:59
     *
     * @param date
     * @return
     */
    public static Date endOfDate(Date date) {
        DateTime dateTime = new DateTime(date);
        return dateTime.millisOfDay().withMaximumValue().toDate();
    }

}
