package com.attendance.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * log_info
 * @author 
 */
public class LogInfo implements Serializable {
    /**
     * 日志编号
     */
    @TableId(value = "id",type = IdType.AUTO)//指定自增策略
    private Long logId;

    /**
     * 操作人编号
     */
    private Long employeeId;

    /**
     * 操作人姓名
     */
    private String employeeName;

    /**
     * 操作内容
     */
    private String content;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取日志编号
     */
    public Long getLogId() {
        return logId;
    }

    /**
     * 设置日志编号
     */
    public void setLogId(Long logId) {
        this.logId = logId;
    }

    /**
     * 获取操作人编号
     */
    public Long getEmployeeId() {
        return employeeId;
    }

    /**
     * 设置操作人编号
     */
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * 获取操作人姓名
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * 设置操作人姓名
     */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    /**
     * 获取操作内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置操作内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}