package com.attendance.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * approve_info
 * 
 * @author
 */
public class ApproveInfo implements Serializable {
    /**
     * 审批编号
     */
    @TableId(value = "id",type = IdType.AUTO)//指定自增策略
    private Long approveId;

    /**
     * 发起人id
     */
    private Long employeeId;

    /**
     * 发起人姓名
     */
    private String employeeName;

    /**
     * 审批类型 1：请假；2：加班
     */
    private Integer approveType;

    /**
     * 请假表id
     */
    private Long leaveId;

    /**
     * 加班表id
     */
    private Long overtimeId;

    /**
     * 开始时间
     */
    private Date startDate;

    /**
     * 结束时间
     */
    private Date endDate;

    /**
     * 发起审批理由
     */
    private String approveReason;

    /**
     * 审批状态 1：待审核；2：已审核；3：已拒绝
     */
    private Integer approveState;

    /**
     * 审批人id
     */
    private Long approveUserId;

    /**
     * 审批人
     */
    private String approvePerson;

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
     * 获取审批编号
     */
    public Long getApproveId() {
        return approveId;
    }

    /**
     * 设置审批编号
     */
    public void setApproveId(Long approveId) {
        this.approveId = approveId;
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
     * 获取员工姓名
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * 设置员工姓名
     */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    /**
     * 获取审批类型 1：请假；2：加班
     */
    public Integer getApproveType() {
        return approveType;
    }

    /**
     * 设置审批类型 1：请假；2：加班
     */
    public void setApproveType(Integer approveType) {
        this.approveType = approveType;
    }

    /**
     * 获取请假表id
     */
    public Long getLeaveId() {
        return leaveId;
    }

    /**
     * 设置请假表id
     */
    public void setLeaveId(Long leaveId) {
        this.leaveId = leaveId;
    }

    /**
     * 获取加班表id
     */
    public Long getOvertimeId() {
        return overtimeId;
    }

    /**
     * 设置加班表id
     */
    public void setOvertimeId(Long overtimeId) {
        this.overtimeId = overtimeId;
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
     * 获取发起审批理由
     */
    public String getApproveReason() {
        return approveReason;
    }

    /**
     * 设置发起审批理由
     */
    public void setApproveReason(String approveReason) {
        this.approveReason = approveReason;
    }

    /**
     * 获取审批状态 1：待审核；2：已审核；3：已拒绝
     */
    public Integer getApproveState() {
        return approveState;
    }

    /**
     * 设置审批状态 1：待审核；2：已审核；3：已拒绝
     */
    public void setApproveState(Integer approveState) {
        this.approveState = approveState;
    }

    /**
     * 获取审批人
     */
    public String getApprovePerson() {
        return approvePerson;
    }

    /**
     * 设置审批人
     */
    public void setApprovePerson(String approvePerson) {
        this.approvePerson = approvePerson;
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

    public Long getApproveUserId() {
        return approveUserId;
    }

    public void setApproveUserId(Long approveUserId) {
        this.approveUserId = approveUserId;
    }
}