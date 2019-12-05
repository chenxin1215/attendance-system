package com.attendance.service;

import com.attendance.dto.requset.OvertimeRequest;
import com.attendance.dto.response.OvertimeDetail;

import java.util.List;

public interface OvertimeService {

	//按条件查询加班信息
	List<OvertimeDetail> queryOvertimeInfoByParam(OvertimeRequest overtimeRequest);

}
