package com.attendance.enums;

import java.util.EnumMap;

/**
 * 审核状态枚举
 *
 * @Author: chenxin
 * @Date: 2019/12/6
 */
public enum ApproveStateEnum {

    /** 待审核 */
    NO_CHECK(1),
    /** 已审核 */
    CHECKED(2),
    /** 已拒绝 */
    REFUSED(3);

    private int value;

    private static final EnumMap<ApproveStateEnum, String> TEXT_MAP = new EnumMap<ApproveStateEnum, String>(
			ApproveStateEnum.class);
    static {
        TEXT_MAP.put(ApproveStateEnum.NO_CHECK, "待审核");
        TEXT_MAP.put(ApproveStateEnum.CHECKED, "已审核");
        TEXT_MAP.put(ApproveStateEnum.REFUSED, "已拒绝");
    }

    ApproveStateEnum(int value) {
        this.value = value;
    }

    public static ApproveStateEnum parse(int value) {
        for (ApproveStateEnum outboundType : ApproveStateEnum.values()) {
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
