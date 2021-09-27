package com.xgroup.unknown.services.impl;

import com.xgroup.unknown.model.entities.User;
import com.xgroup.unknown.model.requests.SignUpRequest;
import com.xgroup.unknown.repositories.UserRepository;
import com.xgroup.unknown.services.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(SignUpRequest signUpRequest) {
        User user = signUpRequest.convertToEntity(signUpRequest,new User());
       return  userRepository.save(user);
    }
}
