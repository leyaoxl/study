package com.wsn.conference.submission.service.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import com.wsn.conference.submission.dao.PaperDao;
import com.wsn.conference.submission.dao.UserInfoDao;
import com.wsn.conference.submission.entity.*;
import com.wsn.conference.submission.service.PaperService;
import com.wsn.conference.submission.service.RedisService;
import com.wsn.conference.submission.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Future;
import java.util.logging.Logger;

/**
 * @author leyao
 * @version 2018-7-13
 */
@Service
public class PaperServiceImpl implements PaperService {
    private Logger logger = Logger.getLogger(PaperServiceImpl.class.getName());
    private SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Value("${paper.path}")
    private String paperPath;

    @Value("${water-mark.paper.path}")
    private String waterMarkPaperPath;

    @Value("${template.path}")
    private String templatePath;

    @Value("${template.fileName}")
    private String templateFileName;

    @Value("${host.address}")
    private String hostAddress;

    @Value("${paper.mail.address}")
    private String paperMailAddress;

    @Autowired
    private PaperDao paperDao;

    @Autowired
    private UserInfoDao userInfoDao;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RedisService redisService;

    @Autowired
    MailUtil mailUtil;

    @Override
    @Transactional
    public JSONObject uploadPaper(MultipartFile file, HttpServletRequest request) throws UnsupportedEncodingException, IOException {
        logger.info("===== start uploadPaper ===== " + this.getClass().getName() + " ===== leyao =====");
        /*
        获取当前登录状态下的user_id和用户名
         */
        long userId = CookieUtil.getUserId(request);
        String userName = CookieUtil.getUserName(request);

        logger.info("===== " + userId + ": " + userName + " ===== leyao =====");

        /*
        首先判断数据库里是否已经上传
         */
        PaperSubmission paperSubmission = new PaperSubmission();
        paperSubmission.setUserId(userId);
        paperSubmission.setContributor(userName);
        String paperName = file.getOriginalFilename();
        paperSubmission.setFileName(paperName);
        PaperSubmission tmp = paperDao.getPaperSubmission(paperSubmission);
        if (tmp != null) throw new RuntimeException("Please do not upload file repeatedly.");

        /*
        验证上传论文类型是不是PDF
         */
        String fileType = FileUtil.getType(file).getType();
        logger.info("===== fileType ===== " + fileType + " ===== leyao =====");
        if (!fileType.equals("PDF")) throw new RuntimeException("You must upload one Formatted Main File - PDF Document Only file.");


        /*
        上传论文
         */
        String paperPath = this.paperPath;
        String waterMarkPaperPath = this.waterMarkPaperPath;
        try {
            logger.info("===== start uploadPaper ===== leyao =====");
            FileUtil.uploadFile(file.getBytes(), paperPath, paperName, userId);
            logger.info("===== end uploadPaper ===== leyao =====");
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("论文上传失败");
        }
        /*
        将上传成功后的论文路径、论文名及user_id保存
         */
        paperSubmission.setPath(paperPath + userId + "/" + paperName);
        paperSubmission.setWatermarkPath(waterMarkPaperPath + userId + "/" + paperName);

        logger.info("===== paper submission ===== " + paperSubmission + " ===== leyao =====");
        paperDao.addPaperSubmission(paperSubmission);
        PaperSubmission tmp1 = paperDao.getPaperSubmission(paperSubmission);
        if (tmp1 == null)
            throw new RuntimeException("论文上传失败");

        /*
        论文上传成功后，需要提醒用户上传成功，并且将论文发送至论文邮箱进行备份
         */
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        logger.info("===== userInfo ===== " + userInfo + " ===== leyao =====");
        userInfo = userInfoDao.getUserInfo(userInfo);
        logger.info("===== userInfo ===== " + userInfo + " ===== leyao =====");

        /*
        给用户发送投稿成功邮件
         */
        String email = userInfo.getEmail();
        Email emailObj1 = new Email();
        emailObj1.setReciever(email);
        emailObj1.setSubject("Submission Success");
        emailObj1.setTemplate("submitSuccess");

        String date = sdfDate.format(new Date());

        HashMap<String, String> map1 = new HashMap<>();
        map1.put("date", date);
        map1.put("username", userInfo.getUsername());
        String fileName = tmp1.getFileName().split("\\.")[0];
        map1.put("fileName", fileName);
        emailObj1.setMailMap(map1);
        logger.info("===== map1 ===== " + map1 + " ===== leyao =====");

        try {
            mailUtil.sendTemplateMail(emailObj1);
            logger.info("===== 投稿成功邮件发送成功 ===== leyao =====");
        }
        catch (Exception e) {
            throw new RuntimeException("投稿成功邮件发送失败");
        }

        /*
        给论文邮箱发送论文以作备份
         */
        Email emailObj2 = new Email();
        emailObj2.setReciever(paperMailAddress);
        emailObj2.setSubject("Paper Backup");
        emailObj2.setTemplate("paperBackup");

        HashMap<String, String> map2 = new HashMap<>();
        map2.put("date", date);
        map2.put("username", userInfo.getUsername());
        map2.put("fileName", fileName);
        emailObj2.setMailMap(map2);

        try {
            FileSystemResource fileSystemResource = new FileSystemResource(tmp1.getPath());
            mailUtil.sendTemplateMailWithAttachment(emailObj2, fileSystemResource);
            logger.info("===== 论文备份邮件发送成功 ===== leyao =====");
        }
        catch (Exception e) {
            throw new RuntimeException("论文备份邮件发送失败");
        }

        logger.info("===== end uploadPaper ===== " + this.getClass().getName() + " ===== leyao =====");
        return ReturnUtil.returnUtil(200, true, "论文上传成功", tmp1);
    }

