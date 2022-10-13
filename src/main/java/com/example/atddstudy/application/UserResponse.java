package com.example.atddstudy.application;

import com.example.atddstudy.domain.User;
import lombok.Getter;

@Getter
public class UserResponse {
    private Long id;
    private String loginId;
    private String name;
    private String password;

    public UserResponse(String loginId, String name, String password) {
        this.loginId = loginId;
        this.name = name;
        this.password = password;
    }

    public UserResponse(User user) {
        this.id = user.getId();
        this.loginId = user.getLoginId();
        this.name = user.getName();
        this.password = user.getPassword();
    }
}
