package com.attendance.enums;

import java.util.EnumMap;

/**
 * 职务枚举
 */
public enum BreakTypeEnum {

    /** 单休 */
    SINGLE(1),
    /** 双休 */
    DOUBLE(2);

    private int value;

    private static final EnumMap<BreakTypeEnum, String> TEXT_MAP =
        new EnumMap<BreakTypeEnum, String>(BreakTypeEnum.class);
    static {
        TEXT_MAP.put(BreakTypeEnum.SINGLE, "单休");
        TEXT_MAP.put(BreakTypeEnum.DOUBLE, "双休");
    }

    BreakTypeEnum(int value) {
        this.value = value;
    }

    public static BreakTypeEnum parse(int value) {
        for (BreakTypeEnum outboundType : BreakTypeEnum.values()) {
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
