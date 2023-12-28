package com.example.submithelpservice.dto;

import lombok.Data;

import java.util.Date;

@Data
public class VolunteerRequestDTO {

    private Long id;

    private String fullName;

    private String phone;

    private String address;

    private String volunteerType;

    private String sexe;

    private String description;

    private String bloodType;

    private Long cardNumber;

    private Date dateExpiration;

    private Long cvc;

    private Long number;

    private Boolean isConfirmed;

    private Long targetId;

}
