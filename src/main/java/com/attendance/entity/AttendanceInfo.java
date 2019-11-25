package com.attendance.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 每日考勤信息
 * 
 * @author
 */
public class AttendanceInfo implements Serializable {

    /**
     * 出勤记录编号
     */
    private Long attendanceId;

    /**
     * 员工编号
     */
    private Long employeeId;

    /**
     * 员工姓名
     */
    private String employeeName;

    /**
     * 上班时间
     */
    private Date onworkTime;

    /**
     * 下班时间
     */
    private Date offworkTime;

    /**
     * 记录年份
     */
    private Integer recordYear;

    /**
     * 记录月份
     */
    private Integer recordMonth;

    /**
     * 记录天份
     */
    private Integer recordDay;

    /**
     * 出勤状态 1：正常；2：缺卡；3：旷工
     */
    private Integer state;

    /**
     * 迟到标识
     */
    private Boolean lateSign;

    /**
     * 迟到时长（分钟）
     */
    private Integer latenessTime;

    /**
     * 早退标识
     */
    private Boolean earlySign;

    /**
     * 早退时长（分钟）
     */
    private Integer earlyTime;

    /**
     * 累计工作时间
     */
    private Integer workTime;

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
     * 获取出勤记录编号
     */
    public Long getAttendanceId() {
        return attendanceId;
    }

    /**
     * 设置出勤记录编号
     */
    public void setAttendanceId(Long attendanceId) {
        this.attendanceId = attendanceId;
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
     * 获取上班时间
     */
    public Date getOnworkTime() {
        return onworkTime;
    }

    /**
     * 设置上班时间
     */
    public void setOnworkTime(Date onworkTime) {
        this.onworkTime = onworkTime;
    }

    /**
     * 获取下班时间
     */
    public Date getOffworkTime() {
        return offworkTime;
    }

    /**
     * 设置下班时间
     */
    public void setOffworkTime(Date offworkTime) {
        this.offworkTime = offworkTime;
    }

    /**
     * 获取记录年份
     */
    public Integer getRecordYear() {
        return recordYear;
    }

    /**
     * 设置记录年份
     */
    public void setRecordYear(Integer recordYear) {
        this.recordYear = recordYear;
    }

    /**
     * 获取记录月份
     */
    public Integer getRecordMonth() {
        return recordMonth;
    }

    /**
     * 设置记录月份
     */
    public void setRecordMonth(Integer recordMonth) {
        this.recordMonth = recordMonth;
    }

    /**
     * 获取记录天份
     */
    public Integer getRecordDay() {
        return recordDay;
    }

    /**
     * 设置记录天份
     */
    public void setRecordDay(Integer recordDay) {
        this.recordDay = recordDay;
    }

    /**
     * 获取出勤状态 1：正常；2：缺卡；3：旷工
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置出勤状态 1：正常；2：缺卡；3：旷工
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取迟到标识
     */
    public Boolean getLateSign() {
        return lateSign;
    }

    /**
     * 设置迟到标识
     */
    public void setLateSign(Boolean lateSign) {
        this.lateSign = lateSign;
    }

    /**
     * 获取早退标识
     */
    public Boolean getEarlySign() {
        return earlySign;
    }

    /**
     * 设置早退标识
     */
    public void setEarlySign(Boolean earlySign) {
        this.earlySign = earlySign;
    }

    /**
     * 获取累计工作时间
     */
    public Integer getWorkTime() {
        return workTime;
    }

    /**
     * 设置累计工作时间
     */
    public void setWorkTime(Integer workTime) {
        this.workTime = workTime;
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

    public Integer getLatenessTime() {
        return latenessTime;
    }

    public void setLatenessTime(Integer latenessTime) {
        this.latenessTime = latenessTime;
    }

    public Integer getEarlyTime() {
        return earlyTime;
    }

    public void setEarlyTime(Integer earlyTime) {
        this.earlyTime = earlyTime;
    }
}