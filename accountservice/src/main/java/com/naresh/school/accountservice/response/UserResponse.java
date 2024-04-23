package com.naresh.school.accountservice.response;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class UserResponse implements Serializable {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String DateOfBirth;

    private String gender;

    private String type;

    private String status;
    
}
