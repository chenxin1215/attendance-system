package com.attendance.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.attendance.dao.MonthStatisticsMapper;
import com.attendance.entity.MonthStatistics;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendance.dao.AttendanceInfoMapper;
import com.attendance.dao.ConfigureInfoMapper;
import com.attendance.dao.EmployeeInfoMapper;
import com.attendance.dto.requset.attendance.QueryAttendanceInfoParam;
import com.attendance.dto.response.AttendanceDetail;
import com.attendance.entity.AttendanceInfo;
import com.attendance.entity.ConfigureInfo;
import com.attendance.entity.EmployeeInfo;
import com.attendance.enums.AttendanceStateEnum;
import com.attendance.enums.PunchInStateEnum;
import com.attendance.enums.PunchOutStateEnum;
import com.attendance.service.AttendanceService;
import com.attendance.utils.DateUtil;
import org.springframework.util.Assert;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author xx
 * @create 2019/12/8
 * @since 1.0.0
 */

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceInfoMapper attendanceInfoMapper;

    @Autowired
    private ConfigureInfoMapper configureInfoMapper;

    @Autowired
    private EmployeeInfoMapper employeeInfoMapper;

    @Autowired
    private MonthStatisticsMapper monthStatisticsMapper;

    public Integer punchIn(Long employeeId) {
        ConfigureInfo configureInfo = configureInfoMapper.selectById(1L);
        EmployeeInfo employeeInfo = employeeInfoMapper.selectById(employeeId);

        Integer checkResult = checkPunch(employeeId, configureInfo, employeeInfo);
        if (checkResult != 1) {
            return checkResult;
        }

        Date punchInDate = new Date();
        AttendanceInfo attendanceInfo = new AttendanceInfo();
        attendanceInfo.setEmployeeId(employeeId);
        attendanceInfo.setEmployeeName(employeeInfo.getEmployeeName());
        attendanceInfo.setPunchInTime(punchInDate);
        attendanceInfo.setRecordYear(DateUtil.getYear(punchInDate));
        attendanceInfo.setRecordMonth(DateUtil.getMonth(punchInDate));
        attendanceInfo.setRecordDay(DateUtil.getDay(punchInDate));

        // 打卡时间大于上班时间 迟到
        if (punchInDate.compareTo(configureInfo.getWorkHours()) == 1) {
            attendanceInfo.setPunchInState(PunchInStateEnum.LATE.value());
            attendanceInfo.setState(AttendanceStateEnum.EXCEPTION.value());
            attendanceInfo.setLateSign(true);
        } else {
            attendanceInfo.setPunchInState(PunchInStateEnum.NORMAL.value());
            attendanceInfo.setLateSign(false);
        }

        attendanceInfoMapper.insert(attendanceInfo);
        return 1;
    }

    public Integer punchOut(Long employeeId) {
        ConfigureInfo configureInfo = configureInfoMapper.selectById(1L);
        EmployeeInfo employeeInfo = employeeInfoMapper.selectById(employeeId);

        Integer checkResult = checkPunch(employeeId, configureInfo, employeeInfo);
        if (checkResult != 1) {
            return checkResult;
        }

        Date punchOutDate = new Date();
        int year = DateUtil.getYear(punchOutDate);
        int month = DateUtil.getMonth(punchOutDate);
        int day = DateUtil.getDay(punchOutDate);

        // 获取上班的打卡记录
        QueryAttendanceInfoParam param = new QueryAttendanceInfoParam();
        param.setEmployeeId(employeeId);
        param.setRecordYear(year);
        param.setRecordMonth(month);
        param.setRecordDay(day);
        List<AttendanceInfo> attendanceInfoList = attendanceInfoMapper.queryAttendanceByParam(param);

        if (attendanceInfoList == null || attendanceInfoList.size() == 0) {
            // 没有上班打卡记录
            AttendanceInfo attendanceInfo = new AttendanceInfo();
            attendanceInfo.setEmployeeId(employeeId);
            attendanceInfo.setEmployeeName(employeeInfo.getEmployeeName());
            attendanceInfo.setRecordYear(year);
            attendanceInfo.setRecordMonth(month);
            attendanceInfo.setRecordDay(day);
            attendanceInfo.setPunchOutTime(punchOutDate);
            attendanceInfo.setPunchInState(PunchInStateEnum.LESS.value());
            attendanceInfo.setState(AttendanceStateEnum.EXCEPTION.value());

            // 打卡时间小于下班时间 早退
            if (punchOutDate.compareTo(configureInfo.getWorkHours()) == -1) {
                attendanceInfo.setState(AttendanceStateEnum.EXCEPTION.value());
                attendanceInfo.setPunchOutState(PunchOutStateEnum.EARLY.value());
                attendanceInfo.setEarlySign(true);
            } else {
                attendanceInfo.setPunchOutState(PunchOutStateEnum.NORMAL.value());
            }

            // 计算工作时间 因为上班卡缺少 自动从下午两点开始
            int wrokTime = DateUtil.subHouse(DateUtil.getLessPunchInTime(punchOutDate),
                attendanceInfo.getPunchOutTime(), DateUtil.DATETIME_BASE);
            attendanceInfo.setWorkTime(wrokTime);

            attendanceInfoMapper.insert(attendanceInfo);
        } else {
            AttendanceInfo attendanceInfo = attendanceInfoList.get(0);
            attendanceInfo.setPunchOutTime(punchOutDate);

            // 打卡时间小于下班时间 早退
            if (punchOutDate.compareTo(configureInfo.getWorkHours()) == -1) {
                attendanceInfo.setState(AttendanceStateEnum.EXCEPTION.value());
                attendanceInfo.setPunchOutState(PunchOutStateEnum.EARLY.value());
                attendanceInfo.setEarlySign(true);
            } else {
                attendanceInfo.setPunchOutState(PunchOutStateEnum.NORMAL.value());
            }

            // 计算每日工作时间
            int wrokTime = DateUtil.subHouse(attendanceInfo.getPunchInTime(), attendanceInfo.getPunchOutTime(),
                DateUtil.DATETIME_BASE);
            attendanceInfo.setWorkTime(wrokTime);

            attendanceInfoMapper.updateById(attendanceInfo);
        }
        return 1;
    }

    private Integer checkPunch(Long employeeId, ConfigureInfo configureInfo, EmployeeInfo employeeInfo) {
        if (configureInfo == null) {
            System.out.println("尚未配置公司考勤制度！");
            return 0;
        }
        if (employeeInfo == null) {
            System.out.println("员工不存在！");
            return 0;
        }
        return 1;
    }

    public AttendanceDetail getAttendanceDetailByParam(QueryAttendanceInfoParam param) {
        Assert.notNull(param.getEmployeeId(), "员工id不能为空！");
        String attendanceDateStr = param.getAttendanceDate();
        Assert.notNull(attendanceDateStr, "考勤日期不能为空");

        Date date = DateUtil.stringToDate(attendanceDateStr, DateUtil.DATE_BASE);
        int year = DateUtil.getYear(date);
        param.setRecordYear(year);
        int month = DateUtil.getMonth(date);
        param.setRecordMonth(month);
        int day = DateUtil.getDay(date);
        param.setRecordDay(day);

        List<AttendanceInfo> attendanceInfos = attendanceInfoMapper.queryAttendanceByParam(param);
        if (attendanceInfos == null || attendanceInfos.size() == 0) {
            return null;
        }

        AttendanceDetail detail = new AttendanceDetail();
        AttendanceInfo attendanceInfo = attendanceInfos.get(0);
        BeanUtils.copyProperties(attendanceInfo, detail);
        if (attendanceInfo.getState() != null) {
            detail.setStateStr(AttendanceStateEnum.parse(attendanceInfo.getState()).toString());
        }
        if (attendanceInfo.getPunchInTime() != null) {
            detail.setPunchInTimeStr(DateUtil.dateToString(attendanceInfo.getPunchInTime(), DateUtil.DATETIME_BASE));
        }
        if (attendanceInfo.getPunchInState() != null) {
            detail.setPunchInStateStr(PunchInStateEnum.parse(attendanceInfo.getPunchInState()).toString());
        }
        if (attendanceInfo.getPunchOutTime() != null) {
            detail.setPunchOutTimeStr(DateUtil.dateToString(attendanceInfo.getPunchInTime(), DateUtil.DATETIME_BASE));
        }
        if (attendanceInfo.getPunchOutState() != null) {
            detail.setPunchOutStateStr(PunchOutStateEnum.parse(attendanceInfo.getPunchOutState()).toString());
        }
        return detail;
    }

    public void updateAttendance(AttendanceInfo attendanceInfo) {
        attendanceInfoMapper.updateById(attendanceInfo);
    }

    public List<AttendanceDetail> queryAttendanceDetailListByParam(QueryAttendanceInfoParam param) {
        List<AttendanceDetail> dataList = new ArrayList<AttendanceDetail>();
        List<AttendanceInfo> attendanceInfoList = attendanceInfoMapper.queryAttendanceByParam(param);
        for (AttendanceInfo attendanceInfo : attendanceInfoList) {
            AttendanceDetail detail = new AttendanceDetail();
            BeanUtils.copyProperties(attendanceInfo, detail);
            if (attendanceInfo.getState() != null) {
                detail.setStateStr(AttendanceStateEnum.parse(attendanceInfo.getState()).toString());
            }
            if (attendanceInfo.getPunchInState() != null) {
                detail.setPunchInStateStr(PunchInStateEnum.parse(attendanceInfo.getPunchInState()).toString());
            }
            if (attendanceInfo.getPunchOutState() != null) {
                detail.setPunchOutStateStr(PunchOutStateEnum.parse(attendanceInfo.getPunchOutState()).toString());
            }
            if (attendanceInfo.getPunchInTime() != null) {
                detail
                    .setPunchInTimeStr(DateUtil.dateToString(attendanceInfo.getPunchInTime(), DateUtil.DATETIME_BASE));
            }
            if (attendanceInfo.getPunchOutTime() != null) {
                detail.setPunchOutTimeStr(
                    DateUtil.dateToString(attendanceInfo.getPunchOutTime(), DateUtil.DATETIME_BASE));
            }
            dataList.add(detail);
        }
        return dataList;
    }

    public List<MonthStatistics> queryAttendanceMonthListByParam(QueryAttendanceInfoParam param) {

        // TODO 考勤列表信息查询（月份）
        monthStatisticsMapper.queryAttendanceMonthByParam(param);

        return null;
    }

}