package com.attendance.serviceImpl;

import com.attendance.dao.LogInfoMapper;
import com.attendance.dto.response.LogInfoDetail;
import com.attendance.entity.LogInfo;
import com.attendance.service.LogInfoService;
import com.attendance.utils.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LogInfoServiceImpl implements LogInfoService {

    @Autowired
    private LogInfoMapper logInfoMapper;

    @Override
    public List<LogInfoDetail> queryLogInfoList() {

        List<LogInfoDetail> result = new ArrayList<>();
        List<LogInfo> logInfos = logInfoMapper.selectList(null);
        for (LogInfo logInfo : logInfos) {
            LogInfoDetail detail = new LogInfoDetail();
            BeanUtils.copyProperties(logInfo, detail);
            detail.setCreateTimeStr(DateUtil.dateToString(logInfo.getCreateTime(), DateUtil.DATETIME_BASE));
            result.add(detail);
        }
        return result;
    }
}
