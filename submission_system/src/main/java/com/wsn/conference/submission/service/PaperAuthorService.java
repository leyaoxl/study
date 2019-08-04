package com.wsn.conference.submission.service;

import com.alibaba.fastjson.JSONObject;
import com.wsn.conference.submission.entity.PaperAuthor;

/**
 * @author leyao
 * @version 2019-1-21
 */
public interface PaperAuthorService {
    JSONObject addPaperAuthor(PaperAuthor paperAuthor);

    JSONObject getPaperAuthorList(long paperId);

    JSONObject updatePaperAuthor(PaperAuthor paperAuthor);

    JSONObject deletePaperAuthor(long id);
}
