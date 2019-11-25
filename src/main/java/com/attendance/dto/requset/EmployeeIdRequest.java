package com.attendance.dto.requset;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br>
 * 〈单纯的员工ID接收类〉
 *
 * @author xx
 * @create 2019/11/24
 * @since 1.0.0
 */
public class EmployeeIdRequest implements Serializable {

    private Long employeeId;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
}