    @Override
    @Transactional
    public JSONObject uploadPaperData(PaperSubmission paperSubmission, HttpServletRequest request) {
        logger.info("===== start uploadPaperData ===== " + this.getClass().getName() + " ===== leyao =====");
        /*
        获取当前登录状态下的user_id
         */
        long userId = CookieUtil.getUserId(request);

        /*
        paperSubmission拼装userId
         */
        paperSubmission.setUserId(userId);
        logger.info("===== paper submission ===== " + paperSubmission + " ===== leyao =====");

        /*
        先判断是否有该记录，没有的话直接返回
         */
        PaperSubmission tmp = new PaperSubmission();
        tmp.setId(paperSubmission.getId());
        tmp.setUserId(paperSubmission.getUserId());
        tmp.setFileName(paperSubmission.getFileName());
        logger.info("===== tmp ===== " + tmp + " ===== leyao =====");
        tmp = paperDao.getPaperSubmission(tmp);
        logger.info("===== tmp ===== " + tmp + " ===== leyao =====");
        if (tmp == null)
            throw new RuntimeException("论文资料上传失败，请确保论文已上传");

        /*
        更新paper_submission表
         */
        paperDao.updatePaperSubmission(paperSubmission);

        /*
        当投稿完成时写入paper_review_total表
         */
        if (paperSubmission.getStatus().equals("finished")) {
            PaperSubmission tmp1 = paperDao.getPaperSubmission(paperSubmission);
            logger.info("===== tmp1 ===== " + tmp1 + " ===== leyao =====");
            PaperReviewTotal paperReviewTotal = new PaperReviewTotal();
            paperReviewTotal.setPaperId(tmp1.getId());
            paperReviewTotal.setContributorId(userId);
            paperReviewTotal.setDistributionStatus(0);
            logger.info("===== paper review total ===== " + paperReviewTotal + " ===== leyao =====");
            paperDao.addPaperReviewTotal(paperReviewTotal);
            PaperReviewTotal tmp2 = paperDao.getPaperReviewTotal(paperReviewTotal);
            logger.info("===== tmp2 ===== " + tmp2 + " ===== leyao =====");
            if (tmp2 == null)
                throw new RuntimeException("论文资料上传失败，数据未写入paper_review_total表中");
        }
        logger.info("===== end uploadPaperData ===== " + this.getClass().getName() + " ===== leyao =====");
        return ReturnUtil.returnUtil(200, true, "论文资料上传完成");
    }

