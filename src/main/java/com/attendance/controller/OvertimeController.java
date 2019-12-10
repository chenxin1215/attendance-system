package com.attendance.controller;

import com.attendance.dto.requset.OvertimeRequest;
import com.attendance.dto.response.OvertimeDetail;
import com.attendance.dto.view.ListBaseView;
import com.attendance.service.OvertimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("overtime")
@Controller
public class OvertimeController {

    @Autowired
    private OvertimeService overtimeService;

    @ResponseBody
    @RequestMapping(value = "queryOvertimeInfoByParam", method = RequestMethod.POST)
    public ListBaseView<OvertimeDetail> queryOvertimeInfoByParam(@RequestBody OvertimeRequest request) {
        ListBaseView<OvertimeDetail> view = new ListBaseView<>();
        List<OvertimeDetail> dataList = overtimeService.queryOvertimeInfoByParam(request);
        view.success(dataList);
        return view;
    }
}
