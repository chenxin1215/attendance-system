package com.attendance.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 〈一句话功能简述〉<br>
 * 〈用来复制的模型〉
 *
 * @author xx
 * @create 2019/11/25
 * @since 1.0.0
 */
public class PublicController {

    @RequestMapping(value = "method", method = RequestMethod.POST)
    @ResponseBody
    public Object method(@RequestBody Object request) {

        Object obj = new Object();

        return obj;

    }

}