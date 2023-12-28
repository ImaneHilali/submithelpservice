package com.example.submithelpservice.response;

import com.example.submithelpservice.enums.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class VolunteerInfoResponse {

    private Long id;

    private String fullName;

    private String phone;

    private String address;

    private Boolean isConfirmed;

    private String targetName;

    private Long announcementId;

    private String title;

    @Enumerated(EnumType.STRING)
    private Status status;

}