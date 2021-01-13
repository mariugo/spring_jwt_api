package com.mariugo.spring_jwt_api.controller;

import com.mariugo.spring_jwt_api.dto.RegisterRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/signup")
    public void signUp(@RequestBody RegisterRequest registerRequest){

    }
}
