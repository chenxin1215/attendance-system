package com.attendance.dto.requset;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br>
 * 〈考勤信息查询条件〉
 *
 * @author xx
 * @create 2019/11/25
 * @since 1.0.0
 */
public class QueryAttendanceInfoParam implements Serializable {

    /**
     * 员工ID
     */
    private Long employeeId;

    /**
     * 考勤日期
     */
    private String attendanceDate;

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
}