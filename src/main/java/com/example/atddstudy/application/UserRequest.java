package com.example.atddstudy.application;

import lombok.Getter;

@Getter
public class UserRequest {
    private String loginId;
    private String name;
    private String password;

    public UserRequest(String loginId, String name, String password) {
        this.loginId = loginId;
        this.name = name;
        this.password = password;
    }

    public static UserRequest of(String loginId, String name, String password) {
        return new UserRequest(loginId, name, password);
    }
}
