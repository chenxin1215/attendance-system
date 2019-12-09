package com.attendance.dto.requset.attendance;

import com.attendance.entity.PageParam;

/**
 * 〈一句话功能简述〉<br>
 * 〈考勤信息查询条件〉
 *
 * @author xx
 * @create 2019/11/25
 * @since 1.0.0
 */
public class QueryAttendanceInfoParam extends PageParam {

    /**
     * 关键字
     */
    private String keyword;

    /**
     * 员工ID
     */
    private Long employeeId;

    /**
     * 员工职位
     */
    private Integer position;
    /**
     * 考勤日期
     */
    private String attendanceDate;

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
     * 迟到标识
     */
    private Boolean lateSign;

    /**
     * 早退标识
     */
    private Boolean earlySign;

    /**
     * 出勤状态 1：正常；2：异常；3：旷工
     */
    private Integer state;

    /**
     * 上班打卡状态 1-正常；2-迟到；3-缺卡
     */
    private Integer punchInState;

    /**
     * 下班打卡状态 1-正常；2-早退；3-缺卡
     */
    private Integer punchOutState;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(String attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public Integer getRecordYear() {
        return recordYear;
    }

    public void setRecordYear(Integer recordYear) {
        this.recordYear = recordYear;
    }

    public Integer getRecordMonth() {
        return recordMonth;
    }

    public void setRecordMonth(Integer recordMonth) {
        this.recordMonth = recordMonth;
    }

    public Integer getRecordDay() {
        return recordDay;
    }

    public void setRecordDay(Integer recordDay) {
        this.recordDay = recordDay;
    }

    public Boolean getLateSign() {
        return lateSign;
    }

    public void setLateSign(Boolean lateSign) {
        this.lateSign = lateSign;
    }

    public Boolean getEarlySign() {
        return earlySign;
    }

    public void setEarlySign(Boolean earlySign) {
        this.earlySign = earlySign;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getPunchInState() {
        return punchInState;
    }

    public void setPunchInState(Integer punchInState) {
        this.punchInState = punchInState;
    }

    public Integer getPunchOutState() {
        return punchOutState;
    }

    public void setPunchOutState(Integer punchOutState) {
        this.punchOutState = punchOutState;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
}