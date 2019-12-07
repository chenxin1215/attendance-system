package com.attendance.serviceImpl;

import com.attendance.dao.ApproveInfoMapper;
import com.attendance.dao.EmployeeInfoMapper;
import com.attendance.dto.requset.approve.ApprovalRequest;
import com.attendance.dto.requset.approve.QueryApproveParam;
import com.attendance.dto.response.approve.ApproveInfoData;
import com.attendance.entity.ApproveInfo;
import com.attendance.entity.EmployeeInfo;
import com.attendance.enums.ApproveStateEnum;
import com.attendance.enums.ApproveTypeEnum;
import com.attendance.service.ApproveService;
import com.attendance.utils.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApproveServiceImpl implements ApproveService {

    @Autowired
    private ApproveInfoMapper approveInfoMapper;

    @Autowired
    private EmployeeInfoMapper employeeInfoMapper;

    public void addApprove(ApprovalRequest request) {

        EmployeeInfo employeeInfo = employeeInfoMapper.selectByPrimaryKey(request.getApprovalUserId());

        Assert.notNull(employeeInfo, "审批发起人不存在！");
        Assert.notNull(request.getApprovalType(), "审批类型不能为空！");
        Assert.notNull(request.getStartDateStr(), "开始时间不能为空！");
        Assert.notNull(request.getEndDateStr(), "结束时间不能为空！");

        ApproveInfo approveInfo = new ApproveInfo();
        BeanUtils.copyProperties(request, approveInfo);
        approveInfo.setEmployeeId(employeeInfo.getEmployeeId());
        approveInfo.setEmployeeName(employeeInfo.getEmployeeName());
        approveInfo.setStartDate(DateUtil.stringToDate(request.getStartDateStr(), DateUtil.DATE_BASE));
        approveInfo.setEndDate(DateUtil.stringToDate(request.getEndDateStr(), DateUtil.DATE_BASE));
        approveInfo.setApproveReason(request.getApprovalContent());
        approveInfo.setApproveState(ApproveStateEnum.NO_CHECK.value());

        approveInfoMapper.insertSelective(approveInfo);
    }

    public List<ApproveInfoData> queryApprovalListByParam(QueryApproveParam request) {
        List<ApproveInfoData> dataList = new ArrayList<ApproveInfoData>();
        List<ApproveInfo> approveInfos = approveInfoMapper.queryApprovalListByParam(request);
        for (ApproveInfo approveInfo : approveInfos) {
            ApproveInfoData data = new ApproveInfoData();
            BeanUtils.copyProperties(approveInfo, data);
            if (approveInfo.getApproveTime() != null) {
                data.setApproveTimeStr(DateUtil.dateToString(approveInfo.getApproveTime(), DateUtil.DATETIME_BASE));
            }
            data.setCreateTimeStr(DateUtil.dateToString(approveInfo.getApproveTime(), DateUtil.DATETIME_BASE));
            data.setApproveStateStr(ApproveStateEnum.parse(approveInfo.getApproveState()).toString());
            data.setApproveTypeStr(ApproveTypeEnum.parse(approveInfo.getApproveType()).toString());
            dataList.add(data);
        }
        return dataList;
    }

    public void updateApproveState(ApproveInfo approveInfo) {
        Assert.notNull(approveInfo.getApproveId(), "id 不能为空！");
        Assert.notNull(approveInfo.getApproveState(), "状态不能为空！");

        ApproveInfo update = new ApproveInfo();
        update.setApproveId(approveInfo.getApproveId());
        update.setApproveState(approveInfo.getApproveState());
        approveInfoMapper.updateByPrimaryKeySelective(update);
    }
}
