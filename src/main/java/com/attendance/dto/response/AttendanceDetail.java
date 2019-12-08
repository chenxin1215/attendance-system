package com.attendance.dto.response;

import com.attendance.entity.AttendanceInfo;

/**
 * 〈一句话功能简述〉<br>
 * 〈考勤信息详情(日)〉
 *
 * @author xx
 * @create 2019/11/25
 * @since 1.0.0
 */
public class AttendanceDetail extends AttendanceInfo {

    private String stateStr;

    private String punchInTimeStr;

    private String punchInStateStr;

    private String punchOutTimeStr;

    private String punchOutStateStr;

    private String createTimeStr;

    public String getStateStr() {
        return stateStr;
    }

    public void setStateStr(String stateStr) {
        this.stateStr = stateStr;
    }

    public String getPunchInTimeStr() {
        return punchInTimeStr;
    }

    public void setPunchInTimeStr(String punchInTimeStr) {
        this.punchInTimeStr = punchInTimeStr;
    }

    public String getPunchInStateStr() {
        return punchInStateStr;
    }

    public void setPunchInStateStr(String punchInStateStr) {
        this.punchInStateStr = punchInStateStr;
    }

    public String getPunchOutTimeStr() {
        return punchOutTimeStr;
    }

    public void setPunchOutTimeStr(String punchOutTimeStr) {
        this.punchOutTimeStr = punchOutTimeStr;
    }

    public String getPunchOutStateStr() {
        return punchOutStateStr;
    }

    public void setPunchOutStateStr(String punchOutStateStr) {
        this.punchOutStateStr = punchOutStateStr;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }
}