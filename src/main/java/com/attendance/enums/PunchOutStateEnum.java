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
public enum PunchOutStateEnum {

    /** 正常 */
    NORMAL(1),
    /** 早退 */
    EARLY(2),
    /** 缺卡 */
    LESS(3);

    private int value;

    private static final EnumMap<PunchOutStateEnum, String> TEXT_MAP =
        new EnumMap<PunchOutStateEnum, String>(PunchOutStateEnum.class);
    static {
        TEXT_MAP.put(PunchOutStateEnum.NORMAL, "正常");
        TEXT_MAP.put(PunchOutStateEnum.EARLY, "早退");
        TEXT_MAP.put(PunchOutStateEnum.LESS, "缺卡");
    }

    PunchOutStateEnum(int value) {
        this.value = value;
    }

    public static PunchOutStateEnum parse(int value) {
        for (PunchOutStateEnum outboundType : PunchOutStateEnum.values()) {
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
