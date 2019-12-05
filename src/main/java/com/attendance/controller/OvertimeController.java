package com.attendance.controller;

import com.attendance.dto.requset.OvertimeRequest;
import com.attendance.dto.response.OvertimeDetail;
import com.attendance.entity.EmployeeInfo;
import com.attendance.service.EmployeeService;
import com.attendance.service.OvertimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("overtime")
@Controller
public class OvertimeController {

	@Autowired
	private OvertimeService overtimeService;

	@ResponseBody
	@RequestMapping(value = "queryOvertimeInfoByParam", method = RequestMethod.POST)
	public List<OvertimeDetail> queryOvertimeInfoByParam(@RequestBody OvertimeRequest request) {

		List<OvertimeDetail> dataList = overtimeService.queryOvertimeInfoByParam(request);

		return dataList;
	}
}
