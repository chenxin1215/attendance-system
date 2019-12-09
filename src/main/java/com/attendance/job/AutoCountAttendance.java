package com.attendance.job;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class AutoCountAttendance {

    /**
     * 功能描述: 每日凌晨自动计算当日考勤信息
     *
     * @Author: chenxin
     * @Date: 2019/12/9
     */
    @Scheduled(cron = "${job.autoCountAttendance:0 0 0 * * ?}")
    public void autoCountAttendance() {

    }

}
