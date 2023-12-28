package com.example.submithelpservice.repository;

import com.example.submithelpservice.dto.VolunteerRequestDTO;
import com.example.submithelpservice.model.VolunteerInfo;
import com.example.submithelpservice.response.VolunteerInfoResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VolunteerInfoRepository extends JpaRepository<VolunteerInfo,Long> {

    public Optional<List<VolunteerInfo>> findByTargetAnnouncementId(Long id);
}
