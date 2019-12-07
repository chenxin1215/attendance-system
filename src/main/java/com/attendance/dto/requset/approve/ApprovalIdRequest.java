package com.attendance.dto.requset.approve;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author cx
 * @create 2019/11/25
 * @since 1.0.0
 */
public class ApprovalIdRequest implements Serializable {

    /**
     * 审批记录ID
     */
    private Long approvalId;

    public Long getApprovalId() {
        return approvalId;
    }

    public void setApprovalId(Long approvalId) {
        this.approvalId = approvalId;
    }
}