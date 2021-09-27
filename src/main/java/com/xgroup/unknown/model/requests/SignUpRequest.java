package com.xgroup.unknown.model.requests;

import com.xgroup.unknown.model.base.RequestBase;
import com.xgroup.unknown.model.entities.User;

public class SignUpRequest extends RequestBase <SignUpRequest, User> {
    private String userName;
    private String password;
    private String mail;

    public SignUpRequest() {
    }

    public SignUpRequest(String userName, String password, String mail) {
        this.userName = userName;
        this.password = password;
        this.mail = mail;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
