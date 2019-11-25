package com.attendance.dto.requset;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br>
 * 〈修改密码参数〉
 *
 * @author xx
 * @create 2019/11/25
 * @since 1.0.0
 */
public class UpdatePwdRequest implements Serializable{

	private Long employeeId;

	private String oldPassword;

	private String newPassword;

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
}