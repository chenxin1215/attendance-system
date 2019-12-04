package com.attendance.serviceImpl;

import com.attendance.dao.EmployeeInfoMapper;
import com.attendance.dto.requset.QueryEmployeeListParam;
import com.attendance.dto.response.EmployeeDetail;
import com.attendance.entity.EmployeeInfo;
import com.attendance.enums.EmployeeStateEnum;
import com.attendance.enums.EmployeeTypeEnum;
import com.attendance.enums.PositionTypeEnum;
import com.attendance.service.EmployeeService;
import com.attendance.utils.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeInfoMapper employeeInfoMapper;

    public List<EmployeeDetail> queryEmployeeListByParam(QueryEmployeeListParam param) {

        // 定义返回数据对象
        List<EmployeeDetail> result = new ArrayList<EmployeeDetail>();

        // 获取员工基本信息
        List<EmployeeInfo> employeeInfoList = employeeInfoMapper.queryEmployeeListByParam(param);

        // 组装详细信息
        for (EmployeeInfo employeeInfo : employeeInfoList) {
            EmployeeDetail detail = new EmployeeDetail();
            BeanUtils.copyProperties(employeeInfo, detail);
            detail.setEnterDateStr(DateUtil.dateToString(employeeInfo.getEnterDate(), DateUtil.DATE_BASE));
            detail.setPositionStr(PositionTypeEnum.parse(employeeInfo.getPosition()).toString());
            detail.setEmployeeTypeStr(EmployeeTypeEnum.parse(employeeInfo.getEmployeeType()).toString());
            detail.setStateStr(EmployeeStateEnum.parse(employeeInfo.getState()).toString());

            result.add(detail);
        }

        return result;
    }

    public EmployeeDetail getEmployeeById(Long employeeId) {

        // 获取员工基本信息
        EmployeeInfo employeeInfo = employeeInfoMapper.selectByPrimaryKey(employeeId);

        // 组装员工信息
        EmployeeDetail employeeDetail = new EmployeeDetail();
        // 复制类
        BeanUtils.copyProperties(employeeInfo, employeeDetail);
        // 职务
        employeeDetail.setPositionStr(PositionTypeEnum.parse(employeeInfo.getPosition()).toString());
        // 入职日期
        employeeDetail.setEnterDateStr(DateUtil.dateToString(employeeInfo.getEnterDate(), DateUtil.DATE_BASE));
        // 员工身份
        employeeDetail.setEmployeeTypeStr(EmployeeTypeEnum.parse(employeeInfo.getEmployeeType()).toString());
        // 员工在职状态
        employeeDetail.setStateStr(EmployeeStateEnum.parse(employeeInfo.getState()).toString());

        return employeeDetail;
    }

    public Long insertEmployee(EmployeeInfo employeeInfo) {
        employeeInfoMapper.insert(employeeInfo);
        return employeeInfo.getEmployeeId();
    }

    public void updateByPrimaryKey(EmployeeInfo employeeInfo) {
        employeeInfoMapper.updateByPrimaryKeySelective(employeeInfo);
    }

    /**
     * 开出员工 将状态改为2
     * 
     * @param employeeId
     */
    public void outEmployee(Long employeeId) {
        EmployeeInfo employeeInfo = new EmployeeInfo();
        employeeInfo.setEmployeeId(employeeId);
        employeeInfo.setState(EmployeeStateEnum.QUITJOB.value());
        employeeInfoMapper.updateByPrimaryKeySelective(employeeInfo);
    }
}
