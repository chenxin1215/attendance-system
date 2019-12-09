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

    public static void main(String[] args) {
        Date date = new Date();
        Date s = DateUtil.dateToDate(date, TIME_BASE);
        System.out.println(s);
    }

    /**
     * 功能描述: stringToDate
     *
     * @Author: chenxin
     * @Date: 2019/12/9
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

    /**
     * 功能描述: 日期转string
     *
     * @Author: chenxin
     * @Date: 2019/12/9
     */
    public static String dateToString(Date date, String text) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(text);

        return simpleDateFormat.format(date);
    }

    public static Date dateToDate(Date date, String text) {
        return stringToDate(dateToString(date, text), text);
    }

    /**
     * 功能描述: 设置时间为当前的0点0分0秒
     *
     * @Author: chenxin
     * @Date: 2019/12/9
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
     * 功能描述: 设置时间为23点59分59秒
     *
     * @Author: chenxin
     * @Date: 2019/12/9
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

    /**
     * 功能描述: 设置时间为 下午两点
     *
     * @Author: chenxin
     * @Date: 2019/12/9
     */
    public static Date getLessPunchInTime(Date date) {
        if (date == null) {
            return null;
        }

        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.set(Calendar.HOUR_OF_DAY, 14);
        instance.set(Calendar.MINUTE, 00);
        instance.set(Calendar.SECOND, 00);
        instance.set(Calendar.MILLISECOND, 999);

        return instance.getTime();
    }

    /**
     * 获得分钟数
     *
     * @author chenxin
     * @date 2018/10/31 下午8:14:49
     * @param date 待处理的日期，null表示取当天
     * @return
     */
    public static int getMinute(Date date) {
        Calendar cal = toCalendar(date);
        return cal.get(Calendar.MINUTE);
    }

    /**
     * 获取日期的小时
     *
     * @author chenxin
     * @date 2018/10/31 下午8:11:02
     * @param date 待处理的日期，null表示取当天
     * @return
     */
    public static int getHour(Date date) {
        Calendar cal = toCalendar(date);
        return cal.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获得日期的天
     *
     * @author chenxin
     * @date 2018/10/31 下午7:30:40
     * @param date 待处理的日期，null表示取当天
     * @return
     */
    public static int getDay(Date date) {
        Calendar cal = toCalendar(date);
        return cal.get(Calendar.DATE);
    }

    /**
     * 获取当前日期是周几（中国时间制）
     *
     * @author chenxin
     * @date 2018/10/31 下午8:13:59
     * @param date 日期
     * @return 周几的值，如周一则返回1
     */
    public static int getDayByWeek(Date date) {
        Calendar cal = toCalendar(date);
        cal.add(Calendar.DAY_OF_MONTH, -1); // 解决周日会出现 并到下一周的情况
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * 返回该日期为当月第几天
     *
     * @author chenxin
     * @date 2018/10/31 下午8:12:11
     * @param date 待处理的日期，null表示取当天
     * @return
     */
    public static int getDayOfMonth(Date date) {
        Calendar cal = toCalendar(date);
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获得日期的月
     *
     * @author chenxin
     * @date 2018/10/31 下午7:35:48
     * @param date 待处理的日期，null表示取当天
     * @return
     */
    public static int getMonth(Date date) {
        Calendar cal = toCalendar(date);
        return cal.get(Calendar.MONTH) + 1;
    }

    /**
     * 获得日期的年
     *
     * @author chenxin
     * @date 2018/10/31 下午4:14:53
     * @param date 待处理的日期，null表示取当天
     * @return
     */
    public static int getYear(Date date) {
        Calendar cal = toCalendar(date);
        return cal.get(Calendar.YEAR);
    }

    /**
     * Date转Calendar
     *
     * @author chenxin
     * @date 2018/10/31 下午6:01:25
     * @param date
     * @return
     */
    private static Calendar toCalendar(final Date date) {
        final Calendar c = Calendar.getInstance();
        if (date != null) {
            c.setTime(date);
        }
        return c;
    }

    /**
     * 获得两个时间字符串的时间差(以小时为单位)
     * 
     * @param date1 小日期
     * @param date2 大日期
     * @param dformat 两个日期字符串的格式
     * @return
     */
    public static int subHouse(Date date1, Date date2, String dformat) {
        return subHouse(DateUtil.dateToString(date1, dformat), DateUtil.dateToString(date2, dformat), dformat);
    }

    /**
     * 获得两个时间字符串的时间差(以小时为单位)
     *
     * @author chenxin
     * @date 2018/10/31 下午6:50:49
     * @param date1 小日期
     * @param date2 大日期
     * @param dformat 两个日期字符串的格式
     * @return
     */
    public static int subHouse(String date1, String date2, String dformat) {
        long between_days = subtraction(date1, date2, dformat) / (1000 * 3600 * 24);
        return UnitFormatter.toInt(between_days);
    }

    /**
     * 功能描述: 获得两个时间字符串的时间差(以天为单位)
     *
     * @Author: chenxin
     * @param date1 小日期
     * @param date2 大日期
     * @Date: 2019/12/9
     */
    public static int subDay(Date date1, Date date2) {
        long between_days = subtraction(date1, date2) / (1000 * 3600 * 24);
        return UnitFormatter.toInt(between_days);
    }

    /**
     * 获得两个时间字符串的时间差，精确到毫秒
     *
     * @author chenxin
     * @date 2018/10/31 下午4:30:31
     * @param sdate 小日期
     * @param bdate 大日期
     * @param dformat 两个日期字符串的格式
     * @return
     */
    public static long subtraction(String sdate, String bdate, String dformat) {
        return subtraction(stringToDate(sdate, dformat), stringToDate(bdate, dformat));
    }

    /**
     * 功能描述: 两个时间差，精确到毫秒
     *
     * @Author: chenxin
     * @Date: 2019/12/9
     */
    public static long subtraction(Date sdate, Date bdate) {
        if (sdate == null || bdate == null) {
            return 0;
        }
        return bdate.getTime() - sdate.getTime();
    }

    /**
     * 功能描述: 取某个日期当月第一天的日期
     *
     * @Author: chenxin
     * @Date: 2019/12/9
     */
    public static Date getFirstDayOfMonth(Date date) {
        Calendar c = toCalendar(date);
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    /**
     * 功能描述: 取某个日期当月最后一天的日期
     *
     * @Author: chenxin
     * @Date: 2019/12/9
     */
    public static Date getLastDayOfMonth(Date date) {
        Calendar c = toCalendar(date);
        int d = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        c.set(Calendar.DAY_OF_MONTH, d);
        return c.getTime();
    }

}
