package com.mariugo.spring_jwt_api.exception;


public class SpringException extends RuntimeException {

    public SpringException(String message, Exception exception) {
        super(message);
    }

    public SpringException(String message){
        super(message);
    }
}
