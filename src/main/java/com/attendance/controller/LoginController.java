package com.attendance.controller;

import com.attendance.dto.requset.LoginRequest;
import com.attendance.entity.EmployeeInfo;
import com.attendance.service.EmployeeService;
import com.attendance.dto.view.SimpleView;
import com.attendance.dto.view.StringView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 〈一句话功能简述〉<br>
 * 〈登陆控制器〉
 *
 * @author xx
 * @create 2019/11/24
 * @since 1.0.0
 */
@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "userLogin", method = RequestMethod.POST)
    @ResponseBody
    public StringView userLogin(@RequestBody LoginRequest loginRequest, HttpServletRequest request) {
        StringView view = new StringView();

        EmployeeInfo employeeInfo = employeeService.getEmployeeBySn(loginRequest.getEmployeeSn());
        if (employeeInfo == null) {
            view.success(StringView.NOTIFY, "账号不存在！", null);
        } else if (!employeeInfo.getPassword().equals(loginRequest.getPassword())) {
            view.success(StringView.NOTIFY, "密码错误！", null);
        } else {
            request.getSession().setAttribute("user", employeeInfo);
            view.success("登陆成功！");
        }
        return view;
    }

    @RequestMapping(value = "getUser", method = RequestMethod.POST)
    @ResponseBody
    public SimpleView getUser(@RequestBody HttpServletRequest request) {
        SimpleView view = new SimpleView();
        if (request.getSession().getAttribute("user") != null) {
            EmployeeInfo employeeInfo = (EmployeeInfo)request.getSession().getAttribute("user");
            view.setRspData(employeeInfo);
        }
        view.success();
        return view;
    }

}