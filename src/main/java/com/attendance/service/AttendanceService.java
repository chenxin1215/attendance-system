package com.attendance.service;

import com.attendance.dto.requset.approve.QueryAttendanceParam;
import com.attendance.dto.response.AttendanceDetail;
import com.attendance.entity.AttendanceInfo;

import java.util.List;

public interface AttendanceService {

    Long insertAttendane(AttendanceInfo attendanceInfo);

    void updateAttendance(AttendanceInfo attendanceInfo);

    List<AttendanceDetail> queryAttendanceDetailListByParam(QueryAttendanceParam param);
}
