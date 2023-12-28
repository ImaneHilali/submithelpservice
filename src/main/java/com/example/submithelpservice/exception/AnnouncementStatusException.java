package com.example.submithelpservice.exception;

public class AnnouncementStatusException extends RuntimeException{

    public AnnouncementStatusException(){ super(" You can't create volunteer for inactive announcement !");}

}
