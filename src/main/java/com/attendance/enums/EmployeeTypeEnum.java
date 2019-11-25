package com.attendance.enums;

import java.util.EnumMap;

public enum EmployeeTypeEnum {
    /** 普通员工 */
    WORKER(1),
    /** 管理员 */
    ADMINISTRATOR(2);

    private int value;

    private static final EnumMap<EmployeeTypeEnum, String> TEXT_MAP = new EnumMap<EmployeeTypeEnum, String>(EmployeeTypeEnum.class);
    static {
        TEXT_MAP.put(EmployeeTypeEnum.WORKER, "普通员工");
        TEXT_MAP.put(EmployeeTypeEnum.ADMINISTRATOR, "管理员");
    }

    EmployeeTypeEnum(int value) {
        this.value = value;
    }

    public static EmployeeTypeEnum parse(int value) {
        for (EmployeeTypeEnum outboundType : EmployeeTypeEnum.values()) {
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
