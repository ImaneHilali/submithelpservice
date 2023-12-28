package com.example.submithelpservice.service;


import com.example.submithelpservice.dto.UserDetailsDto;

public interface UserService {
    public UserDetailsDto getUserDetailsFromOtherService(String serviceUrl, String token);

    public boolean isAdmin(String token, String url);

    public boolean isOrganization(String token, String url);

    public String getEmail(String token, String url);
}