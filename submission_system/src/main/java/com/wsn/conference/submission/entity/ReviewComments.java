package com.wsn.conference.submission.entity;

public class ReviewComments {
    private long id;
    private long reviewerId;
    private long paperId;
    private int status;
    private int item1;
    private int item2;
    private int item3;
    private int item4;
    private int item5;
    private String comment;
    private String createTime;
    private String updateTime;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setReviewerId(long reviewerId) {
        this.reviewerId = reviewerId;
    }

    public long getReviewerId() {
        return reviewerId;
    }

    public void setPaperId(long paperId) {
        this.paperId = paperId;
    }

    public long getPaperId() {
        return paperId;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setItem1(int item1) {
        this.item1 = item1;
    }

    public int getItem1() {
        return item1;
    }

    public void setItem2(int item2) {
        this.item2 = item2;
    }

    public int getItem2() {
        return item2;
    }

    public void setItem3(int item3) {
        this.item3 = item3;
    }

    public int getItem3() {
        return item3;
    }

    public void setItem4(int item4) {
        this.item4 = item4;
    }

    public int getItem4() {
        return item4;
    }

    public void setItem5(int item5) {
        this.item5 = item5;
    }

    public int getItem5() {
        return item5;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
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
                "reviewerId: " + reviewerId + ", " +
                "paperId: " + paperId + ", " +
                "status: " + status + ", " +
                "item1: " + item1 + ", " +
                "item2: " + item2 + ", " +
                "item3: " + item3 + ", " +
                "item4: " + item4 + ", " +
                "item5: " + item5 + ", " +
                "comment: " + comment + ", " +
                "createTime: " + createTime + ", " +
                "updateTime: " + updateTime;
    }
}
