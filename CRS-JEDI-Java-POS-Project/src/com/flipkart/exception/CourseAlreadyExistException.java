package com.flipkart.exception;

public class CourseAlreadyExistException extends Exception{
    public CourseAlreadyExistException(String message){
        super(message);
    }
}
