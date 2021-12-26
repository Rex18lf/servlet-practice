package com.pluto.entities;

public class Users {
    private Integer userId;
    private String userName;
    private String password;
    private String gender;
    private String email;

    public Users() {
    }

    public Users(Integer userId, String userName, String password, String gender, String email) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.gender = gender;
        this.email = email;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
