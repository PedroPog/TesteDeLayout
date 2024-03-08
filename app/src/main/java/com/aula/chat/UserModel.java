package com.aula.chat;

public class UserModel {
    String userId;
    String userName;
    String userEmail;
    String usersenha;

    public UserModel(String userId, String userName, String userEmail, String usersenha) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.usersenha = usersenha;
    }

    public UserModel() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUsersenha() {
        return usersenha;
    }

    public void setUsersenha(String usersenha) {
        this.usersenha = usersenha;
    }


}
