package com.wsn.conference.submission.service;

import com.alibaba.fastjson.JSONObject;
import com.wsn.conference.submission.entity.Notice;

/**
 * @author leyao
 * @version 2018-8-28
 */
public interface NoticeService {
    JSONObject addNotice(Notice notice);

    JSONObject getNoticeList(Notice notice);

    JSONObject updateNoticeStatus(Notice notice);
}
