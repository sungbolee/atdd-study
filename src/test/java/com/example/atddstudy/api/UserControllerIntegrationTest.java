package com.example.atddstudy.api;

import com.example.atddstudy.application.UserRequest;
import com.example.atddstudy.application.UserResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

    @Autowired private MockMvc mockMvc;
    @Autowired private ObjectMapper objectMapper;

    @Test
    void createUserTest() throws Exception {
        //given
        String loginId = "loginId";
        String name = "name";
        String password = "password";
        UserRequest request = UserRequest.of(loginId, name, password);

        //when
        MockHttpServletResponse response = mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andReturn().getResponse();
        
        //then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        UserResponse userResponse = objectMapper.readValue(response.getContentAsString(), UserResponse.class);
        assertThat(userResponse.getId()).isGreaterThan(0);
    }
}
