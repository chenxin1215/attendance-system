package com.attendance.dto.response;

import com.attendance.entity.AttendenceInfo;

/**
 * 〈一句话功能简述〉<br>
 * 〈考勤信息详情(日)〉
 *
 * @author xx
 * @create 2019/11/25
 * @since 1.0.0
 */
public class AttendanceDetail extends AttendenceInfo {

    /**
     * 考勤状态
     */
    private String stateStr;

    /**
     * 上班打卡时间
     */
    private String onworkTimeStr;

    /**
     * 下班打卡时间
     */
    private String offworkTimeStr;

    /**
     * 今日工作时长（小时）
     */
    private Float workTimeHourse;

    public String getStateStr() {
        return stateStr;
    }

    public void setStateStr(String stateStr) {
        this.stateStr = stateStr;
    }

    public String getOnworkTimeStr() {
        return onworkTimeStr;
    }

    public void setOnworkTimeStr(String onworkTimeStr) {
        this.onworkTimeStr = onworkTimeStr;
    }

    public String getOffworkTimeStr() {
        return offworkTimeStr;
    }

    public void setOffworkTimeStr(String offworkTimeStr) {
        this.offworkTimeStr = offworkTimeStr;
    }

    public Float getWorkTimeHourse() {
        return workTimeHourse;
    }

    public void setWorkTimeHourse(Float workTimeHourse) {
        this.workTimeHourse = workTimeHourse;
    }

}