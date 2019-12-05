package com.attendance.dao;

import com.attendance.dto.requset.OvertimeRequest;
import com.attendance.entity.OvertimeInfo;

import java.util.List;

/**
 * OvertimeInfoMapper继承基类
 */
public interface OvertimeInfoMapper extends BaseMapper<OvertimeInfo, Long> {

	List<OvertimeInfo> queryOvertimeInfoByParam(OvertimeRequest overtimeRequest);
}