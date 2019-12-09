package com.attendance.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * attendance_info
 * 
 * @author
 */
public class AttendanceInfo implements Serializable {
    /**
     * 出勤记录编号
     */
    @TableId(value = "id", type = IdType.AUTO) // 指定自增策略
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
     * 上班打卡时间
     */
    private Date punchInTime;

    /**
     * 上班打卡状态 1-正常；2-迟到；3-缺卡
     */
    private Integer punchInState;

    private Date punchOutTime;

    /**
     * 下班打卡状态 1-正常；2-早退；3-缺卡
     */
    private Integer punchOutState;

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
     * 出勤状态 1：正常；2：异常；3：旷工
     */
    private Integer state;

    /**
     * 迟到标识
     */
    private Boolean lateSign;

    /**
     * 早退标识
     */
    private Boolean earlySign;

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
     * 获取上班打卡时间
     */
    public Date getPunchInTime() {
        return punchInTime;
    }

    /**
     * 设置上班打卡时间
     */
    public void setPunchInTime(Date punchInTime) {
        this.punchInTime = punchInTime;
    }

    /**
     * 获取上班打卡状态 1-正常；2-迟到；3-缺卡
     */
    public Integer getPunchInState() {
        return punchInState;
    }

    /**
     * 设置上班打卡状态 1-正常；2-迟到；3-缺卡
     */
    public void setPunchInState(Integer punchInState) {
        this.punchInState = punchInState;
    }

    public Date getPunchOutTime() {
        return punchOutTime;
    }

    public void setPunchOutTime(Date punchOutTime) {
        this.punchOutTime = punchOutTime;
    }

    /**
     * 获取下班打卡状态 1-正常；2-早退；3-缺卡
     */
    public Integer getPunchOutState() {
        return punchOutState;
    }

    /**
     * 设置下班打卡状态 1-正常；2-早退；3-缺卡
     */
    public void setPunchOutState(Integer punchOutState) {
        this.punchOutState = punchOutState;
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
     * 获取出勤状态 1：正常；2：异常；3：旷工
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置出勤状态 1：正常；2：异常；3：旷工
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
}