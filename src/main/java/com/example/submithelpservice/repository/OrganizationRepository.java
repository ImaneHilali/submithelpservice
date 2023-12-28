package com.example.submithelpservice.repository;

import com.example.submithelpservice.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization,Long> {
}