    @Override
    public JSONObject getPaperSubmissionList(String status, String type, HttpServletRequest request) {
        logger.info("===== start getPaperList ===== " + this.getClass().getName() + " ===== leyao =====");
        /*
        获取当前登录状态下的user_id和role
         */
        long userId = CookieUtil.getUserId(request);
        String role = CookieUtil.getRole(request);
        HashMap<String, Object> hashMap = new HashMap<>();
        if (role.equals("editor"))
            hashMap.put("userId", 0);
        else {
            hashMap.put("userId", userId);
        }
        hashMap.put("status", status);
        hashMap.put("type", type);
        logger.info("===== hashMap ===== " + hashMap + " ===== leyao =====");
        List<HashMap<String, Object>> hashMapList = paperDao.getPaperSubmissionList(hashMap);
        if (hashMapList == null) return ReturnUtil.returnUtil(200, false, "该用户无论文投稿", hashMapList);
        logger.info("===== hashMapList ===== " + hashMapList + " ===== le yao =====");
        logger.info("===== end getPaperList ===== " + this.getClass().getName() + " ===== leyao =====");
        return ReturnUtil.returnUtil(200, true, "论文列表查询成功", hashMapList);
    }

    @Override
    @Transactional
    public JSONObject deletePaper(HttpServletRequest request, String id) throws Exception {
        logger.info("===== start delete paper ===== " + this.getClass().getName() + " ===== leyao =====");
        /*
        获取当前登录状态下的user_id
         */
        long userId = CookieUtil.getUserId(request);
        long paperId = Long.parseLong(id);
        logger.info("===== paper id ===== " + paperId + " ===== leyao =====");

        /*
        拼装paperSubmission对象
         */
        PaperSubmission paperSubmission = new PaperSubmission();
        paperSubmission.setId(paperId);
        paperSubmission.setUserId(userId);
        paperSubmission = paperDao.getPaperSubmission(paperSubmission);
        logger.info("===== paper submission ===== " + paperSubmission + " ===== leyao =====");

        /*
        删除文件
         */
        String fileLocation = paperSubmission.getPath();
        FileUtil.deleteFile(fileLocation);

        /*
        删除paper表里记录
         */
        paperDao.deletePaperSubmission(paperId, userId);
        paperSubmission = paperDao.getPaperSubmission(paperSubmission);
        logger.info("===== paper submission ===== " + paperSubmission + " ===== leyao =====");
        if (paperSubmission != null) throw new RuntimeException("删除paper记录失败");

        logger.info("===== end delete paper ===== " + this.getClass().getName() + " ===== leyao =====");
        return ReturnUtil.returnUtil(200, true, "删除论文成功");
    }

    @Override
    public void downloadPaper(HttpServletRequest request, HttpServletResponse response, long id)  throws UnsupportedEncodingException  {
        logger.info("===== start download paper ===== " + this.getClass().getName() + " ===== leyao =====");


        // 首先根据paper id获取论文对象
        PaperSubmission paperSubmission = new PaperSubmission();
        paperSubmission.setId(id);
        logger.info("===== paper submission ===== " + paperSubmission + " ===== leyao =====");
        paperSubmission = paperDao.getPaperSubmission(paperSubmission);
        logger.info("===== paper submission ===== " + paperSubmission + " ===== leyao =====");
        // 生成带水印的pdf
        try {
            PDFUtil.setWaterMarkForPDF(paperSubmission);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("论文水印副本生成失败");
        }
        logger.info("===== finish watermark ===== leyao =====");
        // 下载带水印的副本
        FileUtil.downloadFile(request, response, paperSubmission);
        logger.info("===== end download paper ===== " + this.getClass().getName() + " ===== leyao =====");
    }

    @Override
    public JSONObject getPaperData(PaperSubmission paperSubmission, HttpServletRequest request) {
        logger.info("===== start get paper data ===== " + this.getClass().getName() + " ===== leyao =====");

        long userId = 0L;
        if (paperSubmission.getUserId() == 0) {
            /*
        获取当前登录状态下的user_id
         */
            userId = CookieUtil.getUserId(request);
        }
        else userId = paperSubmission.getUserId();
        paperSubmission.setUserId(userId);
        logger.info("===== paper data ===== " + paperSubmission + " ===== leyao =====");
        paperSubmission = paperDao.getPaperSubmission(paperSubmission);
        logger.info("===== paper data ===== " + paperSubmission + " ===== leyao =====");
        logger.info("===== end get paper data ===== " + this.getClass().getName() + " ===== leyao =====");
        if (paperSubmission == null) return ReturnUtil.returnUtil(200, true, "获取数据成功");
        return ReturnUtil.returnUtil(200, true, "获取数据成功", paperSubmission);
    }

