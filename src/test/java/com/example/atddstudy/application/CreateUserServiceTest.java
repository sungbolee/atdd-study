package com.example.atddstudy.application;

import com.example.atddstudy.domain.User;
import com.example.atddstudy.domain.UserRepository;
import com.example.atddstudy.infra.UserRepositoryMemoryImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateUserServiceTest {

    private UserRepository userRepository = new UserRepositoryMemoryImpl();
    private CreateUserService createUserService = new CreateUserServiceImpl(userRepository);

    @Test
    void createUser() {
        String loginId = "loginId";
        String name = "name";
        String password = "password";
        UserRequest request = UserRequest.of(loginId, name, password);

        User user = createUserService.createUser(request);
        assertThat(user.getId()).isPositive();
    }
}
