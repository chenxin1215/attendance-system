package com.attendance.dao;

import com.attendance.dto.requset.approve.QueryApproveParam;
import com.attendance.entity.ApproveInfo;

import java.util.List;

/**
 * ApproveInfoMapper继承基类
 */
public interface ApproveInfoMapper extends BaseMapper<ApproveInfo, Long> {

    List<ApproveInfo> queryApprovalListByParam(QueryApproveParam request);

}