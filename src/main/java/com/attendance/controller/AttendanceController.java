package com.attendance.controller;

import com.attendance.dto.requset.approve.ApprovalRequest;
import com.attendance.dto.requset.attendance.QueryAttendanceInfoParam;
import com.attendance.dto.requset.employee.EmployeeIdRequest;
import com.attendance.dto.response.AttendanceDetail;
import com.attendance.dto.response.AttendanceMonthInfo;
import com.attendance.dto.response.ConfigDetail;
import com.attendance.entity.ApproveInfo;
import com.attendance.entity.EmployeeInfo;
import com.attendance.service.AttendanceService;
import com.attendance.service.ConfigureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈考勤控制器-通用员工〉
 *
 * @author xx
 * @create 2019/11/24
 * @since 1.0.0
 */
@Controller
@RequestMapping("attendance")
public class AttendanceController {

    @Autowired
    private ConfigureService configureService;

    @Autowired
    private AttendanceService attendanceService;

    /**
     * 上班打卡
     * 
     * @param request:
     *            员工ID
     */
    @RequestMapping(value = "punchIn", method = RequestMethod.POST)
    @ResponseBody
    public void punchIn(@RequestBody EmployeeIdRequest employeeIdRequest, HttpServletRequest request) {
        Assert.notNull(employeeIdRequest.getEmployeeId(), "员工id不能为空！");
        EmployeeInfo user = (EmployeeInfo)request.getSession().getAttribute("user");
        if (user.getEmployeeId() != employeeIdRequest.getEmployeeId()) {
            return;
        }
        attendanceService.punchIn(employeeIdRequest.getEmployeeId());
    }

    /**
     * 下班打卡
     * 
     * @param request:
     *            员工ID
     */
    @RequestMapping(value = "punchOut", method = RequestMethod.POST)
    @ResponseBody
    public void punchOut(@RequestBody EmployeeIdRequest employeeIdRequest, HttpServletRequest request) {
        Assert.notNull(employeeIdRequest.getEmployeeId(), "员工id不能为空！");
        EmployeeInfo user = (EmployeeInfo)request.getSession().getAttribute("user");
        if (user.getEmployeeId() != employeeIdRequest.getEmployeeId()) {
            return;
        }
        attendanceService.punchOut(employeeIdRequest.getEmployeeId());
    }

    /**
     * 查看员工考勤信息详情（日）
     * 
     * @param request
     */
    @RequestMapping(value = "queryAttendanceInfoByParam", method = RequestMethod.POST)
    @ResponseBody
    public AttendanceDetail queryAttendanceInfoByParam(@RequestBody QueryAttendanceInfoParam request) {
        AttendanceDetail data = attendanceService.getAttendanceDetailByParam(request);
        return data;
    }

    /**
     * 查看员工考勤信息详情（月）
     * 
     * @param request
     */
    @RequestMapping(value = "queryAttendanceMonthInfoByParam", method = RequestMethod.POST)
    @ResponseBody
    public AttendanceMonthInfo queryAttendanceMonthInfoByParam(@RequestBody QueryAttendanceInfoParam request) {
        AttendanceMonthInfo result = new AttendanceMonthInfo();



        return result;
    }

    /**
     * 发起审批流程
     * 
     * @param request:
     *            all
     */
    @RequestMapping(value = "createApproval", method = RequestMethod.POST)
    @ResponseBody
    public void createApproval(@RequestBody ApprovalRequest request) {

    }

    /**
     * 查看自身审批信息列表
     * 
     * @param request:
     *            员工ID，审批类型、审批日期筛选
     */
    @RequestMapping(value = "queryApprovalInfoListByEmployeeId", method = RequestMethod.POST)
    @ResponseBody
    public List<ApproveInfo> queryApprovalInfoListByEmployeeId(@RequestBody ApprovalRequest request) {
        List<ApproveInfo> result = new ArrayList<ApproveInfo>();

        return result;
    }

    /**
     * 查看公司考勤规则
     *
     * @return
     */
    @RequestMapping(value = "getAttendanceRule", method = RequestMethod.POST)
    @ResponseBody
    public ConfigDetail getAttendanceRule() {
        ConfigDetail config = configureService.getConfig();
        return config;
    }

}