    @Override
    @Transactional
    public JSONObject distributePaper(List<PaperReview> paperReviewList) {
        logger.info("===== start distribute paper ===== " + this.getClass().getName() + " ===== leyao =====");
        long start = System.currentTimeMillis();
        logger.info("===== paper review list ===== " + paperReviewList + " ===== leyao =====");
        if (paperReviewList == null) throw new RuntimeException("论文分配异常，请检查数据完整性");

        long paperId = 0L;
        long contributorId = 0L;
        int distributionStatus = 1;
        boolean emailStatus = true;
        ArrayList<Boolean> emailStatusList = new ArrayList<>();
        /*
        遍历提交的reviewId
         */
        for (PaperReview paperReview : paperReviewList) {
            logger.info("===== paper review ===== " + paperReview + " ===== leyao =====");
            /*
            为paperId和contributorId赋值
             */
            if (paperId == 0L || contributorId == 0L) {
                paperId = paperReview.getPaperId();
                logger.info("===== paperId ===== " + paperId + " ===== leyao =====");
                contributorId = paperReview.getContributorId();
                logger.info("===== contributorId ===== " + contributorId + " ===== leyao =====");
            }

            /*
            先判断数据库里是否有重复的reviewerId
            重复则进入下一次循环
             */
            PaperReview tmp = paperDao.getPaperReview(paperReview);
            if (tmp != null) {
                logger.info("===== tmp ===== " + tmp + " ===== leyao =====");
                logger.info("===== reviewerId已重复 ===== " + tmp.getReviewerId() + " ===== leyao =====");
                continue;
            }
            /*
            当没有该reviewerId记录时，将数据存入数据库中
            并验证是否成功插入
             */
            paperDao.addPaperReview(paperReview);
            tmp = paperDao.getPaperReview(paperReview);
            logger.info("===== tmp ===== " + tmp + " ===== leyao =====");
            if (tmp == null) throw new RuntimeException("论文分配异常，paperReview插入数据库失败");

            /*
            为分配的审稿人发送邮件
             */
            long reviewerId = paperReview.getReviewerId();
            UserInfo userInfo = new UserInfo();
            userInfo.setUserId(reviewerId);
            logger.info("===== userInfo ===== " + userInfo + " ===== leyao =====");
            userInfo = userInfoDao.getUserInfo(userInfo);
            logger.info("===== userInfo ===== " + userInfo + " ===== leyao =====");

            String email = userInfo.getEmail();
            Email emailObj = new Email();
            emailObj.setReciever(email);
            emailObj.setSubject("Review Invite");
            emailObj.setTemplate("inviteReviewer");

            /*
            填充freemarker数据
            根据paperId获取paper data
             */
            PaperSubmission paperSubmission = new PaperSubmission();
            paperSubmission.setId(paperReview.getPaperId());
            paperSubmission = paperDao.getPaperSubmission(paperSubmission);
            logger.info("===== paperSubmission ===== " + paperSubmission + " ===== leyao =====");

            String date = sdfDate.format(new Date());
            String reviewerName = userInfo.getUsername();
            String contributorTitle = paperSubmission.getTitle();
            String contributorAbstract = paperSubmission.getSummary();

            HashMap<String, String> map = new HashMap<>();
            map.put("date", date);
            map.put("reviewerName", reviewerName);
            map.put("contributorTitle", contributorTitle);
            map.put("contributorAbstract", contributorAbstract);
            map.put("paperId", paperId + "");
            map.put("reviewerId", reviewerId + "");
            map.put("hostAddress", hostAddress);
            emailObj.setMailMap(map);
            try {
                Future<String> emailTmp = mailUtil.sendTemplateMail(emailObj);
                boolean emailTmpBoolean = false;
                while (true) {
                    if (emailTmp.isDone()) break;
                }
                emailTmpBoolean = emailTmp.isDone();
                emailStatusList.add(emailTmpBoolean);
                long end = System.currentTimeMillis();
                logger.info("===== time ===== " + paperReview.getReviewerId() + ": " + (end - start) + " ===== leyao =====");
            }
            catch (Exception e) {
                throw new RuntimeException("邀请审稿邮件发送失败");
            }
        }

        /*
        检查异步有没有执行完，如果没有则返回
         */
        if (emailStatusList.size() != paperReviewList.size())
            throw new RuntimeException("邀请审稿邮件发送失败，发送邮件数目不对");
        for (boolean b : emailStatusList) {
            logger.info(b + "");
            emailStatus = emailStatus && b;
        }
        if (!emailStatus)
            throw new RuntimeException("邀请审稿邮件发送失败，发送邮件异步执行错误");
        long end = System.currentTimeMillis();
        logger.info("===== time ===== " + (end - start) + " ===== leyao =====");
        logger.info("===== 异步执行发送邮件完成 ===== leyao =====");

        /*
        更新paper_review_total表
         */
        PaperReviewTotal paperReviewTotal = new PaperReviewTotal();
        paperReviewTotal.setPaperId(paperId);
        paperReviewTotal.setContributorId(contributorId);
        paperReviewTotal.setDistributionStatus(distributionStatus);
        logger.info("===== paperReviewTotal ===== " + paperReviewTotal + " ===== leyao =====");
        paperDao.updatePaperReviewTotalStatus(paperReviewTotal);

        logger.info("===== end distribute paper ===== " + this.getClass().getName() + " ===== leyao =====");
        return ReturnUtil.returnUtil(200, true, "论文分配成功");
    }

