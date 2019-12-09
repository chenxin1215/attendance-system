package com.attendance.controller;

import com.attendance.dto.requset.UpdateSelfInfoRequest;
import com.attendance.dto.requset.employee.EmployeeIdRequest;
import com.attendance.dto.response.EmployeeDetail;
import com.attendance.dto.view.SimpleView;
import com.attendance.dto.view.StringView;
import com.attendance.entity.EmployeeInfo;
import com.attendance.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
    public SimpleView queryEmployeeDetailById(@RequestBody EmployeeIdRequest request) {
        System.out.println("### queryEmployeeDetailById start ###");
        SimpleView view = new SimpleView();

        EmployeeDetail employeeDetail = employeeService.getEmployeeById(request.getEmployeeId());

        System.out.println("### queryEmployeeDetailById end ###");
        view.success(employeeDetail);
        return view;
    }

    /**
     * 修改自身基本信息
     *
     */
    @RequestMapping(value = "updateSelfBaseInfo", method = RequestMethod.POST)
    @ResponseBody
    public StringView updateSelfBaseInfo(@RequestBody UpdateSelfInfoRequest updateUpdate, HttpServletRequest request) {
        StringView view = new StringView();
        Assert.notNull(updateUpdate.getEmployeeId(), "员工id不能为空！");
        EmployeeInfo user = (EmployeeInfo)request.getSession().getAttribute("user");
        if (user.getEmployeeId() != updateUpdate.getEmployeeId()) {
            view.success(StringView.NOTIFY, "只能修改自己的信息", null);
        } else {
            EmployeeInfo employeeInfo = new EmployeeInfo();
            BeanUtils.copyProperties(updateUpdate, employeeInfo);
            employeeService.updateById(employeeInfo);
            view.success();
        }
        return view;
    }

}
