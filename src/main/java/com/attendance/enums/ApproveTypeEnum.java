package com.attendance.enums;

import java.util.EnumMap;

/**
 * 审批类型枚举
 *
 * @Author: chenxin
 * @Date: 2019/12/6
 */
public enum ApproveTypeEnum {

    /** 加班 */
    OVERTIME(1),
    /** 请假 */
    LEAVE(2);

    private int value;

    private static final EnumMap<ApproveTypeEnum, String> TEXT_MAP =
        new EnumMap<ApproveTypeEnum, String>(ApproveTypeEnum.class);
    static {
        TEXT_MAP.put(ApproveTypeEnum.OVERTIME, "待审核");
        TEXT_MAP.put(ApproveTypeEnum.LEAVE, "已审核");
    }

    ApproveTypeEnum(int value) {
        this.value = value;
    }

    public static ApproveTypeEnum parse(int value) {
        for (ApproveTypeEnum outboundType : ApproveTypeEnum.values()) {
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
