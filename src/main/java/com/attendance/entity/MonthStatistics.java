package com.attendance.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * month_statistics
 * @author 
 */
public class MonthStatistics implements Serializable {
    /**
     * 每月统计记录表Id
     */
    private Long id;

    /**
     * 员工编号
     */
    private Long employeeId;

    /**
     * 员工姓名
     */
    private String employeeName;

    /**
     * 出勤天数
     */
    private Integer workDay;

    /**
     * 迟到次数
     */
    private Integer latenessNum;

    /**
     * 迟到时长（分钟）
     */
    private Integer latenessTime;

    /**
     * 早退次数
     */
    private Integer earlyNum;

    /**
     * 早退时长（分钟）
     */
    private Integer earlyTime;

    /**
     * 缺卡次数
     */
    private Integer missNum;

    /**
     * 加班次数
     */
    private Integer overtimeNum;

    /**
     * 旷工天数
     */
    private Integer absenteeismDay;

    /**
     * 请假天数
     */
    private Integer leaveDay;

    /**
     * 累计工作时间
     */
    private Integer workTime;

    /**
     * 累计请假时间
     */
    private Integer eaveTime;

    /**
     * 累计加班时间
     */
    private Integer overTime;

    /**
     * 欠缺时间
     */
    private Integer remainingTime;

    /**
     * 富余时间
     */
    private Integer slackTime;

    /**
     * 年份
     */
    private Integer years;

    /**
     * 月份
     */
    private Integer months;

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
     * 获取每月统计记录表Id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置每月统计记录表Id
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
     * 获取出勤天数
     */
    public Integer getWorkDay() {
        return workDay;
    }

    /**
     * 设置出勤天数
     */
    public void setWorkDay(Integer workDay) {
        this.workDay = workDay;
    }

    /**
     * 获取迟到次数
     */
    public Integer getLatenessNum() {
        return latenessNum;
    }

    /**
     * 设置迟到次数
     */
    public void setLatenessNum(Integer latenessNum) {
        this.latenessNum = latenessNum;
    }

    /**
     * 获取迟到时长（分钟）
     */
    public Integer getLatenessTime() {
        return latenessTime;
    }

    /**
     * 设置迟到时长（分钟）
     */
    public void setLatenessTime(Integer latenessTime) {
        this.latenessTime = latenessTime;
    }

    /**
     * 获取早退次数
     */
    public Integer getEarlyNum() {
        return earlyNum;
    }

    /**
     * 设置早退次数
     */
    public void setEarlyNum(Integer earlyNum) {
        this.earlyNum = earlyNum;
    }

    /**
     * 获取早退时长（分钟）
     */
    public Integer getEarlyTime() {
        return earlyTime;
    }

    /**
     * 设置早退时长（分钟）
     */
    public void setEarlyTime(Integer earlyTime) {
        this.earlyTime = earlyTime;
    }

    /**
     * 获取缺卡次数
     */
    public Integer getMissNum() {
        return missNum;
    }

    /**
     * 设置缺卡次数
     */
    public void setMissNum(Integer missNum) {
        this.missNum = missNum;
    }

    /**
     * 获取加班次数
     */
    public Integer getOvertimeNum() {
        return overtimeNum;
    }

    /**
     * 设置加班次数
     */
    public void setOvertimeNum(Integer overtimeNum) {
        this.overtimeNum = overtimeNum;
    }

    /**
     * 获取旷工天数
     */
    public Integer getAbsenteeismDay() {
        return absenteeismDay;
    }

    /**
     * 设置旷工天数
     */
    public void setAbsenteeismDay(Integer absenteeismDay) {
        this.absenteeismDay = absenteeismDay;
    }

    /**
     * 获取请假天数
     */
    public Integer getLeaveDay() {
        return leaveDay;
    }

    /**
     * 设置请假天数
     */
    public void setLeaveDay(Integer leaveDay) {
        this.leaveDay = leaveDay;
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
     * 获取累计请假时间
     */
    public Integer getEaveTime() {
        return eaveTime;
    }

    /**
     * 设置累计请假时间
     */
    public void setEaveTime(Integer eaveTime) {
        this.eaveTime = eaveTime;
    }

    /**
     * 获取累计加班时间
     */
    public Integer getOverTime() {
        return overTime;
    }

    /**
     * 设置累计加班时间
     */
    public void setOverTime(Integer overTime) {
        this.overTime = overTime;
    }

    /**
     * 获取欠缺时间
     */
    public Integer getRemainingTime() {
        return remainingTime;
    }

    /**
     * 设置欠缺时间
     */
    public void setRemainingTime(Integer remainingTime) {
        this.remainingTime = remainingTime;
    }

    /**
     * 获取富余时间
     */
    public Integer getSlackTime() {
        return slackTime;
    }

    /**
     * 设置富余时间
     */
    public void setSlackTime(Integer slackTime) {
        this.slackTime = slackTime;
    }

    /**
     * 获取年份
     */
    public Integer getYears() {
        return years;
    }

    /**
     * 设置年份
     */
    public void setYears(Integer years) {
        this.years = years;
    }

    /**
     * 获取月份
     */
    public Integer getMonths() {
        return months;
    }

    /**
     * 设置月份
     */
    public void setMonths(Integer months) {
        this.months = months;
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