package com.attendance.serviceImpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendance.dao.EmployeeInfoMapper;
import com.attendance.dto.response.EmployeeDetail;
import com.attendance.entity.EmployeeInfo;
import com.attendance.enums.EmployeeStateEnum;
import com.attendance.enums.EmployeeTypeEnum;
import com.attendance.enums.PositionTypeEnum;
import com.attendance.service.EmployeeService;
import com.attendance.utils.DateUtil;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeInfoMapper employeeInfoMapper;

    public List<EmployeeInfo> queryAllEmployeeList() {

        List<EmployeeInfo> employeeInfos = employeeInfoMapper.queryAllEmployeeList();

        return employeeInfos;
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
