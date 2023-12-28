package com.example.submithelpservice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@DiscriminatorValue("volunteer")
public class Volunteer extends VolunteerInfo{

    private String sexe;

    private String description;

}
