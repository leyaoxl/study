package com.wsn.conference.submission.controller;

import com.alibaba.fastjson.JSONObject;
import com.wsn.conference.submission.entity.PaperReview;
import com.wsn.conference.submission.entity.PaperSubmission;
import com.wsn.conference.submission.entity.ReviewComments;
import com.wsn.conference.submission.service.PaperService;
import com.wsn.conference.submission.util.ReturnUtil;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author leyao
 * @version 2018-7-13
 */
@Controller
@RequestMapping(value = "/paper")
public class PaperController {
    private Logger logger = Logger.getLogger(PaperController.class.getName());

    @Autowired
    private PaperService paperService;

    @RequestMapping(value = "/distributionTest", method = RequestMethod.POST)
    @ResponseBody
    public List<PaperReview> testReviewId(@RequestBody List<PaperReview> reviewerId) {
        logger.info("===== " + reviewerId + " =====");
        return reviewerId;
    }

    /**
     * 投稿页测试
     *
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String goUploadImg() throws IOException {
//        String realPath = ResourceUtils.getURL("").getPath();
//        logger.info(realPath);
        return "uploadimg";
    }

    /************************************************************************************************************/

    /**
     * 论文上传
     *
     * @param file
     * @param request
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public JSONObject uploadPaper(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws UnsupportedEncodingException, IOException {
        logger.info("===== start uploadPaper ===== " + this.getClass().getName() + " ===== leyao =====");
        try {
            JSONObject result = paperService.uploadPaper(file, request);
            logger.info("===== end uploadPaper ===== " + this.getClass().getName() + " ===== leyao =====");
            return result;
        }
        catch (DataAccessException e) {
            final Throwable cause = e.getCause();
            logger.info("===== " + cause + " ===== leyao =====");
            if (cause instanceof TooManyResultsException)
                return ReturnUtil.returnUtil(200, false, "请勿重复提交论文");
            return ReturnUtil.returnUtil(200, false, "MySQL错误");
        }
    }

    /**
     * 论文资料上传
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/data", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject uploadPaperData(PaperSubmission paperSubmission, HttpServletRequest request) {
        logger.info("===== start uploadPaperData ===== " + this.getClass().getName() + " ===== leyao =====");
        JSONObject result = paperService.uploadPaperData(paperSubmission, request);
        logger.info("===== end uploadPaperData ===== " + this.getClass().getName() + " ===== leyao =====");
        return result;
    }

    /**
     * 获取论文列表
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getPaperList(String status, @RequestParam(required = false, name = "type") String type, HttpServletRequest request) {
        logger.info("===== start getPaperList ===== " + this.getClass().getName() + " ===== leyao =====");
        JSONObject result = paperService.getPaperSubmissionList(status, type, request);
        logger.info("===== end getPaperList ===== " + this.getClass().getName() + " ===== leyao =====");
        return result;
    }

    /**
     * 删除论文资料及论文文件
     *
     * @param request
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JSONObject deletePaper(HttpServletRequest request, @PathVariable("id") String id) throws Exception {
        logger.info("===== start deletePaper ===== " + this.getClass().getName() + " ===== leyao =====");
        JSONObject result = paperService.deletePaper(request, id);
        logger.info("===== end deletePaper ===== " + this.getClass().getName() + " ===== leyao =====");
        return result;
    }

    /**
     * 论文下载
     *
     * @param request
     * @param response
     * @param id
     * @throws UnsupportedEncodingException
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public void downloadPaper(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") long id)  throws UnsupportedEncodingException  {
        logger.info("===== start download paper ===== " + this.getClass().getName() + " ===== leyao =====");
        paperService.downloadPaper(request, response, id);
        logger.info("===== end download paper ===== " + this.getClass().getName() + " ===== leyao =====");
    }

    /**
     * 获取论文投稿缓存数据
     *
     * @param paperSubmission
     * @return
     */
    @RequestMapping(value = "/data", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getPaperCache(PaperSubmission paperSubmission, HttpServletRequest request) {
        logger.info("===== start get paper data ===== " + this.getClass().getName() + " ===== leyao =====");
        JSONObject result = paperService.getPaperData(paperSubmission, request);
        logger.info("===== end get paper data ===== " + this.getClass().getName() + " ===== leyao =====");
        return result;
    }

    /**
     * 论文审稿分配
     *
     * @param paperReviewList
     * @return
     */
    @RequestMapping(value = "/distribution", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject distributePaper(@RequestBody List<PaperReview> paperReviewList) {
        logger.info("===== start distribute paper ===== " + this.getClass().getName() + " ===== leyao =====");
        JSONObject result = paperService.distributePaper(paperReviewList);
        logger.info("===== end distribute paper ===== " + this.getClass().getName() + " ===== leyao =====");
        return result;
    }

    /**
     * 更新审稿人状态
     *
     * @param paperId
     * @param reviewerId
     * @param status
     * @return
     */
    @RequestMapping(value = "/reviewer/status", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject updateReviewerStatus(@RequestParam("paperId") String paperId, @RequestParam("reviewerId") String reviewerId, @RequestParam("status") String status) {
        logger.info("===== start update reviewer status ===== " + this.getClass().getName() + " ===== leyao =====");
        JSONObject result = paperService.updateReviewerStatus(paperId, reviewerId, status);
        logger.info("===== end update reviewer status ===== " + this.getClass().getName() + " ===== leyao =====");
        return result;
    }

    /**
     * 上传审稿意见
     *
     * @param reviewComments
     * @param request
     * @return
     */
    @RequestMapping(value = "/review/comments", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addReviewComments(ReviewComments reviewComments, HttpServletRequest request) {
        logger.info("===== start add review comments ===== " + this.getClass().getName() + " ===== leyao =====");
        JSONObject result = paperService.addReviewComments(reviewComments, request);
        logger.info("===== end add review comments ===== " + this.getClass().getName() + " ===== leyao =====");
        return result;
    }

    /**
     * 查询审稿列表
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/review/list", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getPaperReviewList(HttpServletRequest request) {
        logger.info("===== start get paper review list ===== " + this.getClass().getName() + " ===== leyao =====");
        JSONObject result = paperService.getPaperReviewList(request);
        logger.info("===== end get paper review list ===== " + this.getClass().getName() + " ===== leyao =====");
        return result;
    }

    /**
     * 查询审稿人列表
     *
     * @param paperReview
     * @return
     */
    @RequestMapping(value = "/reviewer/list", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getReviewerList(PaperReview paperReview) {
        logger.info("===== start get paper reviewer list ===== " + this.getClass().getName() + " ===== leyao =====");
        JSONObject result = paperService.getReviewerList(paperReview);
        logger.info("===== end get paper reviewer list ===== " + this.getClass().getName() + " ===== leyao =====");
        return result;
    }

    /**
     * 查询审稿意见
     *
     * @param reviewComments
     * @return
     */
    @RequestMapping(value = "/review/comments", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getReviewComments(ReviewComments reviewComments) {
        logger.info("===== start get review comments ===== " + this.getClass().getName() + " ===== leyao =====");
        JSONObject result = paperService.getReviewComments(reviewComments);
        logger.info("===== end get review comments ===== " + this.getClass().getName() + " ===== leyao =====");
        return result;
    }

    /**
     * 更新审稿意见采纳状态
     *
     * @param reviewComments
     * @return
     */
    @RequestMapping(value = "/review/comments/status", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject updateReviewCommentsStatus(ReviewComments reviewComments) {
        logger.info("===== start update review comments status ===== " + this.getClass().getName() + " ===== leyao =====");
        JSONObject result = paperService.updateReviewCommentsStatus(reviewComments);
        logger.info("===== end update review comments status ===== " + this.getClass().getName() + " ===== leyao =====");
        return result;
    }

    /**
     * 获取审稿意见列表
     * 当status=1时，查询未采纳意见列表
     * 当status=2时，查询已采纳意见列表
     * 当不传递status时，查询所有意见列表
     *
     * @param reviewComments
     * @return
     */
    @RequestMapping(value = "/review/comments/list", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getReviewCommentsList(ReviewComments reviewComments) {
        logger.info("===== start get review comments list ===== " + this.getClass().getName() + " ===== leyao =====");
        JSONObject result = paperService.getReviewCommentsList(reviewComments);
        logger.info("===== end get review comments list ===== " + this.getClass().getName() + " ===== leyao =====");
        return result;
    }

    /**
     * 更新论文投稿状态
     *
     * @param paperSubmission
     * @return
     */
    @RequestMapping(value = "/submission/result", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject updatePaperSubmissionResult(PaperSubmission paperSubmission) {
        logger.info("===== start update paper submission result ===== " + this.getClass().getName() + " ===== leyao =====");
        JSONObject result = paperService.updatePaperSubmissionResult(paperSubmission);
        logger.info("===== end update paper submission result ===== " + this.getClass().getName() + " ===== leyao =====");
        return result;
    }

    // @RequestMapping(value = "/data/cache", method = RequestMethod.POST)
    // @ResponseBody
    // public JSONObject cachePaperData(
    //         @RequestParam(name = "userId") long userId,
    //         @RequestParam(name = "type") String type,
    //         @RequestParam(name = "title") String title,
    //         @RequestParam(name = "summary") String summary,
    //         @RequestParam(name = "keywords") String keywords) {
    //     logger.info("===== start paper data cache ===== " + this.getClass().getName() + " ===== leyao =====");
    //     JSONObject result = paperService.cachePaperData(userId, type, title, summary, keywords);
    //     logger.info("===== end paper data cache ===== " + this.getClass().getName() + " ===== leyao =====");
    //     return result;
    // }

    /**
     * 下载论文模板
     *
     * @param request
     * @param response
     * @throws UnsupportedEncodingException
     */
    @RequestMapping(value = "/template", method = RequestMethod.GET)
    @ResponseBody
    public void downloadPaperTemplate(HttpServletRequest request, HttpServletResponse response)  throws UnsupportedEncodingException  {
        logger.info("===== start download paper template ===== " + this.getClass().getName() + " ===== leyao =====");
        paperService.downloadPaperTemplate(request, response);
        logger.info("===== end download paper template ===== " + this.getClass().getName() + " ===== leyao =====");
    }
}