    @Override
    @Transactional
    public JSONObject updateReviewerStatus(String paperId, String reviewerId, String status) {
        logger.info("===== start update reviewer status ===== " + this.getClass().getName() + " ===== leyao =====");
        long paperIdNum = Long.parseLong(paperId);
        long reviewerIdNum = Long.parseLong(reviewerId);
        PaperReview paperReview = new PaperReview();
        paperReview.setPaperId(paperIdNum);
        paperReview.setReviewerId(reviewerIdNum);
        paperReview.setStatus(status);
        logger.info("===== paperReview ===== " + paperReview + " ===== leyao =====");
        if (paperReview.getPaperId() == 0 || paperReview.getReviewerId() == 0 || paperReview.getStatus() == null)
            throw new RuntimeException("审稿人状态更新失败，请检查数据完整性");

        /*
        查询paper_review表，验证是否已经更新
         */
        PaperReview tmp = new PaperReview();
        tmp.setPaperId(paperIdNum);
        tmp.setReviewerId(reviewerIdNum);
        tmp = paperDao.getPaperReview(tmp);
        logger.info("===== tmp ===== " + tmp + " ===== leyao =====");
        if (tmp != null && !tmp.getStatus().equals("unconfirmed")) {
            throw new RuntimeException("审稿人状态更新失败，状态已更新，无法再次更新");
        }

        /*
        更新paper_review表
         */
        paperDao.updatePaperReviewStatus(paperReview);

        /*
        验证是否更新成功
         */
        PaperReview result = paperDao.getPaperReview(paperReview);
        logger.info("===== result ===== " + result + " ===== leyao =====");
        if (result == null) throw new RuntimeException("审稿人状态更新失败，数据未更新成功");
        logger.info("===== end update reviewer status ===== " + this.getClass().getName() + " ===== leyao =====");
        return ReturnUtil.returnUtil(200, true, "审稿人状态更新成功");
    }

