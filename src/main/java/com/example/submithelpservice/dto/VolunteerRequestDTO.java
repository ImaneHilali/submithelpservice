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

    @NotBlank(message = "Volunteer type is required")
    private String volunteerType;

    @NotBlank(message = "sex is required")
    private String sexe;

    private String description;

    @NotBlank(message = "Blood type is required")
    private String bloodType;

    @NotNull(message = "Card number is required")
    private Long cardNumber;

    @NotNull(message = "Expiration date is required")
    private Date dateExpiration;

    @NotNull(message = "CVC is required")
    private Long cvc;

    @NotNull(message = "Number is required")
    private Long number;

    private Boolean isConfirmed;

    @NotNull(message = "Target ID is required")
    private Long targetId;

}
