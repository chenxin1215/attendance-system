package com.attendance.serviceImpl;

import com.attendance.dao.EmployeeInfoMapper;
import com.attendance.dao.OvertimeInfoMapper;
import com.attendance.dto.requset.OvertimeRequest;
import com.attendance.dto.response.OvertimeDetail;
import com.attendance.entity.EmployeeInfo;
import com.attendance.entity.OvertimeInfo;
import com.attendance.service.OvertimeService;
import com.attendance.utils.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
@Service
public class OvertimeServiceImpl implements OvertimeService {

    @Autowired
    private OvertimeInfoMapper overtimeInfoMapper;

    @Autowired
    private EmployeeInfoMapper employeeInfoMapper;

    public List<OvertimeDetail> queryOvertimeInfoByParam(OvertimeRequest overtimeRequest) {
        Assert.notNull(overtimeRequest.getEmployeeId(), "员工id不能为空！");

        List<OvertimeInfo> overtimeInfos = overtimeInfoMapper.queryOvertimeInfoByParam(overtimeRequest);
        List<OvertimeDetail> overtimeDetails = new ArrayList<OvertimeDetail>();

        for (OvertimeInfo overtimeInfo : overtimeInfos) {

            OvertimeDetail detail = new OvertimeDetail();
            BeanUtils.copyProperties(overtimeInfo, detail);
            EmployeeInfo employeeInfo = employeeInfoMapper.selectById(overtimeInfo.getApproveUserId());
            if (employeeInfo != null) {
                detail.setApproveName(employeeInfo.getEmployeeName());
            }
            if (overtimeInfo.getApproveTime() != null) {
                detail.setApproveTimeStr(DateUtil.dateToString(overtimeInfo.getApproveTime(), DateUtil.DATETIME_BASE));
            }
            if (overtimeInfo.getOverDate() != null) {
                detail.setOverDateStr(DateUtil.dateToString(overtimeInfo.getOverDate(), DateUtil.DATE_BASE));
            }
            overtimeDetails.add(detail);
        }
        return overtimeDetails;
    }
}