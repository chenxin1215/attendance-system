package com.attendance.controller;

import com.attendance.dto.requset.approve.ApprovalIdRequest;
import com.attendance.dto.requset.approve.ApprovalRequest;
import com.attendance.dto.requset.approve.QueryApproveParam;
import com.attendance.dto.requset.attendance.QueryAttendanceInfoParam;
import com.attendance.dto.requset.employee.InsertEmployeeRequest;
import com.attendance.dto.requset.employee.QueryEmployeeListParam;
import com.attendance.dto.response.EmployeeDetail;
import com.attendance.dto.response.LogInfoDetail;
import com.attendance.dto.response.approve.ApproveInfoData;
import com.attendance.dto.response.attendance.AttendanceMonthInfo;
import com.attendance.dto.view.ListBaseView;
import com.attendance.dto.view.StringView;
import com.attendance.entity.AttendanceInfo;
import com.attendance.entity.ConfigureInfo;
import com.attendance.entity.EmployeeInfo;
import com.attendance.service.*;
import com.attendance.utils.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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

    @Autowired
    private LogInfoService logInfoService;

    /**
     * 添加员工
     * 
     * @param request
     */
    @RequestMapping(value = "addEmployee", method = RequestMethod.POST)
    @ResponseBody
    public StringView addEmployee(@RequestBody InsertEmployeeRequest request) {
        System.out.println("#### addEmployee start request = " + request.toString());
        StringView view = new StringView();
        employeeService.insertEmployee(request);
        view.success("添加成功");
        System.out.println("#### addEmployee end");
        return view;
    }

    /**
     * 修改员工信息
     * 
     * @param request
     */
    @RequestMapping(value = "updateEmployee", method = RequestMethod.POST)
    @ResponseBody
    public StringView updateEmployee(@RequestBody EmployeeInfo request) {
        StringView view = new StringView();
        employeeService.updateById(request);
        view.success("修改成功");
        return view;
    }

    /**
     * 员工列表查询
     * 
     * @param request
     */
    @RequestMapping(value = "queryEmployeeListByParam", method = RequestMethod.POST)
    @ResponseBody
    public ListBaseView<EmployeeDetail> queryEmployeeListByParam(@RequestBody QueryEmployeeListParam request) {
        ListBaseView<EmployeeDetail> view = new ListBaseView<>();

        int count = employeeService.queryEmployeeListByParamCount(request);
        view.setTotal(count);

        if (count > 0) {
            List<EmployeeDetail> resultList = employeeService.queryEmployeeListByParam(request);
            view.setRspData(resultList);
        }

        view.success();
        return view;
    }

    /**
     * 通过审批
     * 
     * @param request
     */
    @RequestMapping(value = "passApproval", method = RequestMethod.POST)
    @ResponseBody
    public StringView passApproval(@RequestBody ApprovalIdRequest idRequest, HttpServletRequest request) {
        StringView view = new StringView();
        EmployeeInfo user = (EmployeeInfo)request.getSession().getAttribute("user");
        approveService.passApproval(idRequest.getApprovalId(), user.getEmployeeId());
        view.success("通过审批！");
        return view;
    }

    /**
     * 拒绝审批
     *
     * @param request
     */
    @RequestMapping(value = "refusedApproval", method = RequestMethod.POST)
    @ResponseBody
    public StringView refusedApproval(@RequestBody ApprovalIdRequest idRequest, HttpServletRequest request) {
        StringView view = new StringView();
        EmployeeInfo user = (EmployeeInfo)request.getSession().getAttribute("user");
        approveService.refusedApproval(idRequest.getApprovalId(), user.getEmployeeId());
        view.success("拒绝审批！");
        return view;
    }

    /**
     * 审批列表查询
     *
     * @param request
     */
    @RequestMapping(value = "queryApprovalListByParam", method = RequestMethod.POST)
    @ResponseBody
    public ListBaseView<ApproveInfoData> queryApprovalListByParam(@RequestBody ApprovalRequest request) {
        ListBaseView<ApproveInfoData> view = new ListBaseView<>();
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
        view.success(approveInfoData);
        return view;
    }

    /**
     * 查询考勤信息列表（月）
     * 
     * @return
     */
    @RequestMapping(value = "queryAttendanceMonthByParam", method = RequestMethod.POST)
    @ResponseBody
    public ListBaseView<AttendanceMonthInfo> queryAttendanceMonthByParam(QueryAttendanceInfoParam param) {
        ListBaseView<AttendanceMonthInfo> view = new ListBaseView<>();

        int count = attendanceService.queryAttendanceMonthListByParamCount(param);
        view.setTotal(count);
        if (count > 0) {
            List<AttendanceMonthInfo> attendanceMonthInfos = attendanceService.queryAttendanceMonthListByParam(param);
            view.setRspData(attendanceMonthInfos);
        }
        view.success();
        return view;
    }

    /**
     * 修改考勤信息
     *
     * @param request
     */
    @RequestMapping(value = "updateEmployee", method = RequestMethod.POST)
    @ResponseBody
    public StringView updateAttendanceInfo(@RequestBody AttendanceInfo request) {
        StringView view = new StringView();
        attendanceService.updateAttendance(request);
        view.success("修改成功");
        return view;
    }

    /**
     * 修改公司考勤规则
     *
     * @param request
     */
    @RequestMapping(value = "updateConfigureInfo", method = RequestMethod.POST)
    @ResponseBody
    public StringView updateConfigureInfo(@RequestBody ConfigureInfo request, HttpServletRequest userRequest) {
        StringView view = new StringView();
        EmployeeInfo user = (EmployeeInfo)userRequest.getSession().getAttribute("user");
        if (user == null) {
            view.success(StringView.NOTIFY, "请先登陆！", null);
        } else {
            configureService.updateConfig(request, user.getEmployeeId());
            view.success("修改成功");
        }
        return view;
    }

    /**
     * 查询日志
     *
     * @Author: chenxin
     * @Date: 2019/12/9
     */
    @RequestMapping(value = "queryLogInfo", method = RequestMethod.POST)
    @ResponseBody
    public ListBaseView<LogInfoDetail> queryLogInfo() {
        ListBaseView<LogInfoDetail> view = new ListBaseView();
        List<LogInfoDetail> logInfoDetails = logInfoService.queryLogInfoList();
        view.success(logInfoDetails);
        return view;
    }

}