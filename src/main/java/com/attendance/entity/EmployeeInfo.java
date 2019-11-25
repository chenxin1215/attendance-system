package com.attendance.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * employee_info
 * @author 
 */
public class EmployeeInfo implements Serializable {
    /**
     * 员工编号
     */
    private Long employeeId;

    /**
     * 工号
     */
    private String employeeSn;

    /**
     * 姓名
     */
    private String employeeName;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别 1：男；0：女
     */
    private Integer sex;

    /**
     * 入职日期
     */
    private Date enterDate;

    /**
     * 职位 待定
     */
    private Integer position;

    /**
     * 员工类型 1：普通员工；2：管理员
     */
    private Integer employeeType;

    /**
     * 密码
     */
    private String password;

    /**
     * 联系方式
     */
    private String tel;

    /**
     * 员工状态 1： 在职； 2：离职
     */
    private Integer state;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeSn() {
        return employeeSn;
    }

    public void setEmployeeSn(String employeeSn) {
        this.employeeSn = employeeSn;
    }

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

    public Date getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(Date enterDate) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "EmployeeInfo{" +
                "employeeId=" + employeeId +
                ", employeeSn='" + employeeSn + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", enterDate=" + enterDate +
                ", position=" + position +
                ", employeeType=" + employeeType +
                ", password='" + password + '\'' +
                ", tel='" + tel + '\'' +
                ", state=" + state +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}