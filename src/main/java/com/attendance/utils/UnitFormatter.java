package com.attendance.utils;

import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;

/**
 * 数据单位格式化<br>
 * <br>
 * 
 * 【强制】所有金额单位统一为分，所有体积单位统一为立方分米, 所有重量单位统一为克，所有长度单位统一为毫米。通过合理的设计避免使用小数类型。
 * 
 * @author Sine
 * @date 2018/10/13
 */
public class UnitFormatter {

    /**
     * 格式化数据库内人民币金额（分）为元<br>
     * 带逗号分隔，带人民币符号
     * 
     * @param amount
     * @return
     */
    public static String amount(Integer amount) {
        return amount(amount, true, true);
    }

    /**
     * 格式化数据库内人民币金额（分）为元<br>
     * 
     * @param amount 金额
     * @param currencySign 是否带有人民币符号
     * @param split 整数部分是否带有逗号分隔
     * @return
     */
    public static String amount(Integer amount, boolean currencySign, boolean split) {
        StringBuffer sb = new StringBuffer();
        if (currencySign) {
            sb.append("￥");
        }
        if (amount < 0) {
            sb.append("-");
            amount = -amount;
        }
        String amountStr = String.valueOf(amount);
        int strLen = amountStr.length();
        if (strLen == 1) {
            sb.append("0.0").append(amountStr);
        } else if (strLen == 2) {
            sb.append("0.").append(amountStr);
        } else {
            if (split) {
                int integerLen = strLen - 2;
                int offset = (integerLen - 1) % 3;
                for (int i = 0; i < integerLen; i++) {
                    sb.append(amountStr.charAt(i));
                    if (i % 3 == offset) {
                        sb.append(",");
                    }
                }
                sb.setLength(sb.length() - 1);
                sb.append(".").append(amountStr.charAt(strLen - 2)).append(amountStr.charAt(strLen - 1));
            } else {
                sb.append(amountStr);
                sb.insert(sb.length() - 2, ".");
            }
        }
        return sb.toString();
    }

    /**
     * 转换为int，如果给定的值为空，或者转换失败，返回默认值
     * 
     * @author duanxiong
     * @date 2018/10/31 下午4:49:55
     * @param value 被转换的值
     * @param defaultValue 转换错误时的默认值
     * @return
     */
    public static Integer toInt(Object value, Integer defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        if (value instanceof Integer) {
            return (Integer)value;
        }
        final String valueStr = value.toString();
        if (StringUtils.isBlank(valueStr)) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(valueStr);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * 转换为int,默认值0
     * 
     * @author duanxiong
     * @date 2018/10/31 下午4:50:54
     * @param value
     * @return
     */
    public static Integer toInt(Object value) {
        return toInt(value, 0);
    }

    /**
     * 转换为long,如果给定的值为空，或者转换失败，返回默认值
     * 
     * @author duanxiong
     * @date 2018/10/31 下午4:51:38
     * @param value 被转换的值
     * @param defaultValue 转换错误时的默认值
     * @return
     */
    public static Long toLong(Object value, Long defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        if (value instanceof Long) {
            return (Long)value;
        }
        final String valueStr = value.toString();
        if (StringUtils.isBlank(valueStr)) {
            return defaultValue;
        }
        try {
            return new BigDecimal(valueStr).longValue();
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * vivi 数字格式化显示 小于万默认显示 大于万以1.7万方式,显示最大是9999.9万 大于亿以1.1亿方式显示最大没有限制都是亿单位 vivi
     * 
     * @param num 需要格式化的数字
     * @param kBool 是否格式化千,为true,并且num大于999就显示999+,小于等于999就正常显示
     * @param unit 格式化的单位
     * @param roundNum 保留的小数位
     * @param roundMethod 使用的模式
     * @return
     */
    public static String formatMoneyUnit(String num, Boolean kBool, String unit, Integer roundNum,
        Integer roundMethod) {
        StringBuffer sb = new StringBuffer();
        if (!StringUtils.isNumeric(num))
            return "0" + unit;

        if (kBool == null)
            kBool = false;

        if (roundNum == null)
            roundNum = 2;

        if (roundMethod == null)
            roundMethod = BigDecimal.ROUND_HALF_UP;

        BigDecimal b0 = new BigDecimal("1000");
        BigDecimal b1 = new BigDecimal("10000");
        BigDecimal b2 = new BigDecimal("100000000");
        BigDecimal b3 = new BigDecimal(num);

        String formatNumStr = "";
        BigDecimal money = null;
        // 以千为单位处理
        if (kBool) {
            if (b3.compareTo(b0) == 0 || b3.compareTo(b0) == 1) {
                return "999+";
            }
            return num;
        }

        // 以万为单位处理
        if (b3.compareTo(b1) == -1) {
            sb.append(b3.toString());
        } else if ((b3.compareTo(b1) == 0 && b3.compareTo(b1) == 1) || b3.compareTo(b2) == -1) {
            money = b3.divide(b1).setScale(roundNum, roundMethod);
            if (StringUtils.isEmpty(unit)) {
                unit = "万";
            }
        } else if (b3.compareTo(b2) == 0 || b3.compareTo(b2) == 1) {
            money = b3.divide(b2).setScale(roundNum, roundMethod);
            if (StringUtils.isEmpty(unit)) {
                unit = "亿";
            }
        }

        // 格式化完成之后得出结果
        formatNumStr = money.toString();
        if (!"".equals(formatNumStr)) {
            int i = formatNumStr.indexOf(".");
            if (i == -1) {
                sb.append(formatNumStr).append(unit);
            } else {
                i = i + 1;
                String v = formatNumStr.substring(i, i + 1);
                if (!v.equals("0")) {
                    sb.append(formatNumStr.substring(0, i + 1)).append(unit);
                } else {
                    sb.append(formatNumStr.substring(0, i - 1)).append(unit);
                }
            }
        }
        if (sb.length() == 0)
            return "0";
        return sb.toString();
    }

    public static void main(String[] args) {
        String date = UnitFormatter.formatMoneyUnit("227809", false, "w", 1, null);
        // Date date1 = DateUtil.parseStringToDate("2019-03-25 18:15:40", DateUtil.DATETIME_PATTERN);
        // long min = DateUtil.subtraction(date, date1);

        System.out.print(date + "==============");

    }
}
