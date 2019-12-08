package com.attendance.service;

import com.attendance.dto.requset.attendance.QueryAttendanceInfoParam;
import com.attendance.dto.response.AttendanceDetail;
import com.attendance.entity.AttendanceInfo;
import com.attendance.entity.MonthStatistics;

import java.util.List;

public interface AttendanceService {

    Integer punchIn(Long employeeId);

    Integer punchOut(Long employeeId);

    void updateAttendance(AttendanceInfo attendanceInfo);

    /**
     * 查询某条考勤详情
     * 
     * @param param
     * @return
     */
    AttendanceDetail getAttendanceDetailByParam(QueryAttendanceInfoParam param);

    /**
     * 条件查询每日考勤
     * 
     * @param param
     * @return
     */
    List<AttendanceDetail> queryAttendanceDetailListByParam(QueryAttendanceInfoParam param);


    List<MonthStatistics> queryAttendanceMonthListByParam(QueryAttendanceInfoParam param);
}
