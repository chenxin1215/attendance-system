package com.attendance.dto.response;

import com.attendance.entity.LogInfo;

public class LogInfoDetail extends LogInfo {

    /**
     * 创建时间
     */
    private String createTimeStr;

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }
}
