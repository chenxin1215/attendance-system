package com.attendance.controller;

import com.attendance.dto.requset.approve.ApprovalIdRequest;
import com.attendance.dto.requset.approve.ApprovalRequest;
import com.attendance.dto.requset.approve.QueryApproveParam;
import com.attendance.dto.requset.employee.InsertEmployeeRequest;
import com.attendance.dto.requset.employee.QueryEmployeeListParam;
import com.attendance.dto.response.AttendanceDetail;
import com.attendance.dto.response.EmployeeDetail;
import com.attendance.dto.response.approve.ApproveInfoData;
import com.attendance.entity.AttendanceInfo;
import com.attendance.entity.ConfigureInfo;
import com.attendance.entity.EmployeeInfo;
import com.attendance.service.ApproveService;
import com.attendance.service.AttendanceService;
import com.attendance.service.ConfigureService;
import com.attendance.service.EmployeeService;
import com.attendance.utils.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ApproveService approveService;

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private ConfigureService configureService;

    /**
     * 添加员工
     * 
     * @param request
     */
    @RequestMapping(value = "addEmployee", method = RequestMethod.POST)
    @ResponseBody
    public void addEmployee(@RequestBody InsertEmployeeRequest request) {
        System.out.println("#### addEmployee start request = " + request.toString());

        employeeService.insertEmployee(request);

        System.out.println("#### addEmployee end");
    }

    /**
     * 修改员工信息
     * 
     * @param request
     */
    @RequestMapping(value = "updateEmployee", method = RequestMethod.POST)
    @ResponseBody
    public void updateEmployee(@RequestBody EmployeeInfo request) {
        employeeService.updateById(request);
    }

    /**
     * 员工列表查询
     * 
     * @param request
     */
    @RequestMapping(value = "queryEmployeeListByParam", method = RequestMethod.POST)
    @ResponseBody
    public List<EmployeeDetail> queryEmployeeListByParam(@RequestBody QueryEmployeeListParam request) {
        List<EmployeeDetail> resultList = employeeService.queryEmployeeListByParam(request);
        return resultList;
    }

    /**
     * 通过审批
     * 
     * @param request
     */
    @RequestMapping(value = "passApproval", method = RequestMethod.POST)
    @ResponseBody
    public void passApproval(@RequestBody ApprovalIdRequest idRequest, HttpServletRequest request) {
        EmployeeInfo user = (EmployeeInfo)request.getSession().getAttribute("user");
        approveService.passApproval(idRequest.getApprovalId(), user.getEmployeeId());
    }

    /**
     * 拒绝审批
     *
     * @param request
     */
    @RequestMapping(value = "refusedApproval", method = RequestMethod.POST)
    @ResponseBody
    public void refusedApproval(@RequestBody ApprovalIdRequest idRequest, HttpServletRequest request) {
        EmployeeInfo user = (EmployeeInfo)request.getSession().getAttribute("user");
        approveService.refusedApproval(idRequest.getApprovalId(), user.getEmployeeId());

    }

    /**
     * 审批列表查询
     *
     * @param request
     */
    @RequestMapping(value = "queryApprovalListByParam", method = RequestMethod.POST)
    @ResponseBody
    public List<ApproveInfoData> queryApprovalListByParam(@RequestBody ApprovalRequest request) {

        QueryApproveParam param = new QueryApproveParam();
        BeanUtils.copyProperties(request, param);
        if (request.getStartDateStr() != null) {
            param.setStartDate(
                DateUtil.getInitStart(DateUtil.stringToDate(request.getStartDateStr(), DateUtil.DATE_BASE)));
        }
        if (request.getEndDateStr() != null) {
            param.setEndDate(DateUtil.getInitEnd(DateUtil.stringToDate(request.getEndDateStr(), DateUtil.DATE_BASE)));
        }
        List<ApproveInfoData> approveInfoData = approveService.queryApprovalListByParam(param);

        return approveInfoData;
    }

    /**
     * 查询考勤信息列表（月）
     * 
     * @return
     */
    public List<AttendanceDetail> queryAttendanceMonthByParam() {
        List<AttendanceDetail> dataList = new ArrayList<AttendanceDetail>();

        return dataList;
    }

    /**
     * 修改考勤信息
     *
     * @param request
     */
    @RequestMapping(value = "updateEmployee", method = RequestMethod.POST)
    @ResponseBody
    public void updateAttendanceInfo(@RequestBody AttendanceInfo request) {
        attendanceService.updateAttendance(request);
    }

    /**
     * 修改公司考勤规则
     *
     * @param request
     */
    @RequestMapping(value = "updateConfigureInfo", method = RequestMethod.POST)
    @ResponseBody
    public void updateConfigureInfo(@RequestBody ConfigureInfo request) {
        configureService.updateConfig(request);
    }

}