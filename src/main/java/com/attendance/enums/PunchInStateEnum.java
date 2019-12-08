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
public enum PunchInStateEnum {

    /** 正常 */
    NORMAL(1),
    /** 迟到 */
    LATE(2),
    /** 缺卡 */
    LESS(3);

    private int value;

    private static final EnumMap<PunchInStateEnum, String> TEXT_MAP =
        new EnumMap<PunchInStateEnum, String>(PunchInStateEnum.class);
    static {
        TEXT_MAP.put(PunchInStateEnum.NORMAL, "正常");
        TEXT_MAP.put(PunchInStateEnum.LATE, "迟到");
        TEXT_MAP.put(PunchInStateEnum.LESS, "缺卡");
    }

    PunchInStateEnum(int value) {
        this.value = value;
    }

    public static PunchInStateEnum parse(int value) {
        for (PunchInStateEnum outboundType : PunchInStateEnum.values()) {
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
