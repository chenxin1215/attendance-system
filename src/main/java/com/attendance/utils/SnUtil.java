package com.attendance.utils;

public class SnUtil {

    public static String createEmployeeSn(Long newEmployeeSn) {
        String employeeSn = "";
        employeeSn += "xx00";
        employeeSn += newEmployeeSn.toString();
        return employeeSn;
    }

}
