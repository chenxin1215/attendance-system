package com.attendance.dto.response;

/**
 * 〈一句话功能简述〉<br>
 * 〈考勤规则详情〉
 *
 * @author xx
 * @create 2019/12/8
 * @since 1.0.0
 */
public class ConfigDetail extends ConfigureInfo {

    private String workHoursStr;

    private String owHoursStr;

    public String getWorkHoursStr() {
        return workHoursStr;
    }

    public void setWorkHoursStr(String workHoursStr) {
        this.workHoursStr = workHoursStr;
    }

    public String getOwHoursStr() {
        return owHoursStr;
    }

    public void setOwHoursStr(String owHoursStr) {
        this.owHoursStr = owHoursStr;
    }
}