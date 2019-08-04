package com.wsn.conference.submission.controller;

import com.alibaba.fastjson.JSONObject;
import com.itextpdf.text.DocumentException;
import com.wsn.conference.submission.dao.PaperDao;
import com.wsn.conference.submission.entity.PaperReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class TestController {
    private Logger logger = Logger.getLogger(TestController.class.getName());

    @Autowired
    private PaperDao paperDao;

    // @RequestMapping(value = "/test")
    // @ResponseBody
    // public String test() throws Exception {
    //     logger.info("===== " + AESKey + " ===== leyao =====");
    //     String password = "123456";
    //     logger.info(AESUtil.encrypt(password, AESKey));
    //     String str = "0270F6C1981976FB7297D7FA9D7DA7EE";
    //     logger.info(AESUtil.decrypt(str, AESKey));
    //     return "success";
    // }

    @RequestMapping(value = "/emailTest")
    public String emailTest() {
        return "resetTemplate";
    }

    @RequestMapping(value = "/pdfTest")
    public void downloadPDF() throws DocumentException{

    }

    @RequestMapping(value = "/cookieTest", method = RequestMethod.GET)
    @ResponseBody
    public void setCookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie("userId", "1234");
        response.addCookie(cookie);
    }

    @RequestMapping(value = "/")
    public String index() {
        return "/index.html";
    }



}