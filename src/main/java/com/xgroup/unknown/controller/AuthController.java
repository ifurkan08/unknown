package com.xgroup.unknown.controller;

import com.xgroup.unknown.auth.TokenManager;
import com.xgroup.unknown.model.entities.User;
import com.xgroup.unknown.model.requests.LoginRequest;
import com.xgroup.unknown.model.requests.SignUpRequest;
import com.xgroup.unknown.services.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenManager tokenManager;

    @Autowired
    private IUserService userService;

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest){
        try {
            authenticationManager.
                    authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUserName(),loginRequest.getPassword()));
            return ResponseEntity.ok(tokenManager.generateToken(loginRequest.getUserName()));
        }catch (Exception e){
            throw e;
        }
    }
    @PostMapping("signup")
    public ResponseEntity<String> signup(@RequestBody SignUpRequest signUpRequest){
        userService.addUser(signUpRequest);
        return ResponseEntity.ok().body(null);
    }


}
