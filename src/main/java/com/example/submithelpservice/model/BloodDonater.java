package com.example.submithelpservice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@DiscriminatorValue("blood_donater")
public class BloodDonater extends VolunteerInfo{

    private String bloodType;

}
