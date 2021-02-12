package com.resgistration_app.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

// lombok: @Data, @NoArgsConstructor, @AllArgsConstructor
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationDto {

    // firstname, lastname, email, password
    @NotBlank(message = "First name is mandatory")
    @Size(min = 2, max = 16)
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    @Size(min = 2, max = 16)
    private String lastName;

    @NotBlank(message = "Email address is mandatory")
    @Size(min = 5, max = 20)
    @Email
    private String email;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 4, max = 16)
    private String password;

}

