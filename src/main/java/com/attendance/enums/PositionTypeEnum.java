package com.attendance.enums;

import java.util.EnumMap;

/**
 * 职务枚举
 */
public enum PositionTypeEnum {

    /** CEO */
    CEO(1),
    /** 总监 */
    MANAGER(2),
    /** 主管 */
    DIRECTOR(3),
    /** 普通员工 */
    WORKER(4);

    private int value;

    private static final EnumMap<PositionTypeEnum, String> TEXT_MAP =
        new EnumMap<PositionTypeEnum, String>(PositionTypeEnum.class);
    static {
        TEXT_MAP.put(PositionTypeEnum.CEO, "CEO");
        TEXT_MAP.put(PositionTypeEnum.MANAGER, "总监");
        TEXT_MAP.put(PositionTypeEnum.DIRECTOR, "主管");
        TEXT_MAP.put(PositionTypeEnum.WORKER, "普通员工");
    }

    PositionTypeEnum(int value) {
        this.value = value;
    }

    public static PositionTypeEnum parse(int value) {
        for (PositionTypeEnum outboundType : PositionTypeEnum.values()) {
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
