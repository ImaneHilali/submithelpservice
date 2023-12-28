package com.example.submithelpservice.controller;


import com.example.submithelpservice.dto.VolunteerRequestDTO;
import com.example.submithelpservice.model.Announcement;
import com.example.submithelpservice.model.VolunteerInfo;
import com.example.submithelpservice.service.AnnouncementService;
import com.example.submithelpservice.service.UserService;
import com.example.submithelpservice.service.VolunteerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/volunteerInfo")
public class VolunteerInfoController {

    @Value("${other.service.url}")
    private String authService;

    final VolunteerInfoService volunteerInfoService;

    final UserService userService;

    final AnnouncementService announcementService;

    public VolunteerInfoController(VolunteerInfoService volunteerInfoService, UserService userService, AnnouncementService announcementService) {
        this.volunteerInfoService = volunteerInfoService;
        this.userService = userService;
        this.announcementService = announcementService;
    }

    @PostMapping("/")
    public ResponseEntity<?> createVolunteer(@RequestBody VolunteerRequestDTO volunteerRequestDTO){

        volunteerInfoService.createVolunteer(volunteerRequestDTO);

        return ResponseEntity.status(HttpStatus.OK).body("volunteer has been created");

    }

    @PatchMapping("/confirm/{id}")
    public ResponseEntity<?> confirmVolunteer(@PathVariable Long id,@RequestHeader("Authorization") String token){

        VolunteerInfo volunteerInfo = volunteerInfoService.getVolunteerById(id);

        String organizationEmail = volunteerInfo.getTarget().getAnnouncement().getOrganization().getEmail();
        String userEmail = userService.getEmail(token, authService);
        if (!organizationEmail.equals(userEmail)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("you are not authorized to perform this action");
        }

        volunteerInfoService.submitHelp(volunteerInfo);

        return ResponseEntity.status(HttpStatus.OK).body("help has been submitted");

    }

    @PatchMapping("/cancel/{id}")
    public ResponseEntity<?> cancelVolunteer(@PathVariable Long id,@RequestHeader("Authorization") String token){

        VolunteerInfo volunteerInfo = volunteerInfoService.getVolunteerById(id);

        String organizationEmail = volunteerInfo.getTarget().getAnnouncement().getOrganization().getEmail();
        String userEmail = userService.getEmail(token, authService);
        if (!organizationEmail.equals(userEmail)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("you are not authorized to perform this action");
        }

        volunteerInfoService.cancelHelp(volunteerInfo);

        return ResponseEntity.status(HttpStatus.OK).body("help has been canceled");
    }

    @GetMapping("/announcement/{id}")
    public ResponseEntity<?> getVolunteersByAnnouncementID(@PathVariable Long id,@RequestHeader("Authorization") String token){

        Announcement announcement = announcementService.getAnnouncementId(id);

        String organizationEmail = announcement.getOrganization().getEmail();
        String userEmail = userService.getEmail(token, authService);
        if (!organizationEmail.equals(userEmail)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("you cannot do this action");
        }

        return ResponseEntity.status(HttpStatus.OK).body(volunteerInfoService.getVolunteersByAnnouncementId(id));
    }

}
