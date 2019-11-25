package com.attendance.service;

import com.attendance.dto.response.EmployeeDetail;
import com.attendance.entity.EmployeeInfo;

import java.util.List;

public interface EmployeeService {

    List<EmployeeInfo> queryAllEmployeeList();

    EmployeeDetail getEmployeeById(Long employeeId);

    Long insertEmployee(EmployeeInfo employeeInfo);

    void updateByPrimaryKey(EmployeeInfo employeeInfo);

    /**
     * 开除员工
     */
    void outEmployee(Long employeeId);

}
