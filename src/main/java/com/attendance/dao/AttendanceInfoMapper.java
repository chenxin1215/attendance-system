package com.attendance.dao;

import com.attendance.entity.AttendanceInfo;
import com.attendance.dto.requset.attendance.QueryAttendanceInfoParam;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface AttendanceInfoMapper extends BaseMapper<AttendanceInfo> {

    List<AttendanceInfo> queryAttendanceByParam(QueryAttendanceInfoParam param);

}