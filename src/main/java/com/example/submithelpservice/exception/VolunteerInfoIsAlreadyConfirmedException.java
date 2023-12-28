package com.example.submithelpservice.exception;

public class VolunteerInfoIsAlreadyConfirmedException extends RuntimeException{

    public VolunteerInfoIsAlreadyConfirmedException(){
        super("the volunteer is already confirmed or canceled");
    }
}