    @Override
    @Transactional
    public JSONObject addReviewComments(ReviewComments reviewComments, HttpServletRequest request) {
        logger.info("===== start add review comments ===== " + this.getClass().getName() + " ===== leyao =====");

        /*
        获取当前登录状态下的user_id
         */
        long userId = CookieUtil.getUserId(request);
        reviewComments.setReviewerId(userId);
        logger.info("===== review comments ===== " + reviewComments + " ===== leyao =====");

        /*
        首先判断是否具备审稿资格
         */
        long reviewerId = reviewComments.getReviewerId();
        long paperId = reviewComments.getPaperId();
        PaperReview paperReview = new PaperReview();
        paperReview.setReviewerId(reviewerId);
        paperReview.setPaperId(paperId);
        paperReview.setStatus("confirmed");
        logger.info("===== paper review ===== " + paperReview + " ===== leyao =====");
        paperReview = paperDao.getPaperReview(paperReview);
        logger.info("===== paper review ===== " + paperReview + " ===== leyao =====");
        if (paperReview == null) throw new RuntimeException("审稿意见上传失败，请确定是否具有审稿资格");

        /*
        判断是否已经存在审稿意见
         */
        if (paperDao.getReviewComments(reviewComments) != null)
            throw new RuntimeException("审稿意见上传失败，请勿重复上传");

        /*
        添加审稿意见
         */
        paperDao.addReviewComments(reviewComments);

        /*
        修改该审稿人审稿状态为reviewed
         */
        if (reviewerId == 0 || paperId == 0)
            throw new RuntimeException("审稿意见上传失败，请确定数据完整性");
        paperReview = new PaperReview();
        paperReview.setReviewerId(reviewerId);
        paperReview.setPaperId(paperId);
        paperReview.setStatus("reviewed");
        logger.info("===== paper review ===== " + paperReview + " ===== leyao =====");
        paperDao.updatePaperReviewStatus(paperReview);

        /*
        验证是否修改成功
         */
        PaperReview tmp = paperDao.getPaperReview(paperReview);
        if (tmp == null)
            throw new RuntimeException("审稿意见上传失败，审稿人审稿状态更新异常");
        logger.info("===== end add review comments ===== " + this.getClass().getName() + " ===== leyao =====");
        return ReturnUtil.returnUtil(200, true, "审稿意见上传成功");
    }

    @Override
    public JSONObject getPaperReviewList(HttpServletRequest request) {
        logger.info("===== start get paper review list ===== " + this.getClass().getName() + " ===== leyao =====");
        /*
        获取当前登录状态下的user_id
         */
        long userId = CookieUtil.getUserId(request);
        logger.info("===== userId ===== " + userId + " ===== leyao =====");

        List<PaperReviewList> paperReviewList = paperDao.getPaperReviewList(userId);
        logger.info("===== paper review list ===== " + paperReviewList + " ===== leyao =====");

        logger.info("===== end get paper review list ===== " + this.getClass().getName() + " ===== leyao =====");
        return ReturnUtil.returnUtil(200, true, "审稿论文列表查询成功", paperReviewList);
    }

    @Override
    public JSONObject getReviewerList(PaperReview paperReview) {
        logger.info("===== start get paper reviewer list ===== " + this.getClass().getName() + " ===== leyao =====");
        if (paperReview == null || paperReview.getPaperId() == 0) return ReturnUtil.returnUtil(200, false, "获取审稿人列表失败，请确认数据完整性");
        logger.info("===== paper review ===== " + paperReview + " ===== leyao =====");
        /*
        获取审稿人列表
         */
        List<HashMap<String, Object>> reviewerList = paperDao.getReviewerList(paperReview);
        logger.info("===== reviewer list ===== " + reviewerList + " ===== leyao =====");
        logger.info("===== end get paper reviewer list ===== " + this.getClass().getName() + " ===== leyao =====");
        return ReturnUtil.returnUtil(200, true, "获取审稿人列表成功", reviewerList);
    }

    @Override
    public JSONObject getReviewComments(ReviewComments reviewComments) {
        logger.info("===== start get review comments ===== " + this.getClass().getName() + " ===== leyao =====");
        logger.info("===== review comments ===== " + reviewComments + " ===== leyao =====");
        if (reviewComments == null || reviewComments.getPaperId() == 0 || reviewComments.getReviewerId() == 0)
            return ReturnUtil.returnUtil(200, false, "获取审稿意见失败，请确认数据完整性");

        /*
        获取审稿意见
         */
        reviewComments = paperDao.getReviewComments(reviewComments);
        logger.info("===== review comments ===== " + reviewComments + " ===== leyao =====");
        logger.info("===== end get review comments ===== " + this.getClass().getName() + " ===== leyao =====");
        return ReturnUtil.returnUtil(200, true, "获取审稿意见成功", reviewComments);
    }

