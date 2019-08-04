package com.wsn.conference.submission.entity;

/**
 * @author leyao
 * @version 2018-8-28
 */
public class Notice {
    private long id;
    private String status;
    private String subject;
    private String content;
    private String createTime;
    private String updateTime;

    public Notice(long id, String status, String subject, String content, String createTime, String updateTime) {
        this.id = id;
        this.status = status;
        this.subject = subject;
        this.content = content;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Notice() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "id: " + id + ", "
                + "status: " + status + ", "
                + "subject: " + subject + ", "
                + "content: " + content + ", "
                + "createTime: " + createTime + ", "
                + "updateTime: " + updateTime;
    }
}
