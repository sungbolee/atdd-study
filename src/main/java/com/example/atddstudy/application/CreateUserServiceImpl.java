package com.example.atddstudy.application;

import com.example.atddstudy.domain.User;
import com.example.atddstudy.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserServiceImpl implements CreateUserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(UserRequest request) {
        User user = new User(request.getLoginId(), request.getName(), request.getPassword());
        return userRepository.save(user);
    }
}
