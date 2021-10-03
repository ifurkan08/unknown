package com.xgroup.unknown.model.requests.auth;

import com.xgroup.unknown.model.base.RequestBase;
import com.xgroup.unknown.model.entities.Auth.UserEntity;

public class LoginRequest  extends RequestBase<LoginRequest, UserEntity> {
    private String userName;
    private String password;

    public LoginRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public LoginRequest() {
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
}
