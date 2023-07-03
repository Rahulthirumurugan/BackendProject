package com.example.SpringbootApi.repository;

import com.example.SpringbootApi.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo,String> {
    Optional<UserInfo> findByUsername(String username);
}
