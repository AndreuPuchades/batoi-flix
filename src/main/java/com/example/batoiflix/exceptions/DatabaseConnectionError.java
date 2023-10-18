package com.example.batoiflix.exceptions;

public class DatabaseConnectionError extends RuntimeException{
    public DatabaseConnectionError(String message){
        super(message);
    }
}