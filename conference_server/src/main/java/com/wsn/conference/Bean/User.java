package com.wsn.conference.Bean;

import java.util.Date;

public class User {
    private long id;
    private String username;
    private String password;
    private String telephone;
    private String email;
    private int payState;
    private Date createTime;
    private Date updateTime;

    public User(){
        super();
    }
    public User(String username,String password){
        super();
        this.username=username;
        this.password=password;
    }
    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPayState(int payState) {
        this.payState = payState;
    }

    public int getPayState() {
        return payState;
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
