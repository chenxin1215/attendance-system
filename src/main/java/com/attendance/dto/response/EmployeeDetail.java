package com.attendance.dto.response;

import com.attendance.entity.EmployeeInfo;

/**
 * 员工详细类
 */
public class EmployeeDetail extends EmployeeInfo {

    /**
     * 入职日期
     */
    private String enterDateStr;

    /**
     * 职位
     */
    private String positionStr;

    /**
     * 员工类型
     */
    private String employeeTypeStr;

    /**
     * 员工状态
     */
    private String stateStr;


    public String getEnterDateStr() {
        return enterDateStr;
    }

    public void setEnterDateStr(String enterDateStr) {
        this.enterDateStr = enterDateStr;
    }

    public String getPositionStr() {
        return positionStr;
    }

    public void setPositionStr(String positionStr) {
        this.positionStr = positionStr;
    }

    public String getEmployeeTypeStr() {
        return employeeTypeStr;
    }

    public void setEmployeeTypeStr(String employeeTypeStr) {
        this.employeeTypeStr = employeeTypeStr;
    }

    public String getStateStr() {
        return stateStr;
    }

    public void setStateStr(String stateStr) {
        this.stateStr = stateStr;
    }

    @Override
    public String toString() {
        return "EmployeeDetail{" +super.toString()+
                "enterDateStr='" + enterDateStr + '\'' +
                ", positionStr='" + positionStr + '\'' +
                ", employeeTypeStr='" + employeeTypeStr + '\'' +
                ", stateStr='" + stateStr + '\'' +
                '}';
    }
}
