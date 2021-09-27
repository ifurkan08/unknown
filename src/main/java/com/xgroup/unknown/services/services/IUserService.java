package com.xgroup.unknown.services.services;

import com.xgroup.unknown.model.entities.User;
import com.xgroup.unknown.model.requests.SignUpRequest;

public interface IUserService {
    User addUser(SignUpRequest signUpRequest);
}
