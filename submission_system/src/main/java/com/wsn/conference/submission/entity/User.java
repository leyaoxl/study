package com.wsn.conference.submission.entity;

public class User {
    private long id;
    private String account;
    private String password;
    private String createTime;
    private String updateTime;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccount() {
        return account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
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
                "account: " + account + ", " +
                "password: " + password + ", " +
                "createTime: " + createTime + ", " +
                "updateTime: " + updateTime;
    }
}
