package com.attendance.serviceImpl;

import com.attendance.dao.OvertimeInfoMapper;
import com.attendance.dto.requset.OvertimeRequest;
import com.attendance.dto.response.OvertimeDetail;
import com.attendance.entity.OvertimeInfo;
import com.attendance.service.OvertimeService;
import com.attendance.utils.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author xx
 * @create 2019-12-05
 * @since 1.0.0
 */
public class OvertimeServiceImpl implements OvertimeService {

	@Autowired
	private OvertimeInfoMapper overtimeInfoMapper;

	public List<OvertimeDetail> queryOvertimeInfoByParam(OvertimeRequest overtimeRequest) {
		Assert.notNull(overtimeRequest.getEmployeeId(), "员工id不能为空！");

		List<OvertimeInfo> overtimeInfos = overtimeInfoMapper.queryOvertimeInfoByParam(overtimeRequest);
		List<OvertimeDetail> overtimeDetails = new ArrayList<OvertimeDetail>();

		for (OvertimeInfo overtimeInfo : overtimeInfos) {

			OvertimeDetail detail = new OvertimeDetail();
			BeanUtils.copyProperties(overtimeInfo, detail);
			// TODO
			detail.setApproveName("");
			detail.setApproveStateStr("");
			detail.setApproveTime("");

			if (overtimeInfo.getOverStarttime() != null) {
				detail.setOverStarttimeStr(DateUtil.dateToString(overtimeInfo.getOverStarttime(),
						DateUtil.DATETIME_BASE));
			}

			// TODO ...

			overtimeDetails.add(detail);
		}
		return overtimeDetails;
	}
}