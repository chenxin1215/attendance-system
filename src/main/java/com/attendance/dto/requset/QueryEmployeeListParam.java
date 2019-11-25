package com.attendance.dto.requset;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br>
 * 〈员工列表查询条件〉
 *
 * @author cx
 * @create 2019/11/25
 * @since 1.0.0
 */
public class QueryEmployeeListParam implements Serializable {

    /**
     * 关键字（工号、姓名、联系方式筛选）
     */
    private String keyword;

    /**
     * 入职时间
     */
    private String enterDateStart;

    /**
     * 入职时间
     */
    private String enterDateEnd;

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

    public String getEnterDateStart() {
        return enterDateStart;
    }

    public void setEnterDateStart(String enterDateStart) {
        this.enterDateStart = enterDateStart;
    }

    public String getEnterDateEnd() {
        return enterDateEnd;
    }

    public void setEnterDateEnd(String enterDateEnd) {
        this.enterDateEnd = enterDateEnd;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
}