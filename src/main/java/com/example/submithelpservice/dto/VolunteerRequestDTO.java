package com.example.submithelpservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class VolunteerRequestDTO {

    private Long id;

    @NotBlank(message = "Full name is required")
    private String fullName;

    @NotBlank(message = "Phone number is required")
    private String phone;

    @NotBlank(message = "Address is required")
    private String address;

    private String volunteerType;

    private String sexe;

    private String description;

    private String bloodType;

    private Long cardNumber;

    private String dateExpiration;

    private Long cvc;

    private Long number;

    private Boolean isConfirmed;

    @NotNull(message = "Target ID is required")
    private Long targetId;

}
