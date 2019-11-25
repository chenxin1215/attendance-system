package com.attendance.dto.response;

import com.attendance.entity.MonthStatistics;

/**
 * 〈一句话功能简述〉<br>
 * 〈考勤信息（按月统计）〉
 *
 * @author xx
 * @create 2019/11/25
 * @since 1.0.0
 */
public class AttendanceMonthInfo extends MonthStatistics {

    /**
     * 平均工作时长（小时）
     */
    private Float averageWorkingHours;

    public Float getAverageWorkingHours() {
        return averageWorkingHours;
    }

    public void setAverageWorkingHours(Float averageWorkingHours) {
        this.averageWorkingHours = averageWorkingHours;
    }
}