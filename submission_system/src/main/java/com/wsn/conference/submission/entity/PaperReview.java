package com.wsn.conference.submission.entity;

/**
 * @author leyao
 * @version 2018-7-13
 */
public class PaperReview {
    private long id;
    private long paperId;
    private long contributorId;
    private long reviewerId;
    private String status;
    private String createTime;
    private String updateTime;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

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

    public void setReviewerId(long reviewerId) {
        this.reviewerId = reviewerId;
    }

    public long getReviewerId() {
        return reviewerId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    @Override
    public String toString() {
        return "id: " + id + ", " +
                "paperId: " + paperId + ", " +
                "contributorId: " + contributorId + ", " +
                "reviewerId: " + reviewerId + ", " +
                "status: " + status + ", " +
                "createTime: " + createTime + ", " +
                "updateTime: " + updateTime;
    }
}
