package com.wsn.conference.submission.service.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import com.wsn.conference.submission.dao.NoticeDao;
import com.wsn.conference.submission.entity.Notice;
import com.wsn.conference.submission.service.NoticeService;
import com.wsn.conference.submission.util.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author leyao
 * @version 2018-8-28
 */
@Service
public class NoticeServiceImpl implements NoticeService {
    private Logger logger = Logger.getLogger(NoticeServiceImpl.class.getName());

    @Autowired
    private NoticeDao noticeDao;

    @Override
    @Transactional
    public JSONObject addNotice(Notice notice) {
        logger.info("===== start add notice ===== " + this.getClass().getName() + " ===== leyao =====");

        /*
        首先验证是否存在相同通知
         */
        logger.info("===== notice ===== " + notice + " ===== leyao =====");
        int noticeNum = noticeDao.getNoticeNum(notice);
        logger.info("===== noticeNum ===== " + noticeNum + " ===== leyao =====");
        if (noticeNum != 0) throw new RuntimeException("添加通知失败，请勿重复添加");

        /*
        添加通知
         */
        logger.info("===== add notice by NoticeDao =====");
        logger.info("===== notice ===== " + notice + " ===== leyao =====");
        noticeDao.addNotice(notice);

        /*
        验证是否添加成功
         */
        Notice tmp = noticeDao.getNotice(notice);
        if (tmp == null) throw new RuntimeException("添加通知失败，数据未写入数据库");

        logger.info("===== end add notice ===== " + this.getClass().getName() + " ===== leyao =====");
        return ReturnUtil.returnUtil(200, true, "通知添加成功");
    }

    @Override
    public JSONObject getNoticeList(Notice notice) {
        logger.info("===== start get notice list ===== " + this.getClass().getName() + " ===== leyao =====");
        List<Notice> noticeList = noticeDao.getNoticeList(notice);
        logger.info("===== noticeList ===== " + noticeList + " ===== leyao =====");
        logger.info("===== end get notice list ===== " + this.getClass().getName() + " ===== leyao =====");
        return ReturnUtil.returnUtil(200, true, "获取通知列表成功", noticeList);
    }

    @Override
    @Transactional
    public JSONObject updateNoticeStatus(Notice notice) {
        logger.info("===== start update notice status ===== " + this.getClass().getName() + " ===== leyao =====");

        /*
        验证非null
         */
        if (notice.getStatus() == null || StringUtils.isEmpty(notice.getStatus()) || notice.getId() == 0) {
            throw new RuntimeException("更新状态失败，请确定请求参数是否完整");
        }

        noticeDao.updateNoticeStatus(notice);

        /*
        验证是否更新成功
         */
        Notice tmp = noticeDao.getNotice(notice);
        if (tmp == null) throw new RuntimeException("更新状态失败，数据未更新");

        logger.info("===== end update notice status ===== " + this.getClass().getName() + " ===== leyao =====");
        return ReturnUtil.returnUtil(200, true, "更新状态成功");
    }
}
