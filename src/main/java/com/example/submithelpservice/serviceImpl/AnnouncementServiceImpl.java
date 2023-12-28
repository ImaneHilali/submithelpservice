package com.example.submithelpservice.serviceImpl;

import com.example.submithelpservice.exception.AnnouncementNotFoundException;
import com.example.submithelpservice.model.Announcement;
import com.example.submithelpservice.repository.AnnouncementRepository;
import com.example.submithelpservice.service.AnnouncementService;
import org.springframework.stereotype.Service;


@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    final AnnouncementRepository announcementRepository;

    public AnnouncementServiceImpl(AnnouncementRepository announcementRepository) {
        this.announcementRepository = announcementRepository;
    }

    @Override
    public Announcement getAnnouncementId(Long id) {
        return announcementRepository.findById(id)
                .orElseThrow(AnnouncementNotFoundException::new);
    }
}
