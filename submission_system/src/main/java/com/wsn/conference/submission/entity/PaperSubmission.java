package com.wsn.conference.submission.entity;

/**
 * @author leyao
 * @version 2018-7-15
 */
public class PaperSubmission {
    private long id;
    private long userId;
    private String contributor;
    private String type;
    private String subType;
    private String title;
    private String summary;
    private String keywords;
    private String fileName;
    private String path;
    private String watermarkPath;
    private String status;
    private int result;
    private String createTime;
    private String updateTime;

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

    public void setContributor(String contributor) {
        this.contributor = contributor;
    }

    public String getContributor() {
        return contributor;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getSubType() {
        return subType;
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

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setWatermarkPath(String watermarkPath) {
        this.watermarkPath = watermarkPath;
    }

    public String getWatermarkPath() {
        return watermarkPath;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
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
                "userId: " + userId + ", " +
                "contributor: " + contributor + ", " +
                "type: " + type + ", " +
                "subType: " + subType + ", " +
                "title: " + title + ", " +
                "summary: " + summary + ", " +
                "keywords: " + keywords + ", " +
                "fileName: " + fileName + ", " +
                "path: " + path + ", " +
                "watermarkPath: " + watermarkPath + ", " +
                "status: " + status + ", " +
                "result: " + result + ", " +
                "createTime: " + createTime + ", " +
                "updateTime: " + updateTime;
    }
}
