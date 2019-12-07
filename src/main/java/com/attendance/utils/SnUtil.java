package com.attendance.utils;

import com.attendance.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

public class SnUtil {

    public static String createEmployeeSn(Long newEmployeeSn) {
        String employeeSn = "";
        employeeSn += "xx00";
        employeeSn += newEmployeeSn.toString();
        return employeeSn;
    }

}
