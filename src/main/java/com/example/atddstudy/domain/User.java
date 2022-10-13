package com.example.atddstudy.domain;

import lombok.Getter;

@Getter
public class User {
    private Long id;
    private String loginId;
    private String name;
    private String password;

    public User(String loginId, String name, String password) {
        this.loginId = loginId;
        this.name = name;
        this.password = password;
    }

    public void assignId(Long nextId) {
        this.id = nextId;
    }
}
