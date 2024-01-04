package com.example.submithelpservice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@DiscriminatorValue("money_donater")
public class MoneyDonater extends VolunteerInfo{

    private Long cardNumber;

    private String dateExpiration;

    private Long cvc;

}
