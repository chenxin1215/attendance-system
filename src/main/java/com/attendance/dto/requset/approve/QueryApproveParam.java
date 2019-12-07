package com.attendance.dto.requset.approve;

import java.io.Serializable;
import java.util.Date;

public class QueryApproveParam implements Serializable {

    /**
     * 发起人ID
     */
    private Long approvalUserId;

    /**
     * 审批类型
     */
    private Integer approvalType;

    private Date startDate;

    private Date endDate;

    public Long getApprovalUserId() {
        return approvalUserId;
    }

    public void setApprovalUserId(Long approvalUserId) {
        this.approvalUserId = approvalUserId;
    }

    public Integer getApprovalType() {
        return approvalType;
    }

    public void setApprovalType(Integer approvalType) {
        this.approvalType = approvalType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
