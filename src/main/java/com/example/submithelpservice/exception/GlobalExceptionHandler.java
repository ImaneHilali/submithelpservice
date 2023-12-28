package com.example.submithelpservice.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TokenNotValidException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String handelTokenNotValidException(TokenNotValidException e){
        return e.getMessage();
    }

    @ExceptionHandler(VolunteerCreationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handelVolunteerCreationException(VolunteerCreationException e){
        return e.getMessage();
    };

    @ExceptionHandler(VolunteerInfoIsAlreadyConfirmedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handelVolunteerInfoIsAlreadyConfirmedException(VolunteerInfoIsAlreadyConfirmedException e){
        return e.getMessage();
    };

    @ExceptionHandler(VolunteerNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handelVolunteerVolunteerNotFoundException(VolunteerNotFoundException e){
        return e.getMessage();
    };
    @ExceptionHandler(AnnouncementNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handelAnnouncementNotFoundException(AnnouncementNotFoundException e){
        return e.getMessage();
    };

    @ExceptionHandler(AnnouncementStatusException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handelAnnouncementStatusException(AnnouncementStatusException e){
        return e.getMessage();
    };

    @ExceptionHandler(TargetNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handelTargetNotFoundException(TargetNotFoundException e){
        return e.getMessage();
    };

}