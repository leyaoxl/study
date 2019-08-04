package com.wsn.conference.submission.entity;

public class PaperReviewTotal {
    private long id;
    private long paperId;
    private long contributorId;
    private int distributionStatus;
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

    public void setDistributionStatus(int distributionStatus) {
        this.distributionStatus = distributionStatus;
    }

    public int getDistributionStatus() {
        return distributionStatus;
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
                "distributionStatus: " + distributionStatus + ", " +
                "createTime: " + createTime + ", " +
                "updateTime: " + updateTime;
    }
}
