package com.example.SpringbootApi.controller;

import com.example.SpringbootApi.config.UserInfoUserDetails;
import com.example.SpringbootApi.entity.UserInfo;
import com.example.SpringbootApi.serviceImpl.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/new")
    public String addNewUser(@RequestBody UserInfo userInfo) {
        System.out.println(userInfo);
        return signUpService.addUser(userInfo);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserInfo userInfo) {
        return ResponseEntity.ok("ok");
    }

}
