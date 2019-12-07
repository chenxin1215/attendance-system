package com.attendance.dao;

import com.attendance.dto.requset.employee.QueryEmployeeListParam;
import com.attendance.entity.EmployeeInfo;

import java.util.List;

/**
 * EmployeeInfoMapper继承基类
 */
public interface EmployeeInfoMapper extends BaseMapper<EmployeeInfo, Long> {

    List<EmployeeInfo> queryEmployeeListByParam(QueryEmployeeListParam param);

    Long getNewEmployeeSn();

}