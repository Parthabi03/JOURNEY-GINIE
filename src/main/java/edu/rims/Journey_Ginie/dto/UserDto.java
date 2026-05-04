package edu.rims.Journey_Ginie.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor
public class UserDto {

    @NotBlank(message = "Name is required")
    private String userName;

    @NotBlank @Email(message = "Enter a valid email")
    private String userEmail;

    @NotBlank @Size(min = 6, message = "Password must be at least 6 characters")
    private String userPassword;

    private String userPhoneNumber;

    @NotBlank(message = "Aadhaar card is required")
    private String userAdharcard;

    private String userGender;
    private String userImageUrl;
}
