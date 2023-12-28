package com.example.submithelpservice.serviceImpl;

import com.example.submithelpservice.dto.VolunteerRequestDTO;
import com.example.submithelpservice.enums.Status;
import com.example.submithelpservice.exception.*;
import com.example.submithelpservice.model.*;
import com.example.submithelpservice.repository.VolunteerInfoRepository;
import com.example.submithelpservice.response.VolunteerInfoResponse;
import com.example.submithelpservice.service.TargetService;
import com.example.submithelpservice.service.VolunteerFactory;
import com.example.submithelpservice.service.VolunteerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class VolunteerInfoServiceImpl implements VolunteerInfoService {

    private final VolunteerFactory volunteerFactory;
    private final VolunteerInfoRepository volunteerInfoRepository;
    private final TargetService targetService;


    @Autowired
    public VolunteerInfoServiceImpl(VolunteerFactory volunteerFactory, VolunteerInfoRepository volunteerInfoRepository, TargetService targetService) {

        this.volunteerFactory = volunteerFactory;
        this.volunteerInfoRepository = volunteerInfoRepository;
        this.targetService = targetService;
    }


    @Transactional
    @Override
    public void createVolunteer(VolunteerRequestDTO volunteerRequestDTO) {

        Target target= targetService.getTarget(volunteerRequestDTO.getTargetId());

        if (target.getAnnouncement().getStatus() == Status.ACTIVE) {
            VolunteerInfo volunteer = volunteerFactory.createVolunteer(volunteerRequestDTO, target);
            volunteerInfoRepository.save(volunteer);
        } else {
            throw new AnnouncementStatusException();
        }
    }

    @Override
    public void submitHelp(VolunteerInfo volunteerInfo) {

        Target target = volunteerInfo.getTarget();
        if (volunteerInfo.getIsConfirmed()!=null){
            throw new VolunteerInfoIsAlreadyConfirmedException();
        }
        if (target != null) {
            targetService.updateTarget(target,volunteerInfo.getNumber().intValue());
            volunteerInfo.setIsConfirmed(true);
            volunteerInfoRepository.save(volunteerInfo);
        }
        else {
            throw new TargetNotFoundException();
        }
    }

    @Override
    public void cancelHelp(VolunteerInfo volunteerInfo) {

        Target target = volunteerInfo.getTarget();
        if (volunteerInfo.getIsConfirmed()!=null){
            throw new VolunteerInfoIsAlreadyConfirmedException();
        }
        if (target != null) {
            volunteerInfo.setIsConfirmed(false);
            volunteerInfoRepository.save(volunteerInfo);
        }
        else {
            throw new TargetNotFoundException();
        }
    }

    @Override
    public VolunteerInfo getVolunteerById(Long id) {

        return volunteerInfoRepository.findById(id)
                .orElseThrow(VolunteerNotFoundException::new);
    }

    @Override
    public List<VolunteerInfoResponse> getVolunteersByAnnouncementId(Long id) {

        List<VolunteerInfo> volunteerInfos= volunteerInfoRepository.findByTargetAnnouncementId(id)
                .orElseThrow(AnnouncementNotFoundException::new);

        List<VolunteerInfoResponse> volunteerInfoResponses = new ArrayList<>();

        for (VolunteerInfo volunteerInfo : volunteerInfos){

            VolunteerInfoResponse volunteerInfoResponse = getVolunteerInfoResponse(volunteerInfo);

            volunteerInfoResponses.add(volunteerInfoResponse);

        }

        return volunteerInfoResponses;
    }

    private static VolunteerInfoResponse getVolunteerInfoResponse(VolunteerInfo volunteerInfo) {

        VolunteerInfoResponse volunteerInfoResponse = new VolunteerInfoResponse();

        volunteerInfoResponse.setId(volunteerInfo.getId());
        volunteerInfoResponse.setFullName(volunteerInfo.getFullName());
        volunteerInfoResponse.setPhone(volunteerInfo.getPhone());
        volunteerInfoResponse.setAddress(volunteerInfo.getAddress());
        volunteerInfoResponse.setIsConfirmed(volunteerInfo.getIsConfirmed());
        volunteerInfoResponse.setTargetName(volunteerInfo.getTarget().getName());
        volunteerInfoResponse.setAnnouncementId(volunteerInfo.getTarget().getAnnouncement().getId());
        volunteerInfoResponse.setStatus(volunteerInfo.getTarget().getAnnouncement().getStatus());
        volunteerInfoResponse.setTitle(volunteerInfo.getTarget().getAnnouncement().getTitle());

        return volunteerInfoResponse;
    }

}