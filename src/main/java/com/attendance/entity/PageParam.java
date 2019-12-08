package com.attendance.entity;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br>
 * 〈分页〉
 *
 * @author cx
 * @create 2019/12/4
 * @since 1.0.0
 */
public class PageParam implements Serializable {

    /**
     * 第几页
     */
    private Integer page;

    /**
     * 每页多少条
     */
    private Integer pageSize;

    private static final long serialVersionUID = 1L;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getoffset() {
        if (this.getPage() == null || this.getPageSize() == null) {
            return 0;
        }
        return (this.page - 1) * this.pageSize;
    }
}