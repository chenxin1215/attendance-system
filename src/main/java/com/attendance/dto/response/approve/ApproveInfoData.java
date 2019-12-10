package com.attendance.dto.response.approve;

import com.attendance.entity.ApproveInfo;

/**
 * 审批信息数据
 *
 * @Author: chenxin
 * @Date: 2019/12/6
 */
public class ApproveInfoData extends ApproveInfo {

    /**
     * 审批时间
     */
    private String approveTimeStr;

    /**
     * 审批类型 1：请假；2：加班
     */
    private String approveTypeStr;

    /**
     * 审批状态 1：待审核；2：已审核；3：已拒绝
     */
    private String approveStateStr;

    private String createTimeStr;

    public String getApproveTimeStr() {
        return approveTimeStr;
    }

    public void setApproveTimeStr(String approveTimeStr) {
        this.approveTimeStr = approveTimeStr;
    }

    public String getApproveTypeStr() {
        return approveTypeStr;
    }

    public void setApproveTypeStr(String approveTypeStr) {
        this.approveTypeStr = approveTypeStr;
    }

    public String getApproveStateStr() {
        return approveStateStr;
    }

    public void setApproveStateStr(String approveStateStr) {
        this.approveStateStr = approveStateStr;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }
}
