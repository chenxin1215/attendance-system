package com.attendance.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 加班信息
 * @author 
 */
public class OvertimeInfo implements Serializable {
    /**
     * 加班记录编号
     */
    private Long overtimeId;

    /**
     * 员工编号
     */
    private Long employeeId;

    /**
     * 加班开始时间
     */
    private Date overStarttime;

    /**
     * 加班结束时间
     */
    private Date overEndtime;

    /**
     * 加班日期
     */
    private Date overDate;

    /**
     * 加班理由
     */
    private String overReason;

    /**
     * 审批状态 1：待审核；2：已审核；3：已拒绝
     */
    private Byte approveState;

    /**
     * 审批信息表id
     */
    private Long approveId;

    /**
     * 完成状态
     */
    private Byte completeState;

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
     * 获取加班记录编号
     */
    public Long getOvertimeId() {
        return overtimeId;
    }

    /**
     * 设置加班记录编号
     */
    public void setOvertimeId(Long overtimeId) {
        this.overtimeId = overtimeId;
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
     * 获取加班开始时间
     */
    public Date getOverStarttime() {
        return overStarttime;
    }

    /**
     * 设置加班开始时间
     */
    public void setOverStarttime(Date overStarttime) {
        this.overStarttime = overStarttime;
    }

    /**
     * 获取加班结束时间
     */
    public Date getOverEndtime() {
        return overEndtime;
    }

    /**
     * 设置加班结束时间
     */
    public void setOverEndtime(Date overEndtime) {
        this.overEndtime = overEndtime;
    }

    /**
     * 获取加班日期
     */
    public Date getOverDate() {
        return overDate;
    }

    /**
     * 设置加班日期
     */
    public void setOverDate(Date overDate) {
        this.overDate = overDate;
    }

    /**
     * 获取加班理由
     */
    public String getOverReason() {
        return overReason;
    }

    /**
     * 设置加班理由
     */
    public void setOverReason(String overReason) {
        this.overReason = overReason;
    }

    /**
     * 获取审批状态 1：待审核；2：已审核；3：已拒绝
     */
    public Byte getApproveState() {
        return approveState;
    }

    /**
     * 设置审批状态 1：待审核；2：已审核；3：已拒绝
     */
    public void setApproveState(Byte approveState) {
        this.approveState = approveState;
    }

    /**
     * 获取审批信息表id
     */
    public Long getApproveId() {
        return approveId;
    }

    /**
     * 设置审批信息表id
     */
    public void setApproveId(Long approveId) {
        this.approveId = approveId;
    }

    /**
     * 获取完成状态
     */
    public Byte getCompleteState() {
        return completeState;
    }

    /**
     * 设置完成状态
     */
    public void setCompleteState(Byte completeState) {
        this.completeState = completeState;
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