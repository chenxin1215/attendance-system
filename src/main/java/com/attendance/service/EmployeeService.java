package com.attendance.service;

import com.attendance.dto.requset.QueryEmployeeListParam;
import com.attendance.dto.response.EmployeeDetail;
import com.attendance.entity.EmployeeInfo;

import java.util.List;

public interface EmployeeService {

    /**
     * 多条件查询员工列表
     * 
     * @return
     */
    List<EmployeeDetail> queryEmployeeListByParam(QueryEmployeeListParam param);

    EmployeeDetail getEmployeeById(Long employeeId);

    Long insertEmployee(EmployeeInfo employeeInfo);

    void updateByPrimaryKey(EmployeeInfo employeeInfo);

    /**
     * 开除员工
     */
    void outEmployee(Long employeeId);

}
