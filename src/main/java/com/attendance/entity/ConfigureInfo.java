package com.attendance.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 考勤规则信息
 * 
 * @author
 */
public class ConfigureInfo implements Serializable {
    /**
     * 配置信息表主键
     */
    private Long id;

    /**
     * 规定上班时间
     */
    private Date workHours;

    /**
     * 规定下班时间
     */
    private Date owHours;

    /**
     * 每天工作时间 (小时)
     */
    private Integer dayWorktime;

    /**
     * 休息类型 1：单休；2：双休
     */
    private Byte breakType;

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
     * 获取配置信息表主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置配置信息表主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取规定上班时间
     */
    public Date getWorkHours() {
        return workHours;
    }

    /**
     * 设置规定上班时间
     */
    public void setWorkHours(Date workHours) {
        this.workHours = workHours;
    }

    /**
     * 获取规定下班时间
     */
    public Date getOwHours() {
        return owHours;
    }

    /**
     * 设置规定下班时间
     */
    public void setOwHours(Date owHours) {
        this.owHours = owHours;
    }

    /**
     * 获取每天工作时间 (小时)
     */
    public Integer getDayWorktime() {
        return dayWorktime;
    }

    /**
     * 设置每天工作时间 (小时)
     */
    public void setDayWorktime(Integer dayWorktime) {
        this.dayWorktime = dayWorktime;
    }

    /**
     * 获取休息类型 1：单休；2：双休
     */
    public Byte getBreakType() {
        return breakType;
    }

    /**
     * 设置休息类型 1：单休；2：双休
     */
    public void setBreakType(Byte breakType) {
        this.breakType = breakType;
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