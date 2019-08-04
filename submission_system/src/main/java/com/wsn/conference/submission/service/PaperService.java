package com.wsn.conference.submission.service;

import com.alibaba.fastjson.JSONObject;
import com.wsn.conference.submission.entity.PaperReview;
import com.wsn.conference.submission.entity.PaperSubmission;
import com.wsn.conference.submission.entity.ReviewComments;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author leyao
 * @version 2018-7-13
 */
public interface PaperService {
    JSONObject uploadPaper(MultipartFile file, HttpServletRequest request) throws UnsupportedEncodingException, IOException;

    JSONObject uploadPaperData(PaperSubmission paperSubmission, HttpServletRequest request);

    JSONObject getPaperSubmissionList(String status, String type, HttpServletRequest request);

    JSONObject deletePaper(HttpServletRequest request, String id) throws Exception;

    void downloadPaper(HttpServletRequest request, HttpServletResponse response, long id) throws UnsupportedEncodingException;

    JSONObject getPaperData(PaperSubmission paperSubmission, HttpServletRequest request);

    JSONObject distributePaper(List<PaperReview> paperReviewList);

    JSONObject updateReviewerStatus(String paperId, String reviewerId, String status);

    JSONObject addReviewComments(ReviewComments reviewComments, HttpServletRequest request);

    JSONObject getPaperReviewList(HttpServletRequest request);

    JSONObject getReviewerList(PaperReview paperReview);

    JSONObject getReviewComments(ReviewComments reviewComments);

    JSONObject updateReviewCommentsStatus(ReviewComments reviewComments);

    JSONObject getReviewCommentsList(ReviewComments reviewComments);

    JSONObject updatePaperSubmissionResult(PaperSubmission paperSubmission);

    // JSONObject cachePaperData(long id, String type, String title, String summary, String keywords);

    void downloadPaperTemplate(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException;
}
