package com.wsn.conference.submission.controller;

import com.alibaba.fastjson.JSONObject;
import com.wsn.conference.submission.util.ReturnUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

@ControllerAdvice
public class ExceptionHandle {
    private Logger logger = Logger.getLogger(ExceptionHandle.class.getName());

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public JSONObject handle(Exception e) {
        if (e instanceof RuntimeException) {
            RuntimeException runtimeException = (RuntimeException) e;
            logger.info("===== Exception ===== " + e.getMessage());
            return ReturnUtil.returnUtil(200, false, e.getMessage());
        }
        else {
            logger.info("===== Exception ===== " + e.getMessage());
            return ReturnUtil.returnUtil(200, false, "系统错误", e.getMessage());
        }
    }
}
