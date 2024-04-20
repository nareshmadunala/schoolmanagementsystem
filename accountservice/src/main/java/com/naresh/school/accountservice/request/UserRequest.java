package com.naresh.school.accountservice.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserRequest {

    private Long id;

    @NotEmpty(message = " First Name field Mandatory ")
    private String firstName;

    @NotEmpty(message = " Last Name field Mandatory ")
    private String lastName;

    @NotEmpty(message = " Email field Mandatory ")
    @Email(message = " Not Valid Email ")
    private String email;

    private String DateOfBirth;

    private String gender;

    private String type;

    private String status;

}
