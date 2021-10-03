package com.xgroup.unknown.services.impl;

import com.xgroup.unknown.auth.UserDetailsService;
import com.xgroup.unknown.model.entities.Auth.UserEntity;
import com.xgroup.unknown.model.requests.auth.SignUpRequest;
import com.xgroup.unknown.repositories.UserRepository;
import com.xgroup.unknown.services.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity addUser(SignUpRequest signUpRequest) {
        UserEntity user = signUpRequest.convertToEntity(signUpRequest,new UserEntity());
        user=userRepository.save(user);
        return user ;
    }

    @Override
    public List<UserEntity> getAllActiveUsers() {

       Stream<UserEntity> userEntityStream =  userRepository.findAll().stream().
                filter(p -> p.getActive().equals("E"));
       List<UserEntity> userList=userEntityStream
               .collect(Collectors.toList());
        return  userList;
    }


}
