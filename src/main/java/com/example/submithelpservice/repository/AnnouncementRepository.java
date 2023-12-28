package com.example.submithelpservice.repository;

import com.example.submithelpservice.model.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncementRepository extends JpaRepository<Announcement,Long> {
}
