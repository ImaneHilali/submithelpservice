package com.example.submithelpservice.response;

import lombok.Data;

@Data
public class HelpFormResponse {
    private Long targetId;

    private Long authorizationId;

    private String announcementName;

    private String targetName;

}
