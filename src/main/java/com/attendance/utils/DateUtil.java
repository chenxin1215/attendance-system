package com.attendance.utils;

import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 */
public class DateUtil {

    public static final String DATE_BASE = "yyyy-MM-dd";

    public static final String TIME_BASE = "HH:mm:ss";

    public static final String DATETIME_BASE = "yyyy-MM-dd HH:mm:ss";

    /**
     *
     * @param text 例：yyyy-MM-dd HH:mm:ss
     * @return date的字符串
     */
    public static Date stringToDate(String dateStr, String text) {

        if (!StringUtils.isEmpty(dateStr)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(text);
            try {
                return simpleDateFormat.parse(dateStr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String dateToString(Date date, String text) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(text);

        return simpleDateFormat.format(date);
    }

    /**
     * 设置时间为当前的0点0分0秒
     *
     * @param start
     */
    public static Date getInitStart(Date start) {
        if (start == null) {
            return null;
        }

        Calendar instance = Calendar.getInstance();
        instance.setTime(start);
        instance.set(Calendar.HOUR_OF_DAY, 0);
        instance.set(Calendar.MINUTE, 0);
        instance.set(Calendar.SECOND, 0);
        instance.set(Calendar.MILLISECOND, 0);

        return instance.getTime();
    }

    /**
     * 设置时间为23点59分59秒
     *
     * @param end
     */
    public static Date getInitEnd(Date end) {
        if (end == null) {
            return null;
        }

        Calendar instance = Calendar.getInstance();
        instance.setTime(end);
        instance.set(Calendar.HOUR_OF_DAY, 23);
        instance.set(Calendar.MINUTE, 59);
        instance.set(Calendar.SECOND, 59);
        instance.set(Calendar.MILLISECOND, 999);

        return instance.getTime();
    }

}
