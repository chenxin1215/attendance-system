package com.attendance.dto.requset.employee;

import java.io.Serializable;

/**
 * 功能描述: 员工新增参数类
 *
 * @Author: xx
 * @Date: 2019/12/6
 */
public class InsertEmployeeRequest implements Serializable {

    private String employeeName;

    private Integer age;

    private Integer sex;

    // 入职日期
    private String enterDate;

    // 职位
    private Integer position;

    // 员工类型 1：普通员工；2：管理员
    private Integer employeeType;

    private String tel;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(String enterDate) {
        this.enterDate = enterDate;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(Integer employeeType) {
        this.employeeType = employeeType;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "InsertEmployeeRequest{" + "employeeName='" + employeeName + '\'' + ", age=" + age + ", sex=" + sex
            + ", enterDate='" + enterDate + '\'' + ", position=" + position + ", employeeType=" + employeeType
            + ", tel='" + tel + '\'' + '}';
    }
}
