package com.attendance.dto.requset;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author cx
 * @create 2019/11/24
 * @since 1.0.0
 */
public class LoginRequest implements Serializable {

    /**
     * 登陆名（工号）
     */
    private String employeeSn;

    /**
     * 密码
     */
    private String password;

    public String getEmployeeSn() {
        return employeeSn;
    }

    public void setEmployeeSn(String employeeSn) {
        this.employeeSn = employeeSn;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}