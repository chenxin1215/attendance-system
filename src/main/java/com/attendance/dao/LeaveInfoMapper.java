package com.attendance.dao;

import com.attendance.dto.requset.QueryLeaveListParam;
import com.attendance.entity.LeaveInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface LeaveInfoMapper extends BaseMapper<LeaveInfo> {

    List<LeaveInfo> queryLeaveListByParam(QueryLeaveListParam param);
	
}