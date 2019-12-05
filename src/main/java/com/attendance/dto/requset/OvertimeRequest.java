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
public class OvertimeRequest implements Serializable{

	private Long employeeId;

	private Date overtimeStart;

	private Date overtimeEnd;

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Date getOvertimeStart() {
		return overtimeStart;
	}

	public void setOvertimeStart(Date overtimeStart) {
		this.overtimeStart = overtimeStart;
	}

	public Date getOvertimeEnd() {
		return overtimeEnd;
	}

	public void setOvertimeEnd(Date overtimeEnd) {
		this.overtimeEnd = overtimeEnd;
	}


}