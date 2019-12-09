package com.attendance.service;

import com.attendance.dto.requset.approve.ApprovalRequest;
import com.attendance.dto.requset.approve.QueryApproveParam;
import com.attendance.dto.response.approve.ApproveInfoData;

import java.util.List;

public interface ApproveService {

    /**
     * 功能描述: 发起审批 <br>
     *
     * @Author: xx
     * @Date: 2019/12/6
     */
    void addApprove(ApprovalRequest request);

    /**
     * 列表查询
     *
     * @Author: chenxin
     * @Date: 2019/12/6
     */
    List<ApproveInfoData> queryApprovalListByParam(QueryApproveParam request);

    /**
     * 通过审批
     *
     * @Author: chenxin
     * @Date: 2019/12/6
     */
    void passApproval(Long approveId, Long checkUserId);

    /**
     * 拒绝审批
     *
     * @Author: chenxin
     * @Date: 2019/12/6
     */
    void refusedApproval(Long approveId, Long checkUserId);

}
