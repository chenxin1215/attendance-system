package com.attendance.utils;

import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
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
     * @param text
     *            例：yyyy-MM-dd HH:mm:ss
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

}
