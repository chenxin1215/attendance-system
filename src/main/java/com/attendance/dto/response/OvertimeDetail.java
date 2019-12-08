package com.attendance.dto.response;

import com.attendance.entity.OvertimeInfo;

/**
 * 〈一句话功能简述〉<br>
 * 〈加班详情信息〉
 *
 * @author xx
 * @create 2019-12-05
 * @since 1.0.0
 */
public class OvertimeDetail extends OvertimeInfo {

    private String overStarttimeStr;

    private String overEndtimeStr;

    private String overDateStr;

    private String approveName;

    private String approveTimeStr;

    public String getOverStarttimeStr() {
        return overStarttimeStr;
    }

    public void setOverStarttimeStr(String overStarttimeStr) {
        this.overStarttimeStr = overStarttimeStr;
    }

    public String getOverEndtimeStr() {
        return overEndtimeStr;
    }

    public void setOverEndtimeStr(String overEndtimeStr) {
        this.overEndtimeStr = overEndtimeStr;
    }

    public String getOverDateStr() {
        return overDateStr;
    }

    public void setOverDateStr(String overDateStr) {
        this.overDateStr = overDateStr;
    }

    public String getApproveName() {
        return approveName;
    }

    public void setApproveName(String approveName) {
        this.approveName = approveName;
    }

    public String getApproveTimeStr() {
        return approveTimeStr;
    }

    public void setApproveTimeStr(String approveTimeStr) {
        this.approveTimeStr = approveTimeStr;
    }
}