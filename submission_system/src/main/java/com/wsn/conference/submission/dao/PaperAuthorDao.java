package com.wsn.conference.submission.dao;

import com.wsn.conference.submission.entity.PaperAuthor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author leyao
 * @version 2019-1-21
 */
@Mapper
public interface PaperAuthorDao {
    void addPaperAuthor(PaperAuthor paperAuthor);

    PaperAuthor getPaperAuthor(PaperAuthor paperAuthor);

    List<PaperAuthor> getPaperAuthorList(long paperId);

    void updatePaperAuthor(PaperAuthor paperAuthor);
}
