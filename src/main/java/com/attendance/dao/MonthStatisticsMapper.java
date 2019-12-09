package com.attendance.dao;

import com.attendance.dto.requset.attendance.QueryAttendanceInfoParam;
import com.attendance.entity.MonthStatistics;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MonthStatisticsMapper extends BaseMapper<MonthStatistics> {

    void batchInsert(@Param("list") List<MonthStatistics> monthStatisticList);

    List<MonthStatistics> queryAttendanceMonthByParam(QueryAttendanceInfoParam param);

    int queryAttendanceMonthListByParamCount(QueryAttendanceInfoParam param);

}