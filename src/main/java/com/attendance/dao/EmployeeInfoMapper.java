package com.attendance.dao;

import com.attendance.entity.EmployeeInfo;

import java.util.List;

/**
 * EmployeeInfoMapper继承基类
 */
public interface EmployeeInfoMapper extends BaseMapper<EmployeeInfo, Long> {

    /**
     * 查询所有员工
     * @return
     */
    List<EmployeeInfo> queryAllEmployeeList();

}