package com.attendance.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * leave_info
 * 
 * @author
 */
public class LeaveInfo implements Serializable {
    /**
     * 请假记录编号
     */
    @TableId(value = "id", type = IdType.AUTO) // 指定自增策略
    private Long id;

    /**
     * 员工编号
     */
    private Long employeeId;

    /**
     * 请假理由
     */
    private String leaveReason;

    /**
     * 开始时间
     */
    private Date startDate;

    /**
     * 结束时间
     */
    private Date endDate;

    /**
     * 审批人id
     */
    private Long approveUserId;

    /**
     * 审批时间
     */
    private Date approveTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取请假记录编号
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置请假记录编号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取员工编号
     */
    public Long getEmployeeId() {
        return employeeId;
    }

    /**
     * 设置员工编号
     */
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * 获取请假理由
     */
    public String getLeaveReason() {
        return leaveReason;
    }

    /**
     * 设置请假理由
     */
    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }

    /**
     * 获取开始时间
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * 设置开始时间
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * 获取结束时间
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * 设置结束时间
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * 获取审批人id
     */
    public Long getApproveUserId() {
        return approveUserId;
    }

    /**
     * 设置审批人id
     */
    public void setApproveUserId(Long approveUserId) {
        this.approveUserId = approveUserId;
    }

    /**
     * 获取审批时间
     */
    public Date getApproveTime() {
        return approveTime;
    }

    /**
     * 设置审批时间
     */
    public void setApproveTime(Date approveTime) {
        this.approveTime = approveTime;
    }

    /**
     * 获取创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}