package com.example.submithelpservice.model;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "volunteer_type", discriminatorType = DiscriminatorType.STRING)
public abstract class VolunteerInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    private String phone;

    private String address;

    private Long number;

    private Boolean isConfirmed;

    @ManyToOne
    @JoinColumn(name = "target_id")
    private Target target;

 }
