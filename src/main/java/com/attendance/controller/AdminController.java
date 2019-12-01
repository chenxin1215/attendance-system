package com.attendance.controller;

import com.attendance.dto.requset.ApprovalIdRequest;
import com.attendance.dto.requset.ApprovalRequest;
import com.attendance.dto.requset.QueryEmployeeListParam;
import com.attendance.dto.response.EmployeeDetail;
import com.attendance.entity.ApproveInfo;
import com.attendance.entity.AttendanceInfo;
import com.attendance.entity.ConfigureInfo;
import com.attendance.entity.EmployeeInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈管理员控制器〉
 *
 * @author xx
 * @create 2019/11/25
 * @since 1.0.0
 */
@RequestMapping("admin")
@Controller
public class AdminController {

    /**
     * 添加员工
     * 
     * @param request
     */
    @RequestMapping(value = "addEmployee", method = RequestMethod.POST)
    @ResponseBody
    public void addEmployee(@RequestBody EmployeeInfo request) {

    }

    /**
     * 修改员工信息
     * 
     * @param request
     */
    @RequestMapping(value = "updateEmployee", method = RequestMethod.POST)
    @ResponseBody
    public void updateEmployee(@RequestBody EmployeeInfo request) {

    }

    /**
     * 员工列表查询
     * 
     * @param request
     */
    @RequestMapping(value = "queryEmployeeListByParam", method = RequestMethod.POST)
    @ResponseBody
    public List<EmployeeDetail> queryEmployeeListByParam(@RequestBody QueryEmployeeListParam request) {
        List<EmployeeDetail> resultList = new ArrayList<EmployeeDetail>();

        return resultList;
    }

    /**
     * 通过审批
     * 
     * @param request
     */
    @RequestMapping(value = "passApproval", method = RequestMethod.POST)
    @ResponseBody
    public void passApproval(@RequestBody ApprovalIdRequest request) {

    }

    /**
     * 拒绝审批
     *
     * @param request
     */
    @RequestMapping(value = "refusedApproval", method = RequestMethod.POST)
    @ResponseBody
    public void refusedApproval(@RequestBody ApprovalIdRequest request) {

    }

    /**
     * 审批列表查询
     *
     * @param request
     */
    @RequestMapping(value = "queryEmployeeListByParam", method = RequestMethod.POST)
    @ResponseBody
    public List<ApproveInfo> queryApprovalListByParam(@RequestBody ApprovalRequest request) {

        List<ApproveInfo> resultList = new ArrayList<ApproveInfo>();

        return resultList;
    }

    /**
     * 修改考勤信息
     *
     * @param request
     */
    @RequestMapping(value = "updateEmployee", method = RequestMethod.POST)
    @ResponseBody
    public void updateAttendanceInfo(@RequestBody AttendanceInfo request) {

    }

    /**
     * 修改公司考勤规则
     *
     * @param request
     */
    @RequestMapping(value = "updateConfigureInfo", method = RequestMethod.POST)
    @ResponseBody
    public void updateConfigureInfo(@RequestBody ConfigureInfo request) {

    }

}