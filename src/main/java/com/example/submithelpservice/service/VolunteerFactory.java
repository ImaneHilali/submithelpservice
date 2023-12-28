package com.example.submithelpservice.service;

import com.example.submithelpservice.dto.VolunteerRequestDTO;
import com.example.submithelpservice.model.*;

public interface VolunteerFactory {

    public VolunteerInfo createVolunteer(VolunteerRequestDTO volunteerRequestDTO, Target target);

    public BloodDonater createBloodDonater(VolunteerRequestDTO volunteerRequestDTO, Target target);

    public MoneyDonater createMoneyDonater(VolunteerRequestDTO volunteerRequestDTO, Target target);

    public ThingsDonater createThingsDonater(VolunteerRequestDTO volunteerRequestDTO, Target target);

    public Volunteer createVolunteerDonater(VolunteerRequestDTO volunteerRequestDTO, Target target);

    public void setCommonAttributes(VolunteerInfo volunteerInfo, VolunteerRequestDTO volunteerRequestDTO, Target target);
}
