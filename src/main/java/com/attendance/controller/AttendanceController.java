package com.attendance.controller;

import com.attendance.dto.requset.approve.ApprovalRequest;
import com.attendance.dto.requset.approve.QueryApproveParam;
import com.attendance.dto.requset.attendance.QueryAttendanceInfoParam;
import com.attendance.dto.requset.employee.EmployeeIdRequest;
import com.attendance.dto.response.ConfigDetail;
import com.attendance.dto.response.approve.ApproveInfoData;
import com.attendance.dto.response.attendance.AttendanceDetail;
import com.attendance.dto.response.attendance.AttendanceMonthInfo;
import com.attendance.dto.view.ListBaseView;
import com.attendance.dto.view.SimpleView;
import com.attendance.dto.view.StringView;
import com.attendance.entity.EmployeeInfo;
import com.attendance.service.ApproveService;
import com.attendance.service.AttendanceService;
import com.attendance.service.ConfigureService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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

    @Autowired
    private ApproveService approveService;

    /**
     * 上班打卡
     * 
     * @param request: 员工ID
     */
    @RequestMapping(value = "punchIn", method = RequestMethod.POST)
    @ResponseBody
    public StringView punchIn(@RequestBody EmployeeIdRequest employeeIdRequest, HttpServletRequest request) {
        StringView view = new StringView();
        Assert.notNull(employeeIdRequest.getEmployeeId(), "员工id不能为空！");
        EmployeeInfo user = (EmployeeInfo)request.getSession().getAttribute("user");
        if (user.getEmployeeId() != employeeIdRequest.getEmployeeId()) {
            view.success(StringView.SILENCE, "");
        } else {
            view = attendanceService.punchIn(employeeIdRequest.getEmployeeId());
        }
        return view;
    }

    /**
     * 下班打卡
     * 
     * @param request: 员工ID
     */
    @RequestMapping(value = "punchOut", method = RequestMethod.POST)
    @ResponseBody
    public StringView punchOut(@RequestBody EmployeeIdRequest employeeIdRequest, HttpServletRequest request) {
        StringView view = new StringView();
        Assert.notNull(employeeIdRequest.getEmployeeId(), "员工id不能为空！");
        EmployeeInfo user = (EmployeeInfo)request.getSession().getAttribute("user");
        if (user.getEmployeeId() != employeeIdRequest.getEmployeeId()) {
            view.success(StringView.SILENCE, "");
        } else {
            view = attendanceService.punchOut(employeeIdRequest.getEmployeeId());
        }
        return view;
    }

    /**
     * 查看员工考勤信息列表（日）
     * 
     * @param request
     */
    @RequestMapping(value = "queryAttendanceInfoByParam", method = RequestMethod.POST)
    @ResponseBody
    public ListBaseView<AttendanceDetail> queryAttendanceInfoByParam(@RequestBody QueryAttendanceInfoParam request) {
        Assert.notNull(request.getEmployeeId(), "员工id不能为空");
        ListBaseView<AttendanceDetail> view = new ListBaseView();
        List<AttendanceDetail> attendanceDetails = attendanceService.queryAttendanceDetailListByParam(request);
        view.success(attendanceDetails);
        return view;
    }

    /**
     * 查看员工考勤信息详情（月）
     * 
     * @param request
     */
    @RequestMapping(value = "queryAttendanceMonthInfoByParam", method = RequestMethod.POST)
    @ResponseBody
    public SimpleView queryAttendanceMonthInfoByParam(@RequestBody QueryAttendanceInfoParam request) {
        Assert.notNull(request.getEmployeeId(), "员工id不能为空");
        SimpleView view = new SimpleView();
        AttendanceMonthInfo result = new AttendanceMonthInfo();
        List<AttendanceMonthInfo> attendanceMonthInfos = attendanceService.queryAttendanceMonthListByParam(request);
        if (!CollectionUtils.isEmpty(attendanceMonthInfos)) {
            result = attendanceMonthInfos.get(0);
        }
        view.success(result);
        return view;
    }

    /**
     * 发起审批流程
     * 
     * @param request: all
     */
    @RequestMapping(value = "createApproval", method = RequestMethod.POST)
    @ResponseBody
    public StringView createApproval(@RequestBody ApprovalRequest request) {
        StringView view = new StringView();

        approveService.addApprove(request);

        view.success("审批流程发起成功！");
        return view;
    }

    /**
     * 查看自身审批信息列表
     * 
     * @param request: 员工ID，审批类型、审批日期筛选
     */
    @RequestMapping(value = "queryApprovalInfoListByEmployeeId", method = RequestMethod.POST)
    @ResponseBody
    public ListBaseView queryApprovalInfoListByEmployeeId(@RequestBody ApprovalRequest request) {
        Assert.notNull(request.getApprovalUserId(), "员工id不能为空");

        ListBaseView listView = new ListBaseView();

        QueryApproveParam param = new QueryApproveParam();
        BeanUtils.copyProperties(request, param);
        List<ApproveInfoData> approveInfoData = approveService.queryApprovalListByParam(param);

        listView.success(approveInfoData);
        return listView;
    }

    /**
     * 查看公司考勤规则
     *
     * @return
     */
    @RequestMapping(value = "getAttendanceRule", method = RequestMethod.POST)
    @ResponseBody
    public SimpleView getAttendanceRule() {
        SimpleView resp = new SimpleView();
        ConfigDetail config = configureService.getConfig();
        resp.success(config);
        return resp;
    }

}