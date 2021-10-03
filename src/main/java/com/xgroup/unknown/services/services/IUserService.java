package com.xgroup.unknown.services.services;

import com.xgroup.unknown.model.entities.Auth.UserEntity;
import com.xgroup.unknown.model.requests.auth.SignUpRequest;

import java.util.List;

public interface IUserService {
    UserEntity addUser(SignUpRequest signUpRequest);
    List<UserEntity> getAllActiveUsers ();
}
