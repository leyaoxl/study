package com.wsn.conference.submission.entity;

public class PaperAuthor {
    private long id;
    private long paperId;
    private long userId;
    private int orderNum;
    private String correspondingAuthorStatus;
    private String status;
    private String username;
    private String email;
    private String country;
    private String city;
    private String createTime;
    private String updateTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPaperId() {
        return paperId;
    }

    public void setPaperId(long paperId) {
        this.paperId = paperId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public String getCorrespondingAuthorStatus() {
        return correspondingAuthorStatus;
    }

    public void setCorrespondingAuthorStatus(String correspondingAuthorStatus) {
        this.correspondingAuthorStatus = correspondingAuthorStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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
        return "id: " + id + ", " +
                "paperId: " + paperId + ", " +
                "userId: " + userId + ", " +
                "orderNum: " + orderNum + ", " +
                "correspondingAuthorStatus: " + correspondingAuthorStatus + ", " +
                "status: " + status + ", " +
                "username: " + username + ", " +
                "email: " + email + ", " +
                "country: " + country + ", " +
                "city: " + city + ", " +
                "createTime: " + createTime + ", " +
                "updateTime: " + updateTime;
    }
}
