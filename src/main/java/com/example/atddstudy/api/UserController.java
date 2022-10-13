package com.example.atddstudy.api;

import com.example.atddstudy.application.CreateUserService;
import com.example.atddstudy.application.UserRequest;
import com.example.atddstudy.application.UserResponse;
import com.example.atddstudy.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final CreateUserService createUserService;

    @PostMapping("/users")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request) {
        User user = createUserService.createUser(request);
        UserResponse response = new UserResponse(user);
        return ResponseEntity.ok(response);
    }
}
