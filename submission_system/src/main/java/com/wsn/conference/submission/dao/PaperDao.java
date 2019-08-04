package com.wsn.conference.submission.dao;

import com.wsn.conference.submission.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @author leyao
 * @version 2018-7-13
 */
@Mapper
public interface PaperDao {
    void addPaperSubmission(PaperSubmission paperSubmission);

    void updatePaperSubmission(PaperSubmission paperSubmission);

    PaperSubmission getPaperSubmission(PaperSubmission paperSubmission);

    List<HashMap<String, Object>> getPaperSubmissionList(HashMap<String, Object> hashMap);

    void deletePaperSubmission(@Param("paperId") long paperId, @Param("userId") long userId);

    void addPaperReview(PaperReview paperReview);

    PaperReview getPaperReview(PaperReview paperReview);

    void addReviewComments(ReviewComments reviewComments);

    ReviewComments getReviewComments(ReviewComments reviewComments);

    List<PaperReviewList> getPaperReviewList(@Param("userId") long userId);

    void addPaperReviewTotal(PaperReviewTotal paperReviewTotal);

    PaperReviewTotal getPaperReviewTotal(PaperReviewTotal paperReviewTotal);

    void updatePaperReviewTotalStatus(PaperReviewTotal paperReviewTotal);

    void updatePaperReviewStatus(PaperReview paperReview);

    List<HashMap<String, Object>> getReviewerList(PaperReview paperReview);

    void updateReviewCommentsStatus(ReviewComments reviewComments);

    List<ReviewComments> getReviewCommentsList(ReviewComments reviewComments);
}
