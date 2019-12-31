package com.qdu.exception;

public class RegisterException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public RegisterException(String message){
        super(message);
    }
}
