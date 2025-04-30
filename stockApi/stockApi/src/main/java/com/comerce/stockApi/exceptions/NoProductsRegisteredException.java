package com.comerce.stockApi.exceptions;

public class NoProductsRegisteredException extends RuntimeException{
    
    public NoProductsRegisteredException () {super("Nenhum produto cadastrado no sistema");};
    
    public NoProductsRegisteredException (String message) {super(message);};
    
}
