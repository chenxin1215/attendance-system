package com.attendance.dto.response;

import com.attendance.entity.LeaveInfo;

public class LeaveDetail extends LeaveInfo {

    private String startDateStr;

    private String endDateStr;

    private String approveTimeStr;

    private String createTimeStr;

    public String getStartDateStr() {
        return startDateStr;
    }

    public void setStartDateStr(String startDateStr) {
        this.startDateStr = startDateStr;
    }

    public String getEndDateStr() {
        return endDateStr;
    }

    public void setEndDateStr(String endDateStr) {
        this.endDateStr = endDateStr;
    }

    public String getApproveTimeStr() {
        return approveTimeStr;
    }

    public void setApproveTimeStr(String approveTimeStr) {
        this.approveTimeStr = approveTimeStr;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }
}
