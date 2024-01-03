package com.example.submithelpservice.service;

import com.example.submithelpservice.dto.VolunteerRequestDTO;
import com.example.submithelpservice.model.Target;
import com.example.submithelpservice.model.VolunteerInfo;
import com.example.submithelpservice.response.VolunteerInfoResponse;

import javax.swing.text.TableView;
import java.util.List;

public interface VolunteerInfoService {

     public void createVolunteer(VolunteerRequestDTO volunteerRequestDTO);

     public void submitHelp(VolunteerInfo volunteerInfo);

     public void cancelHelp(VolunteerInfo volunteerInfo);

     public VolunteerInfo getVolunteerById(Long id);

     public List<VolunteerInfoResponse> getVolunteersByAnnouncementId(Long id);

     public Long getTypeByAnnouncementId(Long id);



}
