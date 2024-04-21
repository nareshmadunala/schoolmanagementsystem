package com.naresh.school.accountservice.service.impl;

import java.util.List;

import com.naresh.school.accountservice.config.JwtProvider;
import com.naresh.school.accountservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.naresh.school.accountservice.mapper.UserMapper;
import com.naresh.school.accountservice.model.User;
import com.naresh.school.accountservice.repository.UserRepository;
import com.naresh.school.accountservice.request.UserRequest;
import com.naresh.school.accountservice.response.UserResponse;
import com.naresh.school.accountservice.service.UserService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private NotificationService notificationService;

    @Override
    @Transactional
    public UserResponse addUser(UserRequest userRequest){
        User user = userMapper.convertUserRequestToUser(userRequest);
        user = userRepository.save(user);
        System.out.println(notificationService.sendEmail());
        UserResponse userResponse = userMapper.convertUserToUserResponse(user);
        return userResponse;
    }

    @Override
    public List<UserResponse> getUsers(){
        List<User> users = userRepository.findAll();
        List<UserResponse> userResponses = users.stream().map(user->userMapper.convertUserToUserResponse(user)).toList();
        return userResponses;
    }


    @Override
    public String deleteUser(Long id) {
         userRepository.deleteById(id);
         return "User with id : "+id+" deleted";
    }


    @Override
    public UserResponse updateUser(UserRequest userRequest) {
        User user = userMapper.convertUserRequestToUser(userRequest);
        user = userRepository.save(user);
        UserResponse userResponse = userMapper.convertUserToUserResponse(user);
        return userResponse;
    }

    @Override
    public UserResponse getUserByEmail(String email){
        User user = userRepository.findByEmail(email);
        UserResponse userResponse = userMapper.convertUserToUserResponse(user);
        return userResponse;
    }

    @Override
    public UserResponse getUserProfile(String jwt){
        String email = JwtProvider.getEmailFromJwtToken(jwt);
        User user = userRepository.findByEmail(email);
        UserResponse userResponse = userMapper.convertUserToUserResponse(user);
        return userResponse;
    }
}
