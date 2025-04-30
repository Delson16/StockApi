package com.comerce.stockApi.exceptions;

public class InvalidDataException extends RuntimeException{
    
    public InvalidDataException(){super("Dados inválidos");};
    
    public InvalidDataException(String message){super(message);};
    
}
