package com.attendance.controller;

import com.attendance.dto.requset.LoginRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 〈一句话功能简述〉<br>
 * 〈登陆控制器〉
 *
 * @author xx
 * @create 2019/11/24
 * @since 1.0.0
 */
@Controller
public class LoginController {

    @RequestMapping(value = "userLogin", method = RequestMethod.POST)
    @ResponseBody
    public void userLogin(@RequestBody LoginRequest request) {

    }

}