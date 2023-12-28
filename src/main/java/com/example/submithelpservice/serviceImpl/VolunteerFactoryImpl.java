package com.example.submithelpservice.serviceImpl;
import com.example.submithelpservice.dto.VolunteerRequestDTO;
import com.example.submithelpservice.exception.VolunteerCreationException;
import com.example.submithelpservice.model.*;
import com.example.submithelpservice.service.TargetService;
import com.example.submithelpservice.service.VolunteerFactory;
import org.springframework.stereotype.Service;

@Service
public class VolunteerFactoryImpl implements VolunteerFactory {

    final TargetService targetService;

    public VolunteerFactoryImpl(TargetService targetService) {
        this.targetService = targetService;
    }

    @Override
    public VolunteerInfo createVolunteer(VolunteerRequestDTO volunteerRequestDTO, Target target) {

        return switch ((target.getAnnouncement().getAuthorization().getId()).intValue()) {
            case 1 -> createBloodDonater(volunteerRequestDTO, target);
            case 2 -> createMoneyDonater(volunteerRequestDTO, target);
            case 3 -> createThingsDonater(volunteerRequestDTO, target);
            case 4 -> createVolunteerDonater(volunteerRequestDTO, target);
            default -> throw new VolunteerCreationException();
        };
    }

    public BloodDonater createBloodDonater(VolunteerRequestDTO volunteerRequestDTO, Target target) {

        BloodDonater bloodDonater = new BloodDonater();
        setCommonAttributes(bloodDonater, volunteerRequestDTO, target);
        bloodDonater.setBloodType(volunteerRequestDTO.getBloodType());
        bloodDonater.setNumber(1L);

        return bloodDonater;
    }

    public MoneyDonater createMoneyDonater(VolunteerRequestDTO volunteerRequestDTO, Target target) {

        MoneyDonater moneyDonater = new MoneyDonater();
        setCommonAttributes(moneyDonater, volunteerRequestDTO, target);
        moneyDonater.setCardNumber(volunteerRequestDTO.getCardNumber());
        moneyDonater.setDateExpiration(volunteerRequestDTO.getDateExpiration());
        moneyDonater.setCvc(volunteerRequestDTO.getCvc());
        moneyDonater.setNumber(volunteerRequestDTO.getNumber());
        moneyDonater.setIsConfirmed(true);

        targetService.updateTarget(target,volunteerRequestDTO.getNumber().intValue());

        return moneyDonater;
    }

    public ThingsDonater createThingsDonater(VolunteerRequestDTO volunteerRequestDTO, Target target) {

        ThingsDonater thingsDonater = new ThingsDonater();
        setCommonAttributes(thingsDonater, volunteerRequestDTO, target);
        thingsDonater.setNumber(volunteerRequestDTO.getNumber());

        return thingsDonater;
    }

    public Volunteer createVolunteerDonater(VolunteerRequestDTO volunteerRequestDTO, Target target) {

        Volunteer volunteer = new Volunteer();

        setCommonAttributes(volunteer, volunteerRequestDTO, target);
        volunteer.setSexe(volunteerRequestDTO.getSexe());
        volunteer.setDescription(volunteerRequestDTO.getDescription());
        volunteer.setNumber(1L);

        return volunteer;
    }

    public void setCommonAttributes(VolunteerInfo volunteerInfo, VolunteerRequestDTO volunteerRequestDTO, Target target) {

        volunteerInfo.setFullName(volunteerRequestDTO.getFullName());
        volunteerInfo.setPhone(volunteerRequestDTO.getPhone());
        volunteerInfo.setAddress(volunteerRequestDTO.getAddress());
        volunteerInfo.setTarget(target);
        volunteerInfo.setIsConfirmed(null);
    }

}
