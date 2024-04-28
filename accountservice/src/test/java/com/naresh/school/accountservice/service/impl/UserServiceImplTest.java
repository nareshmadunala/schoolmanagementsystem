package com.naresh.school.accountservice.service.impl;

import com.naresh.school.accountservice.mapper.UserMapper;
import com.naresh.school.accountservice.model.User;
import com.naresh.school.accountservice.repository.UserRepository;
import com.naresh.school.accountservice.response.UserResponse;
import com.naresh.school.accountservice.service.UserService;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class UserServiceImplTest {


    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    AutoCloseable autoCloseable;

    List<UserResponse> userResponses;


    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);

        User user = new User();
        user.setId(Long.parseLong("1"));
        user.setFirstName("Naresh");
        user.setLastName("kumar");
        user.setEmail("naresh@kumar.com");
        user.setDateOfBirth("1988-10-10");
        user.setGender("m");
        user.setType("s");
        user.setStatus("active");

        userResponses = new ArrayList<>();
        userResponses.add(userMapper.convertUserToUserResponse(user));

        List<User> users = new ArrayList<>();
        users.add(user);

        Mockito.when(userRepository.findAll()).thenReturn(users);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
        userResponses = null;

    }

    @Test
    void addUser() {
    }

    @Test
    void getUsers() {
        List<UserResponse>  userResponses = userService.getUsers();
        Assertions.assertIterableEquals( this.userResponses, userResponses);
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

    @Test
    void getUserProfile() {
    }
}