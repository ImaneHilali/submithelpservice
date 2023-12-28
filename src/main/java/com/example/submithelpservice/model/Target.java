package com.example.submithelpservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Target {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer currentValue;
    private Integer targetValue;

    @ManyToOne
    @JoinColumn(name ="announcement_id")
    Announcement announcement;

    @OneToMany(mappedBy = "target")
    private List<VolunteerInfo> volunteerInfos;

}
