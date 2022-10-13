package com.example.atddstudy.application;

import com.example.atddstudy.domain.User;

public interface CreateUserService {
    User createUser(UserRequest request);
}
