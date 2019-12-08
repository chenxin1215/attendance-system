package com.attendance.serviceImpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendance.dao.ConfigureInfoMapper;
import com.attendance.dto.response.ConfigDetail;
import com.attendance.entity.ConfigureInfo;
import com.attendance.service.ConfigureService;
import com.attendance.utils.DateUtil;

/**
 * 〈一句话功能简述〉<br>
 * 〈配置信息service〉
 *
 * @author cx
 * @create 2019/12/8
 * @since 1.0.0
 */
@Service
public class ConfigureServiceImpl implements ConfigureService {

    @Autowired
    private ConfigureInfoMapper configureInfoMapper;

    public void updateConfig(ConfigureInfo configureInfo) {
        configureInfo.setId(1L);
        configureInfoMapper.updateById(configureInfo);
    }

    public ConfigDetail getConfig() {
        ConfigDetail detail = new ConfigDetail();
        ConfigureInfo configureInfo = configureInfoMapper.selectById(1L);
        BeanUtils.copyProperties(configureInfo, detail);
        detail.setWorkHoursStr(DateUtil.dateToString(configureInfo.getWorkHours(), DateUtil.TIME_BASE));
        detail.setOwHoursStr(DateUtil.dateToString(configureInfo.getOwHours(), DateUtil.TIME_BASE));
        return detail;
    }
}