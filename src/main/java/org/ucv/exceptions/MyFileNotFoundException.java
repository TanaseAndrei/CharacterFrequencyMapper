package org.ucv.exceptions;

public class MyFileNotFoundException extends RuntimeException{
    public MyFileNotFoundException(String message){
        super(message);
    }
}
