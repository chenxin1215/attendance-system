package com.attendance.serviceImpl;

import com.attendance.dao.*;
import com.attendance.dto.requset.OvertimeRequest;
import com.attendance.dto.requset.QueryLeaveListParam;
import com.attendance.dto.requset.attendance.QueryAttendanceInfoParam;
import com.attendance.dto.response.ConfigDetail;
import com.attendance.dto.response.attendance.AttendanceDetail;
import com.attendance.dto.response.attendance.AttendanceMonthInfo;
import com.attendance.dto.view.StringView;
import com.attendance.entity.*;
import com.attendance.enums.*;
import com.attendance.service.AttendanceService;
import com.attendance.service.ConfigureService;
import com.attendance.utils.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    @Autowired
    private ConfigureService configureService;

    @Autowired
    private OvertimeInfoMapper overtimeInfoMapper;

    @Autowired
    private LeaveInfoMapper leaveInfoMapper;

    @Autowired
    private LogInfoMapper logInfoMapper;

    @Transactional
    public StringView punchIn(Long employeeId) {
        ConfigureInfo configureInfo = configureInfoMapper.selectById(1L);
        EmployeeInfo employeeInfo = employeeInfoMapper.selectById(employeeId);

        StringView view = checkPunch(employeeId, configureInfo, employeeInfo);
        if (view.getRspCode() != StringView.SUCCESS) {
            return view;
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
        return view;
    }

    @Transactional
    public StringView punchOut(Long employeeId) {
        ConfigureInfo configureInfo = configureInfoMapper.selectById(1L);
        EmployeeInfo employeeInfo = employeeInfoMapper.selectById(employeeId);

        StringView view = checkPunch(employeeId, configureInfo, employeeInfo);
        if (view.getRspCode() != StringView.SUCCESS) {
            return view;
        }

        Date punchOutDate = new Date();
        int year = DateUtil.getYear(punchOutDate);
        int month = DateUtil.getMonth(punchOutDate);
        int day = DateUtil.getDay(punchOutDate);

        // 判断是否为加班
        boolean isOverTime;
        OvertimeRequest overtimeRequest = new OvertimeRequest();
        overtimeRequest.setEmployeeId(employeeId);
        overtimeRequest.setCompleteState(0); // 查询未完成的加班记录
        overtimeRequest.setOverDateStart(DateUtil.dateToDate(new Date(), DateUtil.DATE_BASE));
        overtimeRequest.setOverDateEnd(DateUtil.dateToDate(new Date(), DateUtil.DATE_BASE));
        List<OvertimeInfo> overtimeInfos = overtimeInfoMapper.queryOvertimeInfoByParam(overtimeRequest);
        if (CollectionUtils.isEmpty(overtimeInfos)) {
            isOverTime = false;
        } else {
            isOverTime = true;
        }

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

                // 判断是否为加班
                if (isOverTime) {
                    // 补全加班信息
                    OvertimeInfo overtimeInfo = overtimeInfos.get(0);
                    overtimeInfo.setOverStartTime(attendanceInfo.getPunchInTime());
                    overtimeInfo.setOverEndTime(attendanceInfo.getPunchOutTime());

                    // 根据上班打卡状态处理
                    if (attendanceInfo.getPunchInState() == PunchInStateEnum.NORMAL.value()) {
                        overtimeInfo.setCompleteState(1);
                        attendanceInfo.setState(AttendanceStateEnum.OVERTIME.value());
                    } else if (attendanceInfo.getPunchInState() == PunchInStateEnum.LESS.value()) {
                        overtimeInfo.setCompleteState(0);
                        attendanceInfo.setState(AttendanceStateEnum.EXCEPTION.value());
                    }
                    overtimeInfoMapper.updateById(overtimeInfo);
                } else {
                    // 根据上班打卡状态处理
                    if (attendanceInfo.getPunchInState() == PunchInStateEnum.NORMAL.value()) {
                        attendanceInfo.setState(AttendanceStateEnum.NORMAL.value());
                    } else {
                        attendanceInfo.setPunchOutState(PunchOutStateEnum.EARLY.value());
                    }
                }
            }

            // 计算每日工作时间
            int workTime = DateUtil.subHouse(attendanceInfo.getPunchInTime(), attendanceInfo.getPunchOutTime(),
                DateUtil.DATETIME_BASE);
            workTime -= 2; // 减去中午休息时间
            attendanceInfo.setWorkTime(workTime);

            attendanceInfoMapper.updateById(attendanceInfo);
        }
        return view;
    }

    private StringView checkPunch(Long employeeId, ConfigureInfo configureInfo, EmployeeInfo employeeInfo) {
        StringView view = new StringView();
        if (configureInfo == null) {
            view.success(StringView.NOTIFY, "尚未配置公司考勤制度！", null);
            return view;
        }
        if (employeeInfo == null) {
            view.success(StringView.NOTIFY, "员工不存在！", null);
            System.out.println();
            return view;
        }
        view.success();
        return view;
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

    public int queryAttendanceMonthListByParamCount(QueryAttendanceInfoParam param) {
        return monthStatisticsMapper.queryAttendanceMonthListByParamCount(param);
    }

    public List<AttendanceMonthInfo> queryAttendanceMonthListByParam(QueryAttendanceInfoParam param) {
        Integer recordYear = param.getRecordYear();
        Integer recordMonth = param.getRecordMonth();
        Assert.notNull(recordYear, "年份不能为空！");
        Assert.notNull(recordMonth, "月份不能为空！");

        List<AttendanceMonthInfo> dataList = new ArrayList<>();
        List<MonthStatistics> monthStatisticsList = monthStatisticsMapper.queryAttendanceMonthByParam(param);
        for (MonthStatistics statistics : monthStatisticsList) {
            AttendanceMonthInfo data = new AttendanceMonthInfo();
            BeanUtils.copyProperties(statistics, data);
            data.setAverageWorkingHours(statistics.getWorkTime().floatValue() / statistics.getWorkDay().floatValue());
            EmployeeInfo employeeInfo = employeeInfoMapper.selectById(statistics.getEmployeeId());
            data.setPosition(PositionTypeEnum.parse(employeeInfo.getPosition()).toString());
            dataList.add(data);
        }
        return dataList;
    }

    @Transactional
    public Integer generateMonthAttendanceInfo(QueryAttendanceInfoParam param, Long operationUserId) {
        Integer recordYear = param.getRecordYear();
        Integer recordMonth = param.getRecordMonth();
        Assert.notNull(recordYear, "年份不能为空！");
        Assert.notNull(recordMonth, "月份不能为空！");

        EmployeeInfo operationUser = employeeInfoMapper.selectById(operationUserId);
        Assert.notNull(operationUser, "不存在此操作员！");
        if (operationUser.getEmployeeType() == EmployeeTypeEnum.WORKER.value()) {
            System.out.println("权限不足 无法操作！");
            return -1;
        }

        Date nowDate = DateUtil.stringToDate(recordYear + "-" + recordMonth + "-" + "01", DateUtil.DATE_BASE);

        // 获取考勤规则
        ConfigDetail config = configureService.getConfig();

        // 获取本月所有员工的考勤数据 进行统计
        QueryAttendanceInfoParam queryAttendanceParam = new QueryAttendanceInfoParam();
        queryAttendanceParam.setRecordYear(recordYear);
        queryAttendanceParam.setRecordMonth(recordMonth);
        List<AttendanceInfo> attendanceInfoList = attendanceInfoMapper.queryAttendanceByParam(queryAttendanceParam);
        if (CollectionUtils.isEmpty(attendanceInfoList)) {
            System.out.println("没有员工数据！");
            return 0;
        }

        // 删除之前记录
        QueryWrapper<MonthStatistics> queryWrapper = new QueryWrapper<MonthStatistics>();
        queryWrapper.eq("years", recordYear);
        queryWrapper.eq("months", recordMonth);
        monthStatisticsMapper.delete(queryWrapper);

        // 分组
        Map<Long, List<AttendanceInfo>> listMap =
            attendanceInfoList.stream().collect(Collectors.toMap(AttendanceInfo::getEmployeeId,
                value -> Lists.newArrayList(value), (List<AttendanceInfo> oldList, List<AttendanceInfo> newList) -> {
                    oldList.addAll(newList);
                    return oldList;
                }));
        List<MonthStatistics> monthStatisticsList = new ArrayList<>();

        for (Long employeeId : listMap.keySet()) {
            List<AttendanceInfo> attendanceInfos = listMap.get(employeeId);

            MonthStatistics monthStatistics = new MonthStatistics();
            if (CollectionUtils.isEmpty(attendanceInfos)) {
                continue;
            }

            monthStatistics.setEmployeeId(attendanceInfos.get(0).getEmployeeId());
            monthStatistics.setEmployeeName(attendanceInfos.get(0).getEmployeeName());
            monthStatistics.setYears(recordYear);
            monthStatistics.setMonths(recordMonth);
            Integer workDay = 0; // 出勤天数
            Integer latenessNum = 0; // 迟到次数
            Integer latenessTimeSum = 0;// 迟到时长
            Integer earlyNum = 0; // 早退次数
            Integer earlyTimeSum = 0; // 早退时间
            Integer missNum = 0; // 缺卡次数
            Integer overtimeNum = 0; // 加班次数
            Integer absenteeismDay = 0; // 矿工天数
            Integer leaveDay = 0; // 请假天数
            Integer workTimeSum = 0; // 工作时间
            Integer overTimeSum = 0; // 加班时间
            Integer normalTime = configureService.getTime(); // 正常工作时间
            Integer remainingTime = 0; // 欠缺时间
            Integer slackTime = 0; // 富余时间

            // 获取请假信息 计算请假天数
            QueryLeaveListParam queryLeaveListParam = new QueryLeaveListParam();
            queryLeaveListParam.setEmployeeId(employeeId);
            queryLeaveListParam
                .setStartDate(DateUtil.dateToDate(DateUtil.getFirstDayOfMonth(nowDate), DateUtil.DATE_BASE));
            queryLeaveListParam
                .setEndDate(DateUtil.dateToDate(DateUtil.getLastDayOfMonth(nowDate), DateUtil.DATE_BASE));
            List<LeaveInfo> leaveInfoList = leaveInfoMapper.queryLeaveListByParam(queryLeaveListParam);
            if (!CollectionUtils.isEmpty(leaveInfoList)) {
                for (LeaveInfo leaveInfo : leaveInfoList) {
                    int days = DateUtil.subDay(leaveInfo.getStartDate(), leaveInfo.getEndDate());
                    leaveDay += days;
                }
            }

            for (AttendanceInfo attendanceInfo : attendanceInfos) {
                if (attendanceInfo.getState() == AttendanceStateEnum.ABSENTEEISM.value()) {
                    missNum++;
                } else {
                    workDay++;
                }
                if (attendanceInfo.getLateSign()) {
                    latenessNum++;
                    int latenessTime = DateUtil.subHouse(config.getWorkHours(), attendanceInfo.getPunchInTime(),
                        DateUtil.DATETIME_BASE);
                    latenessTimeSum += latenessTime;
                }
                if (attendanceInfo.getEarlySign()) {
                    earlyNum++;
                    int earlyTime = DateUtil.subHouse(attendanceInfo.getPunchOutTime(), config.getOwHours(),
                        DateUtil.DATETIME_BASE);
                    earlyTimeSum += earlyTime;
                }
                if (attendanceInfo.getState() == AttendanceStateEnum.OVERTIME.value()) {
                    overtimeNum++;
                }
                if (attendanceInfo.getState() == AttendanceStateEnum.ABSENTEEISM.value()) {
                    absenteeismDay++;
                }
                workTimeSum += attendanceInfo.getWorkTime();
                if (attendanceInfo.getState() == AttendanceStateEnum.OVERTIME.value()) {
                    overTimeSum += attendanceInfo.getWorkTime();
                }
            }

            // 计算富裕时间和欠缺时间
            if (workTimeSum.compareTo(normalTime) == 1) {
                slackTime = workTimeSum - normalTime;
            } else if (workTimeSum.compareTo(normalTime) == -1) {
                remainingTime = normalTime - workTimeSum;
            }

            // 组装实体
            monthStatistics.setWorkDay(workDay);
            monthStatistics.setLatenessNum(latenessNum);
            monthStatistics.setLatenessTime(latenessTimeSum);
            monthStatistics.setEarlyNum(earlyNum);
            monthStatistics.setEarlyTime(earlyTimeSum);
            monthStatistics.setMissNum(missNum);
            monthStatistics.setOvertimeNum(overtimeNum);
            monthStatistics.setOverTime(overTimeSum);
            monthStatistics.setAbsenteeismDay(absenteeismDay);
            monthStatistics.setLeaveDay(leaveDay);
            monthStatistics.setRemainingTime(remainingTime);
            monthStatistics.setSlackTime(slackTime);

            monthStatisticsList.add(monthStatistics);
        }

        // 批量新增
        monthStatisticsMapper.batchInsert(monthStatisticsList);

        // 添加日志
        LogInfo logInfo = new LogInfo();
        logInfo.setEmployeeId(operationUserId);
        logInfo.setEmployeeName(operationUser.getEmployeeName());
        logInfo.setContent("重新生成月度考勤信息！");
        logInfoMapper.insert(logInfo);
        return 1;
    }

}