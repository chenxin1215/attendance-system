package com.attendance.service;

import com.attendance.dto.requset.QueryLeaveListParam;
import com.attendance.dto.response.LeaveDetail;

import java.util.List;

public interface LeaveService {

	List<LeaveDetail> queryLeaveListByParam(QueryLeaveListParam param);

}
