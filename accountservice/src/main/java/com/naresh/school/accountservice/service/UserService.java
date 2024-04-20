package com.naresh.school.accountservice.service;

import java.util.List;

import com.naresh.school.accountservice.request.UserRequest;
import com.naresh.school.accountservice.response.UserResponse;

public interface UserService {

    UserResponse addUser(UserRequest userRequest);

    List<UserResponse> getUsers();

    String deleteUser(Long id);

    UserResponse updateUser(UserRequest userRequest);

    UserResponse getUserByEmail(String email);


}
