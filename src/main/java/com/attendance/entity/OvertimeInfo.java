package com.attendance.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * overtime_info
 * 
 * @author
 */
public class OvertimeInfo implements Serializable {
    /**
     * 加班记录编号
     */
    @TableId(value = "id",type = IdType.AUTO)//指定自增策略
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
     * 审批人id
     */
    private Long approveUserId;

    /**
     * 审批时间
     */
    private Date approveTime;

    /**
     * 完成状态
     */
    private Integer completeState;

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
     * 获取审批信息表id
     */
    public Long getApproveUserId() {
        return approveUserId;
    }

    /**
     * 设置审批信息表id
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
     * 获取完成状态
     */
    public Integer getCompleteState() {
        return completeState;
    }

    /**
     * 设置完成状态
     */
    public void setCompleteState(Integer completeState) {
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