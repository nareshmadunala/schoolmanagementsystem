package com.naresh.school.accountservice.controller;

import java.util.List;

import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import com.naresh.school.accountservice.request.UserRequest;
import com.naresh.school.accountservice.response.UserResponse;
import com.naresh.school.accountservice.service.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    public UserService userService;


    @GetMapping
    @Cacheable(cacheNames = "users")
    public List<UserResponse> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/profile")
    public UserResponse getUserProfile(@RequestHeader("Authorization") String jwt){
        return userService.getUserProfile(jwt);
    }

    @PostMapping
    public UserResponse addUser(@Valid @RequestBody UserRequest userRequest){
        return userService.addUser(userRequest);
    }

    @DeleteMapping
    @CacheEvict(cacheNames = "users", key = "#id")
    public String deleteUser(@RequestParam Long id){
        return userService.deleteUser(id);
    }

    @PutMapping
    @CachePut(cacheNames = "users", key = "#userRequest.id")
    public UserResponse updateUser(@RequestBody UserRequest userRequest){
        return userService.updateUser(userRequest);
    }

    @GetMapping("/{email}")
    public UserResponse getUserByEmail(@PathVariable String email){
        return userService.getUserByEmail(email);
    }

}

