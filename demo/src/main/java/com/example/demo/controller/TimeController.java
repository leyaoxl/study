package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TimeController {
    @Autowired
    TimeService timeService;

    @RequestMapping(value = "/")
    @ResponseBody
    public JSONObject test() {
        JSONObject result = timeService.test();
        return result;
    }
}
