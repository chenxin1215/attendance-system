package com.attendance.dto.requset;

import java.io.Serializable;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 * 〈加班查询条件〉
 *
 * @author xx
 * @create 2019-12-05
 * @since 1.0.0
 */
public class OvertimeRequest implements Serializable {

    private Long employeeId;

    private Date overDateStart;

    private Date overDateEnd;

    // 加班完成状态
    private Integer completeState;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Date getOverDateStart() {
        return overDateStart;
    }

    public void setOverDateStart(Date overDateStart) {
        this.overDateStart = overDateStart;
    }

    public Date getOverDateEnd() {
        return overDateEnd;
    }

    public void setOverDateEnd(Date overDateEnd) {
        this.overDateEnd = overDateEnd;
    }

    public Integer getCompleteState() {
        return completeState;
    }

    public void setCompleteState(Integer completeState) {
        this.completeState = completeState;
    }
}