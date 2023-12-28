package com.example.submithelpservice.serviceImpl;

import com.example.submithelpservice.model.Target;
import com.example.submithelpservice.repository.TargetRepository;
import com.example.submithelpservice.service.TargetService;
import org.springframework.stereotype.Service;
import com.example.submithelpservice.exception.TargetNotFoundException;

@Service
public class TargetServiceImpl implements TargetService {

    final TargetRepository targetrepository;

    public TargetServiceImpl(TargetRepository targetrepository) {
        this.targetrepository = targetrepository;
    }

    public Target getTarget(Long id) {

        return targetrepository.findById(id).orElseThrow(
                TargetNotFoundException::new
        );
    }

    @Override
    public void updateTarget(Target target, int contributionAmount) {

        int newValue = target.getCurrentValue() + contributionAmount;
        target.setCurrentValue(newValue);

        targetrepository.save(target);
    }
}
