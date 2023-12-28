package com.example.submithelpservice.service;

import com.example.submithelpservice.model.Target;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TargetService{
    public Target getTarget(Long id);
    void updateTarget(Target target, int contributionAmount);

}
