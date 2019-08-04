package com.wsn.conference.submission.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author leyao
 * @version 2018-9-3
 */
@Controller
@RequestMapping(value = "/returnPage")
public class ReturnPageController {
    @RequestMapping(value = "/failed/login", method = RequestMethod.GET)
    public String returnLoginFailedPage() {
        return "loginFailedPage";
    }
}
