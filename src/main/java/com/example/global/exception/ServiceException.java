package com.example.global.exception;

public class ServiceException extends RuntimeException{
    String msg;
    public ServiceException(String msg){
        super(msg);
        this.msg=msg;
    }
}
