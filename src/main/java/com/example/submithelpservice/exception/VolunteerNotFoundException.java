package com.example.submithelpservice.exception;

public class VolunteerNotFoundException extends RuntimeException {
    public VolunteerNotFoundException() { super("Volunteer not found ");
    }
}
