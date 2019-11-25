package com.attendance.controller;

import com.attendance.dto.requset.ApprovalRequest;
import com.attendance.dto.requset.EmployeeIdRequest;
import com.attendance.dto.requset.QueryAttendanceInfoParam;
import com.attendance.dto.response.AttendanceDetail;
import com.attendance.dto.response.AttendanceMonthInfo;
import com.attendance.entity.ApproveInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    /**
     * 上班打卡
     * 
     * @param request:
     *            员工ID
     */
    @RequestMapping(value = "punchIn", method = RequestMethod.POST)
    @ResponseBody
    public void punchIn(@RequestBody EmployeeIdRequest request) {

    }

    /**
     * 下班打卡
     * 
     * @param request:
     *            员工ID
     */
    @RequestMapping(value = "punchOut", method = RequestMethod.POST)
    @ResponseBody
    public void punchOut(@RequestBody EmployeeIdRequest request) {

    }

    /**
     * 查看员工考勤信息详情（日）
     * 
     * @param request
     */
    @RequestMapping(value = "queryAttendanceInfoByParam", method = RequestMethod.POST)
    @ResponseBody
    public AttendanceDetail queryAttendanceInfoByParam(@RequestBody QueryAttendanceInfoParam request) {

        AttendanceDetail attendanceDetail = new AttendanceDetail();

        return attendanceDetail;

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
    public List<ApproveInfo> getAttendanceRule() {
        List<ApproveInfo> result = new ArrayList<ApproveInfo>();

        return result;
    }

}