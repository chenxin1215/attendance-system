package com.attendance.dao;

import com.attendance.dto.requset.approve.QueryApproveParam;
import com.attendance.entity.ApproveInfo;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

public interface ApproveInfoMapper extends BaseMapper<ApproveInfo> {

    List<ApproveInfo> queryApprovalListByParam(QueryApproveParam request);
}