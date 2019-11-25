package com.attendance.dto.requset;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br>
 * 〈发起审批参数〉
 *
 * @author xx
 * @create 2019/11/25
 * @since 1.0.0
 */
public class ApprovalRequest implements Serializable {

    /**
     * 发起人ID
     */
    private Long approvalUserId;

    /**
     * 审批类型
     */
    private Integer approvalType;

    /**
     * 开始时间
     */
    private String startDate;

    /**
     * 结束时间
     */
    private String endDate;

    /**
     * 发起审批理由
     */
    private String approvalContent;

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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getApprovalContent() {
        return approvalContent;
    }

    public void setApprovalContent(String approvalContent) {
        this.approvalContent = approvalContent;
    }
}