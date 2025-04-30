package com.comerce.stockApi.exceptions;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException() {super("Produto Não encontrado");};
    
    public ProductNotFoundException(String message) {super(message);};
    
}
