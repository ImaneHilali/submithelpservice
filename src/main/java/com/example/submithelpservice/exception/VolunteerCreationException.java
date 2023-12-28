package com.example.submithelpservice.exception;

public class VolunteerCreationException extends RuntimeException {
    public VolunteerCreationException() {
        super("Invalid volunteer type");
    }
}
