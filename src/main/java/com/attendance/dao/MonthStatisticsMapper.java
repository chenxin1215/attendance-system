package com.attendance.dao;

import com.attendance.dto.requset.attendance.QueryAttendanceInfoParam;
import com.attendance.entity.MonthStatistics;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

public interface MonthStatisticsMapper extends BaseMapper<MonthStatistics> {

    List<MonthStatistics> queryAttendanceMonthByParam(QueryAttendanceInfoParam param);

}