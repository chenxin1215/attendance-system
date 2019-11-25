package com.attendance.enums;

import java.util.EnumMap;

public enum EmployeeStateEnum {
    /** 在职 */
    ONJOB(1),
    /** 离职 */
    QUITJOB(2);

    private int value;

    private static final EnumMap<EmployeeStateEnum, String> TEXT_MAP = new EnumMap<EmployeeStateEnum, String>(EmployeeStateEnum.class);
    static {
        TEXT_MAP.put(EmployeeStateEnum.ONJOB, "普通员工");
        TEXT_MAP.put(EmployeeStateEnum.QUITJOB, "管理员");
    }

    EmployeeStateEnum(int value) {
        this.value = value;
    }

    public static EmployeeStateEnum parse(int value) {
        for (EmployeeStateEnum outboundType : EmployeeStateEnum.values()) {
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
