package com.microservices.hospital.userService.exception;

public class ResourceNotFoundException extends  RuntimeException{

    public ResourceNotFoundException(){
        super("ResourceNotFoundException");
    }

    public ResourceNotFoundException(String msg){
        super(msg);

    }

}
