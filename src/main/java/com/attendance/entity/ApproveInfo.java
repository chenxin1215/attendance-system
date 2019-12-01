package com.attendance.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * approve_info
 * @author 
 */
public class ApproveInfo implements Serializable {
    /**
     * 审批编号
     */
    private Long approveId;

    /**
     * 员工编号
     */
    private Long employeeId;

    /**
     * 员工姓名
     */
    private String employeeName;

    /**
     * 审批人
     */
    private String approvePerson;

    /**
     * 审批时间
     */
    private Date approveTime;

    /**
     * 审批理由
     */
    private String approveReason;

    /**
     * 审批类型 1：请假；2：加班
     */
    private Integer approveType;

    /**
     * 审批状态 1：待审核；2：已审核；3：已拒绝
     */
    private Integer approveState;

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
     * 获取审批理由
     */
    public String getApproveReason() {
        return approveReason;
    }

    /**
     * 设置审批理由
     */
    public void setApproveReason(String approveReason) {
        this.approveReason = approveReason;
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