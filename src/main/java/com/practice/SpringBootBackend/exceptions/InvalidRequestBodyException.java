package com.practice.SpringBootBackend.exceptions;

public class InvalidRequestBodyException extends RuntimeException{
    
    public InvalidRequestBodyException(String body){
        super("InvalidRequestBody: " + body);
    }

}
