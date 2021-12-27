package com.fxs.fzm.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    private static final String FULL_FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT_PATTERN = "yyyy-MM-dd";
    private static final String TIME_FORMAT_PATTERN = "HH:mm:ss";
    public static final String FULL_MINUTE_FORMAT_PATTERN = "yyyy-MM-dd HH:mm";

    public static int calcDiffDay(Date start, Date end) {
        int days = (int) ((end.getTime() - start.getTime()) / (1000*3600*24));
        return days;
    }

    /**
     * 原有时间加上分钟数
     * @param date
     * @param minute
     * @return
     */
    public static Date addMinutes(Date date, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minute);
        return calendar.getTime();
    }

    /**
     * 以yyyy-MM-dd HH:mm:ss格式化时间
     * @param date
     * @return
     */
    public static String format(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(FULL_FORMAT_PATTERN);
        String str = sdf.format(date);
        return str;
    }

    /**
     * 自定义格式化方式
     * @param date
     * @param pattern
     * @return
     */
    public static String format(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String str = sdf.format(date);
        return str;
    }

    /**
     * 以yyyy-MM-dd格式化时间
     * @param date
     * @return
     */
    public static String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_PATTERN);
        String str = sdf.format(date);
        return str;
    }

    /**
     * 以HH:mm:ss格式化时间
     * @param date
     * @return
     */
    public static String formatTime(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(TIME_FORMAT_PATTERN);
        String str = sdf.format(date);
        return str;
    }

    /**
     * 以yyyy-MM-dd HH:mm:ss方式解析时间
     * @param dateStr
     * @return
     */
    public static Date parse(String dateStr) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(FULL_FORMAT_PATTERN);
            date = sdf.parse(dateStr);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return date;
    }

    /**
     * 以yyyy-MM-dd方式解析时间
     * @param dateStr
     * @return
     */
    public static Date parseDate(String dateStr) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_PATTERN);
            date = sdf.parse(dateStr);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return date;
    }

}
