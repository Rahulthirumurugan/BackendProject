package com.example.SpringbootApi.serviceImpl;

import com.example.SpringbootApi.entity.UserInfo;
import com.example.SpringbootApi.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {

    @Autowired
    private UserInfoRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    public String addUser(UserInfo userInfo){
        userInfo.setPassword(encoder.encode(userInfo.getPassword()));
        userInfo.setConfirmpassword(encoder.encode(userInfo.getConfirmpassword()));
        repository.save(userInfo);
        return "User added to the system";
    }
}