    @Override
    @Transactional
    public JSONObject updateReviewCommentsStatus(ReviewComments reviewComments) {
        logger.info("===== start update review comments status ===== " + this.getClass().getName() + " ===== leyao =====");
        logger.info("===== review comments ===== " + reviewComments + " ===== leyao =====");
        if (reviewComments == null || reviewComments.getPaperId() == 0 || reviewComments.getReviewerId() == 0 || reviewComments.getStatus() == 0)
            throw new RuntimeException("更新审稿意见采纳状态失败，请确认数据完整性");

        /*
        查询是否存在该条记录
         */
        ReviewComments tmp = new ReviewComments();
        tmp.setReviewerId(reviewComments.getReviewerId());
        tmp.setPaperId(reviewComments.getPaperId());
        logger.info("===== tmp ===== " + tmp + " ===== leyao =====");
        tmp = paperDao.getReviewComments(tmp);
        logger.info("===== tmp ===== " + tmp + " ===== leyao =====");
        if (tmp == null)
            throw new RuntimeException("更新审稿意见采纳状态失败，请确认是否存在该条审稿记录");

        /*
        更新状态
         */
        paperDao.updateReviewCommentsStatus(reviewComments);

        /*
        检查是否更新成功
         */
        tmp = paperDao.getReviewComments(reviewComments);
        if (tmp == null)
            throw new RuntimeException("更新审稿意见采纳状态失败，字段未更新成功");
        logger.info("===== end update review comments status ===== " + this.getClass().getName() + " ===== leyao =====");
        return ReturnUtil.returnUtil(200, true, "更新审稿意见采纳状态成功");
    }

    @Override
    public JSONObject getReviewCommentsList(ReviewComments reviewComments) {
        logger.info("===== start get review comments list ===== " + this.getClass().getName() + " ===== leyao =====");
        logger.info("===== review comments ===== " + reviewComments + " ===== leyao =====");
        if (reviewComments == null || reviewComments.getPaperId() == 0)
            return ReturnUtil.returnUtil(200, false, "获取审稿意见列表失败，请检查数据完整性");

        /*
        获取审稿意见列表
         */
        List<ReviewComments> reviewCommentsList = paperDao.getReviewCommentsList(reviewComments);
        logger.info("===== review comments list ===== " + reviewCommentsList + " ===== leyao =====");
        logger.info("===== end get review comments list ===== " + this.getClass().getName() + " ===== leyao =====");
        return ReturnUtil.returnUtil(200, true, "获取审稿意见列表成功");
    }

