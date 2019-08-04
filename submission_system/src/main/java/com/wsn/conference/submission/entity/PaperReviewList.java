package com.wsn.conference.submission.entity;

public class PaperReviewList {
    private long paperId; // 投稿文章id
    private long contributorId; // 投稿人id
    private String title; // 文章标题
    private String submissionTime; // 投稿时间
    private String status; // 审稿状态
    private String reviewTime; // 审稿时间

    public void setPaperId(long paperId) {
        this.paperId = paperId;
    }

    public long getPaperId() {
        return paperId;
    }

    public void setContributorId(long contributorId) {
        this.contributorId = contributorId;
    }

    public long getContributorId() {
        return contributorId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setSubmissionTime(String submissionTime) {
        this.submissionTime = submissionTime;
    }

    public String getSubmissionTime() {
        return submissionTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setReviewTime(String reviewTime) {
        this.reviewTime = reviewTime;
    }

    public String getReviewTime() {
        return reviewTime;
    }

    @Override
    public String toString() {
        return "paperId: " + paperId + ", " +
                "contributorId: " + contributorId + ", " +
                "title: " + title + ", " +
                "submissionTime: " + submissionTime + ", " +
                "status: " + status + ", " +
                "reviewTime: " + reviewTime;
    }
}
