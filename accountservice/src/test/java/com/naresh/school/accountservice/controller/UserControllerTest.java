package com.naresh.school.accountservice.controller;

import com.naresh.school.accountservice.response.UserResponse;
import com.naresh.school.accountservice.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
@AutoConfigureMockMvc(addFilters = false)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    List<UserResponse> userResponseList = new ArrayList<>();

    @BeforeEach
    void setUp() {

        UserResponse userResponse = new UserResponse();
        userResponse.setId(Long.parseLong("1"));
        userResponse.setFirstName("Naresh");
        userResponse.setLastName("kumar");
        userResponse.setEmail("naresh@kumar.com");
        userResponse.setDateOfBirth("1988-10-10");
        userResponse.setGender("m");
        userResponse.setType("s");
        userResponse.setStatus("active");

        userResponseList.add(userResponse);

        Mockito.when(userService.getUsers()).thenReturn(userResponseList);

    }

    @AfterEach
    void tearDown() {
        this.userResponseList = null;
    }

    @Test
    void getUsers() throws Exception {
        this.mockMvc.perform(get("/api/v1/users"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void getUserProfile() {
    }

    @Test
    void addUser() {
    }

    @Test
    void deleteUser() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void getUserByEmail() {
    }
}