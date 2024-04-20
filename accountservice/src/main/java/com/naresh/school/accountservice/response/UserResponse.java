package com.naresh.school.accountservice.response;

import lombok.Data;

@Data
public class UserResponse {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String DateOfBirth;

    private String gender;

    private String type;

    private String status;
    
}
