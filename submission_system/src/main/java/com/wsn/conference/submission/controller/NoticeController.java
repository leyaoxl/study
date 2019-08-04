package com.wsn.conference.submission.controller;

import com.alibaba.fastjson.JSONObject;
import com.wsn.conference.submission.entity.Notice;
import com.wsn.conference.submission.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

/**
 * @author leyao
 * @version 2018-8-28
 */
@Controller
@RequestMapping(value = "/notice")
public class NoticeController {
    private Logger logger = Logger.getLogger(NoticeController.class.getName());

    @Autowired
    private NoticeService noticeService;

    /**
     * 添加通知
     *
     * @param notice
     * @return result
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addNotice(Notice notice) {
        logger.info("===== start add notice ===== " + this.getClass().getName() + " ===== leyao =====");
        JSONObject result = noticeService.addNotice(notice);
        logger.info("===== end add notice ===== " + this.getClass().getName() + " ===== leyao =====");
        return result;
    }

    /**
     * 查询通知列表
     *
     * @return result
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getNoticeList(Notice notice) {
        logger.info("===== start get notice list ===== " + this.getClass().getName() + " ===== leyao =====");
        JSONObject result = noticeService.getNoticeList(notice);
        logger.info("===== end get notice list ===== " + this.getClass().getName() + " ===== leyao =====");
        return result;
    }

    @RequestMapping(value = "/status", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject updateNoticeStatus(Notice notice) {
        logger.info("===== start update notice status ===== " + this.getClass().getName() + " ===== leyao =====");
        JSONObject result = noticeService.updateNoticeStatus(notice);
        logger.info("===== end update notice status ===== " + this.getClass().getName() + " ===== leyao =====");
        return result;
    }
}
