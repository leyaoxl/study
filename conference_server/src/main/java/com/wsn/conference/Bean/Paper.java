package com.wsn.conference.Bean;

import java.util.Date;

public class Paper {
    private long id;
    private long userId;
    private String title;
    private String summary;
    private String keyWords;
    private String filePath;
    private String readerId;
    private Date createTime;
    private Date updateTime;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getUserId() {
        return userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSummary() {
        return summary;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setReaderId(String readerId) {
        this.readerId = readerId;
    }

    public String getReaderId() {
        return readerId;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }
}
