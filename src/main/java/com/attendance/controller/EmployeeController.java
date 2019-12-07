package com.attendance.controller;

import com.attendance.dto.requset.employee.EmployeeIdRequest;
import com.attendance.dto.requset.UpdatePwdRequest;
import com.attendance.dto.requset.UpdateSelfInfoRequest;
import com.attendance.dto.response.EmployeeDetail;
import com.attendance.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// localhost:8080/attendance-system/employee/queryAllEmployeeList

/**
 * 〈一句话功能简述〉<br>
 * 〈员工控制器-通用〉
 *
 * @author xx
 * @create 2019/11/25
 * @since 1.0.0
 */
@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * 查询员工详情
     * 
     * @param request
     * @return
     */
    @RequestMapping(value = "queryEmployeeDetailById", method = RequestMethod.POST)
    @ResponseBody
    public EmployeeDetail queryEmployeeDetailById(@RequestBody EmployeeIdRequest request) {
        System.out.println("### queryEmployeeDetailById start ###");

        EmployeeDetail employeeDetail = employeeService.getEmployeeById(request.getEmployeeId());

        System.out.println("### queryEmployeeDetailById end ###");
        return employeeDetail;
    }



    /**
     * 修改自身基本信息
     *
     */
    @RequestMapping(value = "updateSelfBaseInfo", method = RequestMethod.POST)
    @ResponseBody
    public void updateSelfBaseInfo(@RequestBody UpdateSelfInfoRequest request) {

    }

    /**
     * 修改密码
     * 
     * @param request
     */
    @RequestMapping(value = "updateEmployeePwd", method = RequestMethod.POST)
    @ResponseBody
    public void updateEmployeePwd(@RequestBody UpdatePwdRequest request) {

    }

}
