package com.example.submithelpservice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@DiscriminatorValue("things_donater")
public class ThingsDonater extends VolunteerInfo {


}
