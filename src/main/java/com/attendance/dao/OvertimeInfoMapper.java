package com.attendance.dao;

import com.attendance.dto.requset.OvertimeRequest;
import com.attendance.entity.OvertimeInfo;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

public interface OvertimeInfoMapper extends BaseMapper<OvertimeInfo> {

    List<OvertimeInfo> queryOvertimeInfoByParam(OvertimeRequest overtimeRequest);

}