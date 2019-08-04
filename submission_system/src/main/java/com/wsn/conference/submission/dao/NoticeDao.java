package com.wsn.conference.submission.dao;

import com.wsn.conference.submission.entity.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author leyao
 * @version 2018-8-28
 */
@Mapper
public interface NoticeDao {
    void addNotice(Notice notice);

    Notice getNotice(Notice notice);

    List<Notice> getNoticeList(Notice notice);

    void updateNoticeStatus(Notice notice);

    Integer getNoticeNum(Notice notice);
}
