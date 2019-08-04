package com.wsn.conference.submission.controller;

import com.alibaba.fastjson.JSONObject;
import com.wsn.conference.submission.entity.PaperAuthor;
import com.wsn.conference.submission.service.PaperAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

/**
 * @author leyao
 * @version 2019-1-21
 */
@Controller
@RequestMapping(value = "/paper/author")
public class PaperAuthorController {
    private Logger logger = Logger.getLogger(PaperController.class.getName());

    @Autowired
    private PaperAuthorService paperAuthorService;

    /**
     * 添加论文作者信息
     * @param paperAuthor
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addPaperAuthor(PaperAuthor paperAuthor) {
        logger.info("===== start addPaperAuthor ===== " + this.getClass().getName() + " ===== leyao =====");
        JSONObject result = paperAuthorService.addPaperAuthor(paperAuthor);
        logger.info("===== end addPaperAuthor ===== " + this.getClass().getName() + " ===== leyao =====");
        return result;
    }

    /**
     * 查询论文作者信息列表
     * @param paperId
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getPaperAuthorList(long paperId) {
        logger.info("===== start getPaperAuthorList ===== " + this.getClass().getName() + " ===== leyao =====");
        JSONObject result = paperAuthorService.getPaperAuthorList(paperId);
        logger.info("===== end getPaperAuthorList ===== " + this.getClass().getName() + " ===== leyao =====");
        return result;
    }

    /**
     * 更新论文作者信息
     * @param paperAuthor
     * @return
     */
    @RequestMapping(value = "/info", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject updatePaperAuthor(PaperAuthor paperAuthor) {
        logger.info("===== start updatePaperAuthor ===== " + this.getClass().getName() + " ===== leyao =====");
        JSONObject result = paperAuthorService.updatePaperAuthor(paperAuthor);
        logger.info("===== end updatePaperAuthor ===== " + this.getClass().getName() + " ===== leyao =====");
        return result;
    }

    /**
     * 删除论文作者信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JSONObject deletePaperAuthor(@PathVariable("id") long id) {
        logger.info("===== start delete paper author ===== " + this.getClass().getName() + " ===== leyao =====");
        JSONObject result = paperAuthorService.deletePaperAuthor(id);
        logger.info("===== end delete paper author ===== " + this.getClass().getName() + " ===== leyao =====");
        return result;
    }
}
