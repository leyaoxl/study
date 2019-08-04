package com.wsn.conference.submission.entity;

/**
 * @author leyao
 * @version 2018-7-12
 */
public class UserInfo {
    private long id;
    private long userId;
    private String prefix;
    private String username;
    private String degree;
    private String email;
    private String country;
    private String city;
    private String school;
    private String address;
    private String postalCode;
    private String phone;
    private String role;
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

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getDegree() {
        return degree;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSchool() {
        return school;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
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
        return "prefix: " + prefix + ", " +
                "username: " + username + ", " +
                "degree: " + degree + ", " +
                "email: " + email + ", " +
                "country: " + country + ", " +
                "city: " + city + ", " +
                "address: " + address + ", " +
                "postal code: " + postalCode + ", " +
                "phone: " + phone + ", " +
                "role: " + role + ", " +
                "createTime: " + createTime + ", " +
                "updateTime: " + updateTime;
    }
}
