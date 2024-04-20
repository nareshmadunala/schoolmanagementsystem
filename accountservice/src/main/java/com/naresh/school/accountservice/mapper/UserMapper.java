package com.naresh.school.accountservice.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.naresh.school.accountservice.model.User;
import com.naresh.school.accountservice.request.UserRequest;
import com.naresh.school.accountservice.response.UserResponse;

@Component
public class UserMapper {

    @Autowired
    private ModelMapper modelMapper;

    public User convertUserRequestToUser(UserRequest userRequest){
        User user = modelMapper.map(userRequest, User.class);
        return user;
    }

    public UserResponse convertUserToUserResponse(User user){
        UserResponse userResponse = modelMapper.map(user, UserResponse.class);
        return userResponse;
    }

}
