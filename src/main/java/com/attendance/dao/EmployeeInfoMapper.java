package com.attendance.dao;

import com.attendance.dto.requset.employee.QueryEmployeeListParam;
import com.attendance.entity.EmployeeInfo;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

public interface EmployeeInfoMapper extends BaseMapper<EmployeeInfo> {

    Long getNewEmployeeSn();

    List<EmployeeInfo> queryEmployeeListByParam(QueryEmployeeListParam param);

}