    @Override
    @Transactional
    public JSONObject updatePaperSubmissionResult(PaperSubmission paperSubmission) {
        logger.info("===== start update paper submission result ===== " + this.getClass().getName() + " ===== leyao =====");
        logger.info("===== paper submission ===== " + paperSubmission + " ===== leyao =====");
        if (paperSubmission == null || paperSubmission.getId() == 0 || paperSubmission.getResult() == 0)
            throw new RuntimeException("论文投稿结果更新失败，请检查数据完整性");

        /*
        验证是否存在该投稿论文
         */
        PaperSubmission tmp = new PaperSubmission();
        tmp.setId(paperSubmission.getId());
        logger.info("===== tmp ===== " + tmp + " ===== leyao =====");
        tmp = paperDao.getPaperSubmission(tmp);
        logger.info("===== tmp ===== " + tmp + " ===== leyao =====");
        if (tmp == null)
            throw new RuntimeException("论文投稿结果更新失败，该论文信息不存在");

        /*
        更新论文投稿结果
         */
        paperDao.updatePaperSubmission(paperSubmission);

        /*
        验证是否更新成功
         */
        tmp = paperDao.getPaperSubmission(paperSubmission);
        logger.info("===== tmp ===== " + tmp + " ===== leyao =====");
        if (tmp == null)
            throw new RuntimeException("论文投稿结果更新失败，状态字段未成功更新");

        /*
        为投稿人发送邮件通知
         */
        /*
        首先查询投稿人信息，获取邮箱及用户名
         */
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(tmp.getUserId());
        logger.info("===== userInfo ===== " + userInfo + " ===== leyao =====");
        userInfo = userInfoDao.getUserInfo(userInfo);
        logger.info("===== userInfo ===== " + userInfo + " ===== leyao =====");
        String email = userInfo.getEmail();
        String username = userInfo.getUsername();

        /*
        然后获取采纳的投稿意见列表
         */
        ReviewComments reviewComments = new ReviewComments();
        reviewComments.setPaperId(paperSubmission.getId());
        reviewComments.setStatus(2);
        logger.info("===== review comments ===== " + reviewComments + " ===== leyao =====");
        List<ReviewComments> reviewCommentsList = paperDao.getReviewCommentsList(reviewComments);
        logger.info("===== review comments list ===== " + reviewCommentsList + " ===== leyao =====");
        if (reviewCommentsList == null)
            throw new RuntimeException("更新论文投稿结果失败，获取投稿意见列表数据为空");
        if (reviewCommentsList.size() != 3)
            throw new RuntimeException("更新论文投稿结果失败，请确保采纳的审稿意见数量为3");

        String comment1 = reviewCommentsList.get(0).getComment();
        logger.info("===== comment1 ===== " + comment1 + " ===== leyao =====");
        String comment2 = reviewCommentsList.get(1).getComment();
        logger.info("===== comment2 ===== " + comment2 + " ===== leyao =====");
        String comment3 = reviewCommentsList.get(2).getComment();
        logger.info("===== comment3 ===== " + comment3 + " ===== leyao =====");

        /*
        设置投稿结果
         */
        int num = paperSubmission.getResult();
        String submissionResult = "";
        if (num == 1) submissionResult = "予以录用";
        if (num == 2) submissionResult = "不予录用";
        if (submissionResult.equals(""))
            throw new RuntimeException("更新论文投稿结果失败，请确认投稿结果是否确定");

        /*
        设置时间
         */
        String date = sdfDate.format(new Date());

        /*
        发送邮件
         */
        Email emailObj = new Email();
        emailObj.setReciever(email);
        emailObj.setSubject("Submission Result");
        emailObj.setTemplate("submissionResult");


        HashMap<String, String> map = new HashMap<>();
        map.put("date", date);
        map.put("username", username);
        map.put("submissionResult", submissionResult);
        map.put("comment1", comment1);
        map.put("comment2", comment2);
        map.put("comment3", comment3);
        emailObj.setMailMap(map);
        try {
            mailUtil.sendTemplateMail(emailObj);
        }
        catch (Exception e) {
            throw new RuntimeException("发送结果邮件发送失败");
        }
        logger.info("===== end update paper submission result ===== " + this.getClass().getName() + " ===== leyao =====");
        return ReturnUtil.returnUtil(200, true, "更新论文投稿结果成功");
    }

    // @Override
    // @Transactional
    // public JSONObject cachePaperData(long userId, String type, String title, String summary, String keywords) {
    //     logger.info("===== start paper data cache ===== " + this.getClass().getName() + " ===== leyao =====");
    //     if (userId == 0L || type == null || title == null || summary == null || keywords == null)
    //         return ReturnUtil.returnUtil(200, false, "请求参数出现null值，请重新确定请求参数合法性");
    //     String key = userId + ":" + title;
    //     String userIdStr = userId + "";
    //     redisService.hashPut(key, "userId", userIdStr);
    //     redisService.hashPut(key, "type", type);
    //     redisService.hashPut(key, "title", title);
    //     redisService.hashPut(key, "summary", summary);
    //     redisService.hashPut(key, "keywords", keywords);
    //     if (!redisTemplate.hasKey(key)) return ReturnUtil.returnUtil(200, false, "数据存入redis异常，请重新缓存");
    //     logger.info("===== cache data ===== " + redisService.hashGetAll(key) + " ===== leyao =====");
    //     logger.info("===== end paper data cache ===== " + this.getClass().getName() + " ===== leyao =====");
    //     return ReturnUtil.returnUtil(200, true, "缓存成功");
    // }
    @Override
    public void downloadPaperTemplate(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        logger.info("===== start download paper template ===== " + this.getClass().getName() + " ===== leyao =====");
        FileUtil.downloadTemplate(request, response, templatePath, templateFileName);
        logger.info("===== end download paper template ===== " + this.getClass().getName() + " ===== leyao =====");
    }
}
