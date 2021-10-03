package com.xgroup.unknown.model.entities.Auth;

import com.xgroup.unknown.model.entities.IEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class UserEntity implements Serializable , IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "user_name")
    private String userName;

    @Column(nullable = false, name = "password")
    private String password;

    @Column(nullable = false, name = "mail")
    private String mail;

    @Column(nullable = false, name = "active")
    private String active;

    @PrePersist
    void prePersist() {
        if (this.active==null){
            this.active="E";
        }
    }
    public UserEntity() {
    }

    public UserEntity(Long id, String userName, String password, String active) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.active=active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
