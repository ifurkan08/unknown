package com.xgroup.unknown.auth;

import com.xgroup.unknown.model.entities.Auth.UserEntity;
import com.xgroup.unknown.services.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private Map<String, String> users = new HashMap<>();

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private IUserService userService;

    @PostConstruct
    public void init() {

        List<UserEntity> userList= userService.getAllActiveUsers();
        for (UserEntity user: userList) {
            String encodedPw=passwordEncoder.encode(user.getPassword());
            users.put(user.getUserName(),encodedPw);
        }
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (users.containsKey(username)) {
            return new User(username, users.get(username), new ArrayList<>());
        }

        throw new UsernameNotFoundException(username);
    }
}