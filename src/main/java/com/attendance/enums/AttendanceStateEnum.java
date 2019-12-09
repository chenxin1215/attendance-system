package com.attendance.enums;

import java.util.EnumMap;

/**
 * 〈一句话功能简述〉<br>
 * 〈考勤状态〉
 *
 * @author xx
 * @create 2019/11/25
 * @since 1.0.0
 */
public enum AttendanceStateEnum {

    /** 正常 */
    NORMAL(1),
    /** 异常 */
    EXCEPTION(2),
    /** 旷工 */
    ABSENTEEISM(3),
    /** 加班 */
    OVERTIME(4);

    private int value;

    private static final EnumMap<AttendanceStateEnum, String> TEXT_MAP =
        new EnumMap<AttendanceStateEnum, String>(AttendanceStateEnum.class);
    static {
        TEXT_MAP.put(AttendanceStateEnum.NORMAL, "正常");
        TEXT_MAP.put(AttendanceStateEnum.EXCEPTION, "异常");
        TEXT_MAP.put(AttendanceStateEnum.ABSENTEEISM, "旷工");
        TEXT_MAP.put(AttendanceStateEnum.OVERTIME, "加班");
    }

    AttendanceStateEnum(int value) {
        this.value = value;
    }

    public static AttendanceStateEnum parse(int value) {
        for (AttendanceStateEnum outboundType : AttendanceStateEnum.values()) {
            if (value == outboundType.value) {
                return outboundType;
            }
        }
        throw new RuntimeException("无法解析的支出类别值 value=" + value);
    }

    public int value() {
        return value;
    }

    public String toString() {
        return TEXT_MAP.get(this);
    }

}
