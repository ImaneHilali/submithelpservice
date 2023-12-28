package com.example.submithelpservice.exception;

public class TokenNotValidException extends RuntimeException{

    public TokenNotValidException(){
        super(" Token not valid");
    }
}
