package com.attendance.dto.requset.employee;

import com.attendance.entity.PageParam;

import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 * 〈员工列表查询条件〉
 *
 * @author xx
 * @create 2019/11/25
 * @since 1.0.0
 */
public class QueryEmployeeListParam extends PageParam {

    /**
     * 关键字（工号、姓名、联系方式筛选）
     */
    private String keyword;

    /**
     * 入职开始时间
     */
    private String enterDateStartStr;

    private Date enterDateStart;

    /**
     * 入职结束时间
     */
    private String enterDateEndStr;

    private Date enterDateEnd;

    /**
     * 职位
     */
    private Integer position;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getEnterDateStartStr() {
        return enterDateStartStr;
    }

    public void setEnterDateStartStr(String enterDateStartStr) {
        this.enterDateStartStr = enterDateStartStr;
    }

    public Date getEnterDateStart() {
        return enterDateStart;
    }

    public void setEnterDateStart(Date enterDateStart) {
        this.enterDateStart = enterDateStart;
    }

    public String getEnterDateEndStr() {
        return enterDateEndStr;
    }

    public void setEnterDateEndStr(String enterDateEndStr) {
        this.enterDateEndStr = enterDateEndStr;
    }

    public Date getEnterDateEnd() {
        return enterDateEnd;
    }

    public void setEnterDateEnd(Date enterDateEnd) {
        this.enterDateEnd = enterDateEnd;